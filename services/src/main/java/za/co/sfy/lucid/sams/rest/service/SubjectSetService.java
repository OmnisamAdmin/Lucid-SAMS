package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.SubjectSetResource;
import za.co.sfy.lucid.sams.rest.mapper.SubjectSetMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectSetRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectSetResponse;
import za.co.sfy.sams.lucid.schema.SubjectSets;


@Service
public class SubjectSetService {

    private final SubjectSetResource SubjectSetResource;
    private final SubjectSetMapper SubjectSetMapper;

    @Autowired
    public SubjectSetService(final SubjectSetResource subjectsetResource, final SubjectSetMapper subjectsetMapper) {
        this.SubjectSetMapper = subjectsetMapper;
        this.SubjectSetResource = subjectsetResource;
    }

    public SubjectSetResponse updateSubjectSet(SubjectSetRequest subjectsetRequest) throws LucidSamsExecutionException {


        SubjectSets Subjectsets = SubjectSetMapper.SubjectSetRequestToSubjectSets(subjectsetRequest);

        SubjectSetResource.update(Subjectsets, SubjectSetResource);

        SubjectSetResponse SubjectSetResponse = new SubjectSetResponse();
        SubjectSetResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        SubjectSetResponse.setResponseStatus("Successfully updated 'Subjects' table");
        SubjectSetResponse.setSubjectSets(Subjectsets);

        return SubjectSetResponse;
    }

    public SubjectSetResponse saveSubjectSets(SubjectSetRequest subjectsetRequest) throws LucidSamsExecutionException {

        SubjectSets subjectsets = SubjectSetMapper.subjectsetRequestTosubjectsets(subjectsetRequest);

        SubjectSetResource.save(subjectsets, SubjectSetResource);

        SubjectSetResponse SubjectSetResponse = new SubjectSetResponse();
        SubjectSetResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        SubjectSetResponse.setResponseStatus("Successfully saved 'SubjectsSets' table");
        SubjectSetResponse.setSubjectSets(subjectsets);

        return SubjectSetResponse;
    }

    private void update(SubjectSets subjectsets, SubjectSetService SubjectSetResource) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void save(SubjectSets subjectsets, SubjectSetService SubjectSetResource) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
