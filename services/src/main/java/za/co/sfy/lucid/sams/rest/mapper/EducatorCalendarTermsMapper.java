package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorCalendarTermsRequest;
import za.co.sfy.sams.lucid.schema.EducatorCalendarTerms;

@Component
public class EducatorCalendarTermsMapper {

    private final SharedMapper sharedMapper;

    public EducatorCalendarTermsMapper(final SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public EducatorCalendarTerms educatorCalendarTermsRequestToEducatorCalendarTerms(EducatorCalendarTermsRequest educatorCalendarTermsRequest) throws LucidSamsExecutionException {

        EducatorCalendarTerms educatorCalendarTerms = new EducatorCalendarTerms();
        educatorCalendarTerms.setCurrentYear(educatorCalendarTermsRequest.getCurrentYear());
        educatorCalendarTerms.setEndDate(sharedMapper.dateToXMLGregorianCalendar(educatorCalendarTermsRequest.getEndDate()));
        educatorCalendarTerms.setId(educatorCalendarTermsRequest.getId());
        educatorCalendarTerms.setQuater(educatorCalendarTermsRequest.getQuater());
        educatorCalendarTerms.setStartDate(sharedMapper.dateToXMLGregorianCalendar(educatorCalendarTermsRequest.getStartDate()));
        educatorCalendarTerms.setTerm(educatorCalendarTermsRequest.getTerm());

        return educatorCalendarTerms;
    }
}
