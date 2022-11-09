package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.LearnerInfoResource;
import za.co.sfy.lucid.sams.resource.ParentChildResource;
import za.co.sfy.lucid.sams.resource.ParentInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.ParentChildMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.ParentChildRequest;
import za.co.sfy.sams.vo.ParentChildResponse;
import za.co.sfy.sams.lucid.schema.ParentChild;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Service
public class ParentChildService {

    private final ParentChildResource parentChildRepository;
    private final LearnerInfoResource learnerInfoResource;
    private final ParentInfoResource parentInfoResource;
    private final ParentChildMapper parentChildMapper;

    @Autowired
    public ParentChildService(final ParentChildResource parentChildRepository, final ParentChildMapper parentChildMapper,
                              final LearnerInfoResource learnerInfoResource, final ParentInfoResource parentInfoResource) {
        this.parentChildRepository = parentChildRepository;
        this.parentChildMapper = parentChildMapper;
        this.learnerInfoResource = learnerInfoResource;
        this.parentInfoResource = parentInfoResource;
    }

    public ParentChildResponse saveParentChild(ParentChildRequest parentChildRequest) throws LucidSamsExecutionException {

        ParentChild parentChild = parentChildMapper.ParentChildRequestToParentChild(parentChildRequest);

        Integer parentID = parentChild.getParentId();
        ResultSet retrievedParentInfo = parentInfoResource.retrieveParentInfoByID(Long.valueOf(parentID));
        try {
            if (!retrievedParentInfo.next()) {
                throw new LucidSamsExecutionException("Could not find parentInfo with id '" + parentID + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failure in the retrieved Parent Info ", exception);
        }

        Integer childID = parentChild.getChildId();
        ResultSet retrievedLearnerInfo = learnerInfoResource.retrieveLearnerInfoByID(Long.valueOf(childID));
        try {
            if (!retrievedLearnerInfo.next()) {
                throw new LucidSamsExecutionException("Could not find learnerInfo with id '" + childID + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failure in the retrieved Learner Info ", exception);
        }

        while (true) {
            try {
                if (!retrievedLearnerInfo.next()) break;
                String learnerID = parentChild.getLearnerid();
                String retrievedLearnerID = retrievedLearnerInfo.getString("Learnerid");
                if (!retrievedLearnerID.equals(learnerID)) {
                    throw new LucidSamsExecutionException("There's no Learnerid '" + learnerID + "' for the given " +
                            "ChildId '" + childID + "'");
                }
            } catch (SQLException exception) {
                throw new LucidSamsExecutionException("Failure in the retrieved Learner Info ", exception);
            }
        }

        parentChildRepository.saveObjectWithoutGeneratedKey(parentChild, parentChildRepository);

        ParentChildResponse parentInfoResponse = new ParentChildResponse();
        parentInfoResponse.setParentChild(parentChild);
        parentInfoResponse.setResponseMessage("Successfully saved 'Parent_Child' data.");
        parentInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return parentInfoResponse;

    }
}