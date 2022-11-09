package za.co.sfy.lucid.sams.rest.service;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.LearningBarriersResource;
import za.co.sfy.lucid.sams.rest.mapper.LearningBarriersMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearningBarriersRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearningBarriersResponse;
import za.co.sfy.sams.lucid.schema.LearningBarriers;

@Component
public class LearningBarriersService {
    private final LearningBarriersResource learningBarriersResource;
    private final LearningBarriersMapper learningBarriersMapper;

    public LearningBarriersService(LearningBarriersResource learningBarriersResource, LearningBarriersMapper learningBarriersMapper) {
        this.learningBarriersResource = learningBarriersResource;
        this.learningBarriersMapper = learningBarriersMapper;
    }

    public LearningBarriersResponse saveLearningBarriers(LearningBarriersRequest learningBarriersRequest) throws LucidSamsExecutionException {
        LearningBarriers learningBarriers = learningBarriersMapper.learningBarriersRequestToLearningBarriers(learningBarriersRequest);
        Long generatedKey = learningBarriersResource.save(learningBarriers, learningBarriersResource);
        learningBarriers.setId(Math.toIntExact(generatedKey));
        LearningBarriersResponse learningBarriersResponse = new LearningBarriersResponse();
        learningBarriersResponse.setLearningBarriers(learningBarriers);
        learningBarriersResponse.setResponseMessage("Successfully saved 'Learning Barriers' data");
        learningBarriersResponse.setResponseStatus(ServiceStatus.SUCCESS.value());
        return learningBarriersResponse;

    }
}
