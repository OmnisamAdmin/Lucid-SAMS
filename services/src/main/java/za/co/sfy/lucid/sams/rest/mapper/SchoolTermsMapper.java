package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SchoolTermsRequest;
import za.co.sfy.sams.lucid.schema.SchoolTerms;

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

        Integer id = schoolTermsRequest.getId();
        if (null != id) {
            schoolTerms.setId(id);
        } else {
            schoolTerms.setId(0);
        }

        String currentYear = schoolTermsRequest.getCurrentYear();
        if (null != currentYear) {
            schoolTerms.setCurrentYear(currentYear);
        }

        String endDate = schoolTermsRequest.getEndDate();
        if (null != endDate) {
            schoolTerms.setEndDate(sharedMapper.dateToXMLGregorianCalendar(endDate));
        } else {
            schoolTerms.setEndDate(sharedMapper.dateToXMLGregorianCalendar());
        }

        String quater = schoolTermsRequest.getQuater();
        if (null != quater) {
            schoolTerms.setQuater(quater);
        }

        String startDate = schoolTermsRequest.getStartDate();
        if (null != startDate) {
            schoolTerms.setStartDate(sharedMapper.dateToXMLGregorianCalendar(startDate));
        } else {
            schoolTerms.setStartDate(sharedMapper.dateToXMLGregorianCalendar());
        }

        Integer term = schoolTermsRequest.getTerm();
        if (null != term) {
            schoolTerms.setTerm(term);
        } else {
            schoolTerms.setTerm(0);
        }

        return schoolTerms;
    }
}