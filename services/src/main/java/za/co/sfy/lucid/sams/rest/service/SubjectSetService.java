package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.SubjectSetResource;
import za.co.sfy.lucid.sams.rest.mapper.SubjectSetMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.SubjectSetRequest;
import za.co.sfy.sams.vo.SubjectSetResponse;
import za.co.sfy.sams.lucid.schema.SubjectSets;


@Service
public class SubjectSetService {

    private final SubjectSetResource subjectSetResource;
    private final SubjectSetMapper subjectSetMapper;

    @Autowired
    public SubjectSetService(final SubjectSetResource subjectsetResource, final SubjectSetMapper subjectsetMapper) {
        this.subjectSetMapper = subjectsetMapper;
        this.subjectSetResource = subjectsetResource;
    }

    public SubjectSetResponse updateSubjectSet(SubjectSetRequest subjectsetRequest) throws LucidSamsExecutionException {


        SubjectSets Subjectsets = subjectSetMapper.subjectSetRequestToSubjectSets(subjectsetRequest);

        subjectSetResource.update(Subjectsets, subjectSetResource);

        SubjectSetResponse SubjectSetResponse;
        SubjectSetResponse = new SubjectSetResponse();
        SubjectSetResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        SubjectSetResponse.setResponseStatus("Successfully updated 'Subjects' table");
        SubjectSetResponse.setSubjectSets(Subjectsets);

        return SubjectSetResponse;
    }

    public SubjectSetResponse saveSubjectSets(SubjectSetRequest subjectsetRequest) throws LucidSamsExecutionException {

        SubjectSets subjectsets = subjectSetMapper.subjectSetRequestToSubjectSets(subjectsetRequest);

        Long id = subjectSetResource.save(subjectsets, subjectSetResource);

        subjectsets.setSubjectID(id.intValue());
        SubjectSetResponse SubjectSetResponse = new SubjectSetResponse();
        SubjectSetResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        SubjectSetResponse.setResponseStatus("Successfully saved 'SubjectsSets' table");
        SubjectSetResponse.setSubjectSets(subjectsets);

        return SubjectSetResponse;
    }

    private void update(SubjectSets subjectsets, SubjectSetService SubjectSetResource) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void save(SubjectSets subjectsets, SubjectSetService SubjectSetResource) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}