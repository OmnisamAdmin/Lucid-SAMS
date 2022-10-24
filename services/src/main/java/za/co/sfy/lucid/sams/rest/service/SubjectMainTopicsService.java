package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.SubjectMainTopicsResource;
import za.co.sfy.lucid.sams.rest.mapper.SubjectMainTopicsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectMainTopicsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectMainTopicsResponse;
import za.co.sfy.sams.lucid.schema.SubjectMainTopics;

@Service
public class SubjectMainTopicsService {

    private final SubjectMainTopicsResource subjectMainTopicsResource;
    private final SubjectMainTopicsMapper subjectMainTopicsMapper;

    @Autowired
    public SubjectMainTopicsService(final SubjectMainTopicsResource SubjectMainTopicsResource, final SubjectMainTopicsMapper SubjectMainTopicsMapper) {
        this.subjectMainTopicsMapper = SubjectMainTopicsMapper;
        this.subjectMainTopicsResource = SubjectMainTopicsResource;
    }

    public SubjectMainTopicsResponse updateTopics(SubjectMainTopicsRequest subjectMainTopicsRequest) throws LucidSamsExecutionException {

        SubjectMainTopics topics = subjectMainTopicsMapper.topicsRequestsToTopics(subjectMainTopicsRequest);

        subjectMainTopicsResource.update(topics, subjectMainTopicsResource);

        SubjectMainTopicsResponse SubjectMainTopicsResponse = new SubjectMainTopicsResponse();
        SubjectMainTopicsResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        SubjectMainTopicsResponse.setResponseStatus("Successfully updated 'Subjects' table");
        SubjectMainTopicsResponse.setTopics(topics);

        return SubjectMainTopicsResponse;
    }

    public SubjectMainTopicsResponse saveTopics(SubjectMainTopicsRequest SubjectMainTopicsRequest) throws LucidSamsExecutionException {

        SubjectMainTopics topics = subjectMainTopicsMapper.topicsRequestsToTopics(SubjectMainTopicsRequest);

        Long id = subjectMainTopicsResource.save(topics, subjectMainTopicsResource);
        topics.setMainTopicID(Math.toIntExact(id));

        SubjectMainTopicsResponse SubjectMainTopicsResponse = new SubjectMainTopicsResponse();
        SubjectMainTopicsResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        SubjectMainTopicsResponse.setResponseStatus("Successfully saved 'Subjects' table");
        SubjectMainTopicsResponse.setTopics(topics);

        return SubjectMainTopicsResponse;
    }

}