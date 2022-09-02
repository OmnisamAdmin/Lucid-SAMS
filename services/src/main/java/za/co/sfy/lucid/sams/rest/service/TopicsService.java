package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.TopicsResource;
import za.co.sfy.lucid.sams.rest.mapper.TopicsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.TopicsRequests;
import za.co.sfy.lucid.sams.rest.vo.data.writer.TopicsResponse;
import za.co.sfy.sams.lucid.schema.Topics;

@Service
public class TopicsService {

    private final TopicsResource TopicsResource;
    private final TopicsMapper TopicsMapper;

    @Autowired
    public TopicsService(final TopicsResource TopicsResource, final TopicsMapper TopicsMapper) {
        this.TopicsMapper = TopicsMapper;
        this.TopicsResource = TopicsResource;
    }

    public TopicsResponse updateTopics(TopicsRequests topicsRequests) throws LucidSamsExecutionException {

        Topics topics = TopicsMapper.topicsRequestsToTopics(topicsRequests);

        TopicsResource.update(topics, TopicsResource);

        TopicsResponse TopicsResponse = new TopicsResponse();
        TopicsResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        TopicsResponse.setResponseStatus("Successfully updated 'Subjects' table");
        TopicsResponse.setTopics(topics);

        return TopicsResponse;
    }

    public TopicsResponse saveTopics(TopicsRequests TopicsRequests) throws LucidSamsExecutionException {

        Topics Topics = TopicsMapper.topicsRequestsToTopics(TopicsRequests);

        TopicsResource.save(Topics, TopicsResource);

        TopicsResponse TopicsResponse = new TopicsResponse();
        TopicsResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        TopicsResponse.setResponseStatus("Successfully saved 'Subjects' table");
        TopicsResponse.setTopics(Topics);

        return TopicsResponse;
    }

}
