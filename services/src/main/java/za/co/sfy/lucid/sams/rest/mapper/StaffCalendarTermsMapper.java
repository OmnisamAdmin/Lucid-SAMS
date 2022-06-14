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
        staffCalendarTerms.setCurrentYear(staffCalendarTermsRequest.getCurrentYear());
        staffCalendarTerms.setEndDate(sharedMapper.dateToXMLGregorianCalendar(staffCalendarTermsRequest.getEndDate()));
        staffCalendarTerms.setId(staffCalendarTermsRequest.getId());
        staffCalendarTerms.setQuater(staffCalendarTermsRequest.getQuater());
        staffCalendarTerms.setStartDate(sharedMapper.dateToXMLGregorianCalendar(staffCalendarTermsRequest.getStartDate()));
        staffCalendarTerms.setTerm(staffCalendarTermsRequest.getTerm());

        return staffCalendarTerms;
    }
}
