package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.sams.vo.LearnerMentorsRequest;
import za.co.sfy.sams.lucid.schema.LearnerMentors;

@Component
public class LearnerMentorsMapper {

    public LearnerMentors learnerMentorsRequestToLearnerMentors(LearnerMentorsRequest learnerMentorsRequest) {
        LearnerMentors learnerMentors = new LearnerMentors();

        Integer mentorID = learnerMentorsRequest.getMentorID();
        if (mentorID != null) {
            learnerMentors.setMentorID(mentorID);
        }
        learnerMentors.setTypeID(learnerMentorsRequest.getTypeID());
        Integer linkID = learnerMentorsRequest.getLinkID();
        if (linkID != null) {
            learnerMentors.setLinkID(linkID);
        }
        learnerMentors.setSName(learnerMentorsRequest.getfName());
        learnerMentors.setFName(learnerMentorsRequest.getfName());
        String comment = learnerMentorsRequest.getComment();
        if (comment != null) {
            learnerMentors.setComment(comment);
        }
        learnerMentors.setStatus(learnerMentorsRequest.getStatus());

        return learnerMentors;
    }
}