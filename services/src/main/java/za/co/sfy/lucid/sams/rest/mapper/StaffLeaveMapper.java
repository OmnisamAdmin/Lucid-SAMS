package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.sams.vo.StaffLeaveRequest;
import za.co.sfy.sams.lucid.schema.StaffLeave;

import javax.xml.datatype.XMLGregorianCalendar;


@Component
public class StaffLeaveMapper {

    private final SharedMapper sharedMapper;

    public StaffLeaveMapper(SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public StaffLeave staffLeaveRequestToStaffLeave(StaffLeaveRequest staffLeaveRequest) throws LucidSamsExecutionException {
        StaffLeave staffLeave = new StaffLeave();

        Integer id = staffLeaveRequest.getId();
        if (id != null) {
            staffLeave.setId(id);
        }
        Integer linkId = staffLeaveRequest.getLinkId();
        if (linkId != null) {
            staffLeave.setLinkId(linkId);
        }
        XMLGregorianCalendar dateStart = sharedMapper.dateToXMLGregorianCalendar(staffLeaveRequest.getDateStart());
        if (dateStart != null) {
            staffLeave.setDateStart(dateStart);
        }
        XMLGregorianCalendar dateEnd = sharedMapper.dateToXMLGregorianCalendar(staffLeaveRequest.getDateEnd());
        if (dateEnd != null) {
            staffLeave.setDateEnd(dateEnd);
        }
        String type = staffLeaveRequest.getType();
        if (type != null) {
            staffLeave.setType(type);
        }
        Integer days = staffLeaveRequest.getDays();
        if (days != null) {
            staffLeave.setDays(days);
        }
        String comment = staffLeaveRequest.getComment();
        if (comment != null) {
            staffLeave.setComment(comment);
        }
        String personnelCategory = staffLeaveRequest.getPersonnelCategory();
        if (personnelCategory != null) {
            staffLeave.setPersonnelCategory(personnelCategory);
        }
        String year = staffLeaveRequest.getYear();
        if (year != null) {
            staffLeave.setYear(year);
        }
        String replaced = staffLeaveRequest.getReplaced();
        if (replaced != null) {
            staffLeave.setReplaced(replaced);
        }
        String paid = staffLeaveRequest.getPaid();
        if (paid != null) {
            staffLeave.setPaid(paid);
        }
        String documentation = staffLeaveRequest.getDocumentation();
        if (documentation != null) {
            staffLeave.setDocumentation(documentation);
        }
        Boolean leaveDocRequired = staffLeaveRequest.getLeaveDocRequired();
        if (leaveDocRequired != null) {
            staffLeave.setLeaveDocRequired(leaveDocRequired);
        }
        XMLGregorianCalendar weekID = sharedMapper.dateToXMLGregorianCalendar(staffLeaveRequest.getWeekID());
        if (weekID != null) {
            staffLeave.setWeekID(weekID);
        }
        String tmpField = staffLeaveRequest.getTmpField();
        if (tmpField != null) {
            staffLeave.setTmpField(tmpField);
        }

        return staffLeave;
    }
}