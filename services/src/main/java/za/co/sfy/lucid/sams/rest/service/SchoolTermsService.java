package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.SchoolTermsResource;
import za.co.sfy.lucid.sams.rest.mapper.SchoolTermsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SchoolTermsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SchoolTermsResponse;
import za.co.sfy.sams.lucid.schema.SchoolTerms;

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

        Long generatedKey = schoolTermsResource.save(schoolTerms, schoolTermsResource);
        schoolTerms.setId(Math.toIntExact(generatedKey));

        SchoolTermsResponse schoolTermsResponse = new SchoolTermsResponse();
        schoolTermsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());
        schoolTermsResponse.setResponseMessage("Successfully saved 'SchoolTerms' data");
        schoolTermsResponse.setSchoolTerms(schoolTerms);

        return schoolTermsResponse;
    }

}
