package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.EducatorsResource;
import za.co.sfy.lucid.sams.rest.mapper.EducatorsMapper;
import za.co.sfy.sams.vo.EducatorsRequest;
import za.co.sfy.sams.vo.EducatorsResponse;
import za.co.sfy.sams.lucid.schema.Educators;

@Service
public class EducatorsService {

    private final EducatorsMapper educatorsMapper;
    private final EducatorsResource educatorsResource;

    @Autowired
    public EducatorsService(final EducatorsMapper educatorsMapper, final EducatorsResource educatorsResource) {
        this.educatorsMapper = educatorsMapper;
        this.educatorsResource = educatorsResource;
    }

    public EducatorsResponse saveEducators(EducatorsRequest educatorsRequest) throws LucidSamsExecutionException {

        Educators educators = educatorsMapper.educatorsRequestToEducators(educatorsRequest);

        Long generatedKey = educatorsResource.save(educators, educatorsResource);
        educators.setEdID(Math.toIntExact(generatedKey));

        EducatorsResponse educatorsResponse = new EducatorsResponse();
        educatorsResponse.setEducators(educators);
        educatorsResponse.setResponseMessage("Successfully saved 'Educators' data");
        educatorsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return educatorsResponse;
    }
}