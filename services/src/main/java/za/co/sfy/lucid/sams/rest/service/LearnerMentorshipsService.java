package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.LearnerInfoResource;
import za.co.sfy.lucid.sams.resource.LearnerMentorsResource;
import za.co.sfy.lucid.sams.resource.LearnerMentorshipCatsResource;
import za.co.sfy.lucid.sams.resource.LearnerMentorshipResource;
import za.co.sfy.lucid.sams.rest.mapper.LearnerMentorshipsMapper;
import za.co.sfy.sams.vo.LearnerMentorshipsRequest;
import za.co.sfy.sams.vo.LearnerMentorshipsResponse;
import za.co.sfy.sams.lucid.schema.LearnerMentorships;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class LearnerMentorshipsService {

    private final LearnerMentorshipsMapper learnerMentorshipsMapper;
    private final LearnerMentorshipResource learnerMentorshipResource;
    private final LearnerInfoResource learnerInfoResource;
    private final LearnerMentorshipCatsResource learnerMentorshipCatsResource;
    private final LearnerMentorsResource learnerMentorsResource;

    @Autowired
    public LearnerMentorshipsService(final LearnerMentorshipsMapper learnerMentorshipsMapper, final LearnerMentorshipResource learnerMentorshipResource
            , final LearnerInfoResource learnerInfoResource, final LearnerMentorshipCatsResource learnerMentorshipCatsResource
            , final LearnerMentorsResource learnerMentorsResource) {
        this.learnerMentorshipResource = learnerMentorshipResource;
        this.learnerMentorshipsMapper = learnerMentorshipsMapper;
        this.learnerInfoResource = learnerInfoResource;
        this.learnerMentorshipCatsResource = learnerMentorshipCatsResource;
        this.learnerMentorsResource = learnerMentorsResource;
    }

    public LearnerMentorshipsResponse saveLearnerMentorships(LearnerMentorshipsRequest learnerMentorshipsRequest) throws LucidSamsExecutionException {
        LearnerMentorships learnerMentorships = learnerMentorshipsMapper.learnerMentorshipsRequestToLearnerMentorships(learnerMentorshipsRequest);

        Integer catID = learnerMentorships.getCatID();
        ResultSet retrievedLearnerMentorshipsCat = learnerMentorshipCatsResource.retrieveLearnerMentorshipCatsByID(Long.valueOf(catID));
        try {
            if (!retrievedLearnerMentorshipsCat.next()) {
                throw new LucidSamsExecutionException("Could not find LearnerMentorshipsCat with catID '" + catID + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Integer mentorID = learnerMentorships.getMentorID();
        ResultSet retrievedLearnerMentors = learnerMentorsResource.retrieveLearnerMentorsByMentorID(Long.valueOf(mentorID));
        try {
            if (!retrievedLearnerMentors.next()) {
                throw new LucidSamsExecutionException("Could not find LearnerMentors with MentorID '" + mentorID + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Integer learnerID = learnerMentorships.getLearnerID();
        ResultSet retrievedLearnerInfo = learnerInfoResource.retrieveLearnerInfoByID(Long.valueOf(learnerID));
        try {
            if (!retrievedLearnerInfo.next()) {
                throw new LucidSamsExecutionException("Could not find LearnerInfo with LearnerID '" + learnerID + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Long generatedKey = learnerMentorshipResource.save(learnerMentorships, learnerMentorshipResource);
        learnerMentorships.setID(Math.toIntExact(generatedKey));

        LearnerMentorshipsResponse learnerMentorshipsResponse = new LearnerMentorshipsResponse();
        learnerMentorshipsResponse.setLearnerMentorships(learnerMentorships);
        learnerMentorshipsResponse.setResponseMessage("Successfully saved 'LearnerMentorships' data");
        learnerMentorshipsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return learnerMentorshipsResponse;
    }
}