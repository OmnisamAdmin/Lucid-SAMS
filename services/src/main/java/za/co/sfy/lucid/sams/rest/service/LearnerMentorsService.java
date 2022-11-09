package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.EducatorsResource;
import za.co.sfy.lucid.sams.resource.LearnerInfoResource;
import za.co.sfy.lucid.sams.resource.LearnerMentorTypesResource;
import za.co.sfy.lucid.sams.resource.LearnerMentorsResource;
import za.co.sfy.lucid.sams.rest.mapper.LearnerMentorsMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.LearnerMentorsRequest;
import za.co.sfy.sams.vo.LearnerMentorsResponse;
import za.co.sfy.sams.lucid.schema.LearnerMentors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LearnerMentorsService {

    private final LearnerMentorsResource learnerMentorsResource;
    private final LearnerMentorsMapper learnerMentorsMapper;
    private final LearnerMentorTypesResource learnerMentorTypesResource;
    private final LearnerInfoResource learnerInfoResource;
    private final EducatorsResource educatorsResource;
    private static Map<Integer, String> learnerMentorTypesMap = new HashMap<>();
    private static final String EDUCATORS = "Educators";
    private static final String LEARNERS = "Learners";
    private static final String STAFF = "School Based Staff";
    private static final String CURRENT = "C";
    private static final String Archived = "A";
    private static final List<String> entitiesWithResource = Arrays.asList(EDUCATORS, LEARNERS, STAFF);
    private static final List<String> statuses = Arrays.asList(CURRENT, Archived);

    @Autowired
    public LearnerMentorsService(final LearnerMentorsResource learnerMentorsResource, final LearnerMentorsMapper learnerMentorsMapper
            , final LearnerMentorTypesResource learnerMentorTypesResource, final LearnerInfoResource learnerInfoResource
            , final EducatorsResource educatorsResource) {
        this.learnerMentorsMapper = learnerMentorsMapper;
        this.learnerMentorsResource = learnerMentorsResource;
        this.learnerMentorTypesResource = learnerMentorTypesResource;
        this.learnerInfoResource = learnerInfoResource;
        this.educatorsResource = educatorsResource;
    }

    public LearnerMentorsResponse saveLearnerMentors(String identifier, LearnerMentorsRequest learnerMentorsRequest) throws LucidSamsExecutionException {
        LearnerMentors learnerMentors = learnerMentorsMapper.learnerMentorsRequestToLearnerMentors(learnerMentorsRequest);

        Boolean retrieveTargetEntityByIdentifier = Boolean.FALSE;
        if (null != identifier) {
            retrieveTargetEntityByIdentifier = Boolean.TRUE;
        }

        Integer linkID = learnerMentors.getLinkID();
        if (null == linkID && Boolean.FALSE.equals(retrieveTargetEntityByIdentifier)) {
            throw new LucidSamsExecutionException("The LinkID is null & there's no identifier value to reference");
        }

        populateLearnerMentorTypes();
        if (null == learnerMentorTypesMap || learnerMentorTypesMap.isEmpty()) {
            throw new LucidSamsExecutionException("The LearnerMentorTypes map is null");
        }

        Integer typeID = learnerMentors.getTypeID();
        if (!learnerMentorTypesMap.containsKey(typeID)) {
            throw new LucidSamsExecutionException("The submitted typeID '" + typeID + "' does not match an existing type");
        }

        String typeDesc = learnerMentorTypesMap.get(typeID);
        ResultSet retrievedLearnerMentor = null;
        if (EDUCATORS.equalsIgnoreCase(typeDesc)) {
            if (Boolean.TRUE.equals(retrieveTargetEntityByIdentifier)) {
                retrievedLearnerMentor = educatorsResource.retrieveEducatorsByPersalNumber(identifier);
            } else {
                retrievedLearnerMentor = educatorsResource.retrieveEducatorsByID(Long.valueOf(linkID));
            }
        } else if (LEARNERS.equalsIgnoreCase(typeDesc)) {
            if (Boolean.TRUE.equals(retrieveTargetEntityByIdentifier)) {
                retrievedLearnerMentor = learnerInfoResource.retrieveLearnerInfoByLearnerID(identifier);
            } else {
                retrievedLearnerMentor = learnerInfoResource.retrieveLearnerInfoByID(Long.valueOf(linkID));
            }
        } else if (STAFF.equalsIgnoreCase(typeDesc)) {
            //TODO: May need to be implemented in future
            throw new LucidSamsExecutionException("'StaffMembers' resource is unimplemented");
        } else {
            if (null == linkID || 0 != linkID) {
                throw new LucidSamsExecutionException("linkID has to be be 0 for entities without a resource '" + typeDesc + "'");
            }
        }

        if (entitiesWithResource.contains(typeDesc)) {
            try {
                if (null == retrievedLearnerMentor || !retrievedLearnerMentor.next()) {
                    if (Boolean.TRUE.equals(retrieveTargetEntityByIdentifier)) {
                        throw new LucidSamsExecutionException("The given identifier '" + identifier + " for typeID " + typeID
                                + " does not exist in the system.");
                    } else {
                        throw new LucidSamsExecutionException("The given linkID '" + linkID + " for typeID " + typeID
                                + " does not exist in the system.");
                    }
                }
            } catch (SQLException exception) {
                throw new LucidSamsExecutionException(exception.getMessage(), exception);
            }

            String fName = learnerMentors.getFName();
            String sName = learnerMentors.getSName();

            while (true) {
                try {
                    if (!retrievedLearnerMentor.next()) break;
                    linkID = retrievedLearnerMentor.getInt("LinkID");
                    if (retrieveTargetEntityByIdentifier) {
                        learnerMentors.setLinkID(linkID);
                    }
                    String retrievedFName = retrievedLearnerMentor.getString("FName");
                    String retrievedSName = retrievedLearnerMentor.getString("SName");
                    if (!fName.equals(retrievedFName) || !sName.equals(retrievedSName)) {
                        throw new LucidSamsExecutionException("The given FName and SName does not match the FName and SName " +
                                "retrieved from linkID '" + linkID + "' which is '" + retrievedFName + "' and '"
                                + retrievedSName + "' respectively");
                    }
                } catch (SQLException exception) {
                    throw new LucidSamsExecutionException(exception.getMessage(), exception);
                }
            }
        }

        String status = learnerMentors.getStatus().toUpperCase();
        if (!statuses.contains(status)) {
            throw new LucidSamsExecutionException("The given status '" + status + "' is invalid");
        }

        learnerMentors.setStatus(status);

        Long generatedKey = learnerMentorsResource.save(learnerMentors, learnerMentorsResource);
        learnerMentors.setMentorID(Math.toIntExact(generatedKey));

        LearnerMentorsResponse learnerMentorsResponse = new LearnerMentorsResponse();
        learnerMentorsResponse.setLearnerMentors(learnerMentors);
        learnerMentorsResponse.setResponseMessage("Successfully saved 'LearnerMentors' data");
        learnerMentorsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return learnerMentorsResponse;
    }

    private void populateLearnerMentorTypes() throws LucidSamsExecutionException {
        if (null == learnerMentorTypesMap || learnerMentorTypesMap.isEmpty()) {
            ResultSet retrievedLearnerMentorTypes = learnerMentorTypesResource.retrieve((Object) null, learnerMentorTypesResource);
            while (true) {
                try {
                    if (!retrievedLearnerMentorTypes.next()) break;
                    Integer typeID = retrievedLearnerMentorTypes.getInt("TypeID");
                    String typeDesc = retrievedLearnerMentorTypes.getString("TypeDesc");
                    learnerMentorTypesMap.put(typeID, typeDesc);
                } catch (SQLException exception) {
                    throw new LucidSamsExecutionException("Failed to populate LearnerMentorTypes", exception);
                }
            }
        }
    }
}