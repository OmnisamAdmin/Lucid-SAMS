package za.co.sfy.lucid.sams.rest.service;

import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.EducatorCalendarTermsResource;
import za.co.sfy.lucid.sams.resource.EducatorsResource;
import za.co.sfy.lucid.sams.resource.StaffCalendarTermsResource;
import za.co.sfy.lucid.sams.resource.StaffLeaveResource;
import za.co.sfy.lucid.sams.resource.util.DateUtil;
import za.co.sfy.lucid.sams.rest.mapper.StaffLeaveMapper;
import za.co.sfy.sams.vo.StaffLeaveRequest;
import za.co.sfy.sams.vo.StaffLeaveResponse;
import za.co.sfy.sams.lucid.schema.StaffLeave;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author muzim
 */
@Service
public class StaffLeaveService {

    private static final String EDUCATOR = "Educator";
    private static final String STAFF = "Staff";
    private static final Integer MAX_DIFFERENCE_IN_DAYS = 4;
    private static final List<String> personnelCategories = Arrays.asList(EDUCATOR, STAFF);
    private final StaffLeaveMapper staffLeaveMapper;
    private final StaffLeaveResource staffLeaveResource;
    private final EducatorsResource educatorsResource;
    private final StaffCalendarTermsResource staffCalendarTermsResource;
    private final EducatorCalendarTermsResource educatorCalendarTermsResource;
    private final DateUtil dateConverter = new DateUtil();

    public StaffLeaveService(final StaffLeaveMapper staffLeaveMapper, final StaffLeaveResource staffLeaveResource
            , final EducatorsResource educatorsResource, final StaffCalendarTermsResource staffCalendarTermsResource
            , final EducatorCalendarTermsResource educatorCalendarTermsResource) {
        this.staffLeaveMapper = staffLeaveMapper;
        this.staffLeaveResource = staffLeaveResource;
        this.staffCalendarTermsResource = staffCalendarTermsResource;
        this.educatorsResource = educatorsResource;
        this.educatorCalendarTermsResource = educatorCalendarTermsResource;
    }

