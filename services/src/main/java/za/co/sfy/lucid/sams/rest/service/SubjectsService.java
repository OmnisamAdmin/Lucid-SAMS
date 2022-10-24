package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.SubjectsResource;
import za.co.sfy.lucid.sams.rest.mapper.SubjectsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectsResponse;
import za.co.sfy.sams.lucid.schema.Subjects;

@Service
public class SubjectsService {

    private final SubjectsResource subjectsResource;
    private final SubjectsMapper subjectsMapper;

    @Autowired
    public SubjectsService(final SubjectsResource subjectsResource, final SubjectsMapper subjectsMapper) {
        this.subjectsMapper = subjectsMapper;
        this.subjectsResource = subjectsResource;
    }

    public SubjectsResponse updateSubjects(SubjectsRequest subjectsRequest) throws LucidSamsExecutionException {

        Subjects subjects = subjectsMapper.subjectsRequestToSubjects(subjectsRequest);

        subjectsResource.update(subjects, subjectsResource);

        SubjectsResponse subjectsResponse = new SubjectsResponse();
        subjectsResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        subjectsResponse.setResponseStatus("Successfully updated 'Subjects' table");
        subjectsResponse.setSubject(subjects);

        return subjectsResponse;
    }

    public SubjectsResponse saveSubjects(SubjectsRequest subjectsRequest) throws LucidSamsExecutionException {

        Subjects subjects = subjectsMapper.subjectsRequestToSubjects(subjectsRequest);

        subjectsResource.save(subjects, subjectsResource);

        SubjectsResponse subjectsResponse = new SubjectsResponse();
        subjectsResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        subjectsResponse.setResponseStatus("Successfully saved 'Subjects' table");
        subjectsResponse.setSubject(subjects);

        return subjectsResponse;
    }


}
