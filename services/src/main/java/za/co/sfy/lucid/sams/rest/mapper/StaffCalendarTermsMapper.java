package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.StaffCalendarTermsRequest;
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
        if(null != currentYear) {
        staffCalendarTerms.setCurrentYear(staffCalendarTermsRequest.getCurrentYear());
        }
        
        staffCalendarTerms.setEndDate(sharedMapper.dateToXMLGregorianCalendar(staffCalendarTermsRequest.getEndDate()));
        
        int id = staffCalendarTermsRequest.getId();
        if(null != id) {
        staffCalendarTerms.setId(Integer.valueOf(id));
        } else {
        	staffCalendarTermsRequest.setId(Integer.valueOf(0));
        }
        
        String quater = staffCalendarTermsRequest.getQuater();
        if(null != quater) {
        staffCalendarTerms.setQuater(staffCalendarTermsRequest.getQuater());
        }
        
        staffCalendarTerms.setStartDate(sharedMapper.dateToXMLGregorianCalendar(staffCalendarTermsRequest.getStartDate()));
        
        Integer term = staffCalendarTermsRequest.getTerm();
        if(null != term) {
        staffCalendarTerms.setTerm(Integer.valueOf(term));
        } else {
        	staffCalendarTermsRequest.setTerm(Integer.valueOf(0));
        }

        return staffCalendarTerms;
    }
}