    public StaffLeaveResponse saveStaffLeaveService(StaffLeaveRequest staffLeaveRequest) throws LucidSamsExecutionException {

        StaffLeave staffLeave = staffLeaveMapper.staffLeaveRequestToStaffLeave(staffLeaveRequest);

        String personnelCategory = staffLeave.getPersonnelCategory();
        if (!personnelCategories.contains(personnelCategory)) {
            throw new LucidSamsExecutionException("The given personnelCategory - " + personnelCategory + " is invalid");
        }

        Integer linkID = staffLeave.getLinkId();

        ResultSet retrievedEducatorsOrStaff = null;
        if (EDUCATOR.equals(personnelCategory)) {
            retrievedEducatorsOrStaff = educatorsResource.retrieveEducatorsByID(Long.valueOf(linkID));
        } else if (STAFF.equals(personnelCategory)) {
            throw new LucidSamsExecutionException("'StaffMembers' resource is unimplemented");
            //TODO: May need to be implemented in future
        }

        try {
            if (!retrievedEducatorsOrStaff.next()) {
                throw new LucidSamsExecutionException("The given Educators/Staff 'LinkID' - " + linkID + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        String replaced = staffLeave.getReplaced();
        if (replaced.equalsIgnoreCase("No")) {
            staffLeave.setReplaced("No");
        } else if (replaced.equalsIgnoreCase("Yes")) {
            staffLeave.setReplaced("Yes");
        } else {
            throw new LucidSamsExecutionException("Invalid input, the 'replaced' field value can only be 'Yes' or 'No'.");
        }

        Date dateStart = dateConverter.toUtilDate(staffLeave.getDateStart());
        String stringDateStart = dateConverter.toStringDate(dateStart);
        if (new Date().compareTo(dateStart) < 0) {
            throw new LucidSamsExecutionException("Start date cannot be backdated from the current date: "
                    + stringDateStart + "");
        }

        Date dateEnd = dateConverter.toUtilDate(staffLeave.getDateEnd());
        String stringDateEnd = dateConverter.toStringDate(dateEnd);
        if (new Date().compareTo(dateEnd) < 0) {
            throw new LucidSamsExecutionException("End date cannot be backdated from the current date: "
                    + stringDateEnd + "");
        }

        if (dateStart.compareTo(dateEnd) > 0) {
            throw new LucidSamsExecutionException("The start date(" + stringDateStart
                    + ") cannot be after the end date(" + stringDateEnd + ")");
        }

        Integer days = staffLeave.getDays();
        Integer calculatedDays = Math.toIntExact(dateConverter.calculateDifferenceInDays(dateEnd, dateStart)) + 1;
        if (!calculatedDays.equals(days)) {
            throw new LucidSamsExecutionException("The submitted days value '" + days + "' is incongruent with the days " +
                    "derived from the submitted start date and end date which is '" + calculatedDays + "'");
        }

        Date weekID = dateConverter.toUtilDate(staffLeave.getWeekID());
        String stringWeekID = dateConverter.toStringDate(weekID);
        if (!dateConverter.isTargetDay(Calendar.FRIDAY, weekID)) {
            throw new LucidSamsExecutionException("The given weekID '" + stringWeekID + "' is not a friday");
        }

        if (dateStart.compareTo(weekID) > 0) {
            throw new LucidSamsExecutionException("The start date cannot be after the weekID: " + stringDateStart
                    + " > " + stringWeekID);
        } else if (dateStart.compareTo(weekID) < 0) {
            Integer differenceInDays = Math.toIntExact(dateConverter.calculateDifferenceInDays(weekID, dateStart));
            if (differenceInDays > MAX_DIFFERENCE_IN_DAYS) {
                throw new LucidSamsExecutionException("The start date cannot be more than 4 days before the weekID" +
                        ", it has to be in the same week");
            }
        } else if (!dateEnd.equals(weekID)) {
            if (dateEnd.compareTo(weekID) > 0) {
                throw new LucidSamsExecutionException("The end date cannot be after the weekID: " + stringDateEnd
                        + " > " + stringWeekID);
            }
        }

        String currentYear = staffLeave.getYear();
        ResultSet retrievedCalendarTerms = null;

        if (EDUCATOR.equals(personnelCategory)) {
            retrievedCalendarTerms = educatorCalendarTermsResource.retrieveEducatorCalendarTermsByYear(currentYear);
        } else if (STAFF.equals(personnelCategory)) {
            retrievedCalendarTerms = staffCalendarTermsResource.retrieveStaffCalendarTermsByYear(currentYear);
        }

        Boolean foundTermToValidInsert = Boolean.FALSE;

        while (true) {
            try {
                assert retrievedCalendarTerms != null;
                if (!retrievedCalendarTerms.next()) break;
                Date retrievedStartDate = dateConverter.toUtilDate(retrievedCalendarTerms.getDate("StartDate"));
                Date retrievedEndDate = dateConverter.toUtilDate(retrievedCalendarTerms.getDate("EndDate"));

                if (dateStart.compareTo(retrievedStartDate) >= 0 && dateEnd.compareTo(retrievedEndDate) <= 0) {
                    foundTermToValidInsert = Boolean.TRUE;
                    break;
                }

            } catch (SQLException exception) {
                throw new LucidSamsExecutionException(exception.getMessage(), exception);
            }
        }

        if (Boolean.FALSE.equals(foundTermToValidInsert)) {
            throw new LucidSamsExecutionException("Could not find a term to insert data for the provided request ," +
                    "please consider your provided start and end date");
        }

        Long generatedKey = staffLeaveResource.save(staffLeave, staffLeaveResource);
        staffLeave.setId(Math.toIntExact(generatedKey));

        StaffLeaveResponse staffLeaveResponse = new StaffLeaveResponse();
        staffLeaveResponse.setStaffLeave(staffLeave);
        staffLeaveResponse.setResponseMessage("Successfully saved 'StaffLeave' data.");
        staffLeaveResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return staffLeaveResponse;
    }

}
