package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.LearnerInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.LearnerInfoMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearnerInfoRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearnerInfoResponse;
import za.co.sfy.sams.lucid.schema.LearnerInfo;

/**
 * @author muzim
 */
@Service
public class LearnerInfoService {

    private final LearnerInfoResource learnerInfoResource;
    private final LearnerInfoMapper learnerInfoMapper;

    @Autowired
    public LearnerInfoService(final LearnerInfoResource learnerInfoResource, final LearnerInfoMapper learnerInfoMapper) {
        this.learnerInfoResource = learnerInfoResource;
        this.learnerInfoMapper = learnerInfoMapper;
    }

    public LearnerInfoResponse saveLearnerInfo(LearnerInfoRequest learnerInfoRequest) throws LucidSamsExecutionException {

        LearnerInfo learnerInfo = learnerInfoMapper.learnerInfoRequestToLearnerInfo(learnerInfoRequest);

        Long generatedKey = learnerInfoResource.save(learnerInfo, learnerInfoResource);
        learnerInfo.setID(Math.toIntExact(generatedKey));

        LearnerInfoResponse learnerInfoResponse = new LearnerInfoResponse();
        learnerInfoResponse.setLearnerInfo(learnerInfo);
        learnerInfoResponse.setResponseMessage("Successfully saved 'LearnerInfo' data.");
        learnerInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return learnerInfoResponse;
    }
}
