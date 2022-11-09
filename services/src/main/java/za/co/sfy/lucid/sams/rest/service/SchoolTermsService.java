package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.SchoolTermsResource;
import za.co.sfy.lucid.sams.rest.mapper.SchoolTermsMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.SchoolTermsRequest;
import za.co.sfy.sams.vo.SchoolTermsResponse;
import za.co.sfy.sams.lucid.schema.SchoolTerms;

/**
 * @author muzim
 */
@Service
public class SchoolTermsService {

    private final SchoolTermsResource schoolTermsResource;
    private final SchoolTermsMapper schoolTermsMapper;

    @Autowired
    public SchoolTermsService(final SchoolTermsResource schoolTermsResource, final SchoolTermsMapper schoolTermsMapper) {
        this.schoolTermsResource = schoolTermsResource;
        this.schoolTermsMapper = schoolTermsMapper;
    }

    public SchoolTermsResponse saveSchoolTerms(SchoolTermsRequest schoolTermsRequest) throws LucidSamsExecutionException {

        SchoolTerms schoolTerms = schoolTermsMapper.schoolTermsRequestToSchoolTerms(schoolTermsRequest);

        Integer term = schoolTerms.getTerm();
        if (term > 4 || term < 1) {
            throw new LucidSamsExecutionException("The given term is not valid, the range is 1-4");
        }

        Long generatedKey = schoolTermsResource.save(schoolTerms, schoolTermsResource);
        schoolTerms.setId(Math.toIntExact(generatedKey));

        SchoolTermsResponse schoolTermsResponse = new SchoolTermsResponse();
        schoolTermsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());
        schoolTermsResponse.setResponseMessage("Successfully saved 'SchoolTerms' data");
        schoolTermsResponse.setSchoolTerms(schoolTerms);

        return schoolTermsResponse;
    }

}