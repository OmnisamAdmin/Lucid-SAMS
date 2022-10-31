package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.sams.vo.StaffCalendarTermsRequest;
import za.co.sfy.sams.lucid.schema.StaffCalendarTerms;

@Component
public class StaffCalendarTermsMapper {

    private final SharedMapper sharedMapper;

    public StaffCalendarTermsMapper(final SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public StaffCalendarTerms StaffCalendarTermsRequestToStaffCalendarTerms(StaffCalendarTermsRequest staffCalendarTermsRequest) throws LucidSamsExecutionException {

        StaffCalendarTerms staffCalendarTerms = new StaffCalendarTerms();
        
        String currentYear = staffCalendarTermsRequest.getCurrentYear();
        if (null != currentYear) {
        staffCalendarTerms.setCurrentYear(staffCalendarTermsRequest.getCurrentYear());
        }

        String endDate = staffCalendarTermsRequest.getEndDate();
        if (null != endDate) {
            staffCalendarTerms.setEndDate(sharedMapper.dateToXMLGregorianCalendar(endDate));
        }

        Integer id = staffCalendarTermsRequest.getId();
        if (null != id) {
        staffCalendarTerms.setId(id);
        }
        
        String quater = staffCalendarTermsRequest.getQuater();
        if (null != quater) {
        staffCalendarTerms.setQuater(staffCalendarTermsRequest.getQuater());
        }

        String startDate = staffCalendarTermsRequest.getStartDate();
        if (null != startDate) {
            staffCalendarTerms.setStartDate(sharedMapper.dateToXMLGregorianCalendar(startDate));
        }
        
        Integer term = staffCalendarTermsRequest.getTerm();
        if (null != term) {
        staffCalendarTerms.setTerm(term);
        }

        return staffCalendarTerms;
    }
}