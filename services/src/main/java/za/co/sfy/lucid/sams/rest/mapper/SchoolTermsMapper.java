package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SchoolTermsRequest;
import za.co.sfy.sams.lucid.schema.SchoolTerms;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author muzim
 */
@Component
public class SchoolTermsMapper {

    private final SharedMapper sharedMapper;

    public SchoolTermsMapper(final SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public SchoolTerms schoolTermsRequestToSchoolTerms(SchoolTermsRequest schoolTermsRequest) throws LucidSamsExecutionException {

        SchoolTerms schoolTerms = new SchoolTerms();

        schoolTerms.setId(schoolTermsRequest.getId());
        schoolTerms.setCurrentYear(schoolTermsRequest.getCurrentYear());
        XMLGregorianCalendar endDate = sharedMapper.dateToXMLGregorianCalendar(schoolTermsRequest.getEndDate());
        schoolTerms.setEndDate(endDate);
        schoolTerms.setQuater(schoolTermsRequest.getQuater());
        XMLGregorianCalendar startDate = sharedMapper.dateToXMLGregorianCalendar(schoolTermsRequest.getStartDate());
        schoolTerms.setStartDate(startDate);
        schoolTerms.setTerm(schoolTermsRequest.getTerm());

        return schoolTerms;
    }

}
