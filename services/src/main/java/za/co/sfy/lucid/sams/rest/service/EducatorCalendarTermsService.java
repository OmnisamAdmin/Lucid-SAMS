package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.EducatorCalendarTermsResource;
import za.co.sfy.lucid.sams.rest.mapper.EducatorCalendarTermsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorCalendarTermsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorCalendarTermsResponse;
import za.co.sfy.sams.lucid.schema.EducatorCalendarTerms;

@Service
public class EducatorCalendarTermsService {

    private final EducatorCalendarTermsResource educatorCalendarTermsResource;
    private final EducatorCalendarTermsMapper educatorCalendarTermsMapper;

    @Autowired
    public EducatorCalendarTermsService(final EducatorCalendarTermsResource educatorCalendarTermsResource,
                                        final EducatorCalendarTermsMapper educatorCalendarTermsMapper) {
        this.educatorCalendarTermsResource = educatorCalendarTermsResource;
        this.educatorCalendarTermsMapper = educatorCalendarTermsMapper;
    }

    public EducatorCalendarTermsResponse saveEducatorCalendarTerms(EducatorCalendarTermsRequest educatorCalendarTermsRequest) throws LucidSamsExecutionException {

        EducatorCalendarTerms educatorCalendarTerms = educatorCalendarTermsMapper.educatorCalendarTermsRequestToEducatorCalendarTerms(educatorCalendarTermsRequest);

        Long generatedKey = educatorCalendarTermsResource.save(educatorCalendarTerms, educatorCalendarTermsResource);
        educatorCalendarTerms.setId(Math.toIntExact(generatedKey));

        EducatorCalendarTermsResponse educatorCalendarTermsResponse = new EducatorCalendarTermsResponse();
        educatorCalendarTermsResponse.setEducatorCalendarTerms(educatorCalendarTerms);
        educatorCalendarTermsResponse.setResponseMessage("Successfully saved 'EducatorCalendarTerms' data");
        educatorCalendarTermsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return educatorCalendarTermsResponse;
    }
}
