package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.EducatorsGroupResource;
import za.co.sfy.lucid.sams.rest.mapper.EducatorsGroupMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorsGroupRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorsGroupResponse;
import za.co.sfy.sams.lucid.schema.Educatorgroups;


@Service
public class EducatorsGroupService {

    private final EducatorsGroupResource EducatorsGroupResource;
    private final EducatorsGroupMapper EducatorsGroupMapper;

    @Autowired
    public EducatorsGroupService(final EducatorsGroupResource educatorsGroupResource, final EducatorsGroupMapper educatorsGroupMapper) {
        this.EducatorsGroupMapper = educatorsGroupMapper;
        this.EducatorsGroupResource = educatorsGroupResource;
    }

    public EducatorsGroupResponse updateEducatorGroups(EducatorsGroupRequest educatorsgroupRequest) throws LucidSamsExecutionException {

        Educatorgroups educatorgroups = EducatorsGroupMapper.EducatorsGroupRequestToEducatorGroups(educatorsgroupRequest);

        EducatorsGroupResource.update(educatorgroups, EducatorsGroupResource);

        EducatorsGroupResponse EducatorsGroupResponse = new EducatorsGroupResponse();
        EducatorsGroupResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        EducatorsGroupResponse.setResponseStatus("Successfully updated 'Educatorgroups' table");
        EducatorsGroupResponse.setEducatorgroups(educatorgroups);

        return EducatorsGroupResponse;
    }

    public EducatorsGroupResponse saveEducatorGroups(EducatorsGroupRequest educatorsgroupRequest) throws LucidSamsExecutionException {

        Educatorgroups educatorgroups = EducatorsGroupMapper.EducatorsGroupRequestToEducatorGroups(educatorsgroupRequest);

        Long id = EducatorsGroupResource.save(educatorgroups, EducatorsGroupResource);

        educatorgroups.setEducatorGroupID(Math.toIntExact(id));
        EducatorsGroupResponse educatorsgroupResponse = new EducatorsGroupResponse();
        educatorsgroupResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        educatorsgroupResponse.setResponseStatus("Successfully saved 'Educatorgroups' table");
        educatorsgroupResponse.setEducatorgroups(educatorgroups);

        return educatorsgroupResponse;
    }

}