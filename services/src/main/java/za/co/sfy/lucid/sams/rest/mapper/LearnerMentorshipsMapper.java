package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearnerMentorshipsRequest;
import za.co.sfy.sams.lucid.schema.LearnerMentorships;

@Component
public class LearnerMentorshipsMapper {

    private final SharedMapper sharedMapper;

    public LearnerMentorshipsMapper(final SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public LearnerMentorships learnerMentorshipsRequestToLearnerMentorships(LearnerMentorshipsRequest learnerMentorshipsRequest) throws LucidSamsExecutionException {
        LearnerMentorships learnerMentorships = new LearnerMentorships();

        Integer id = learnerMentorshipsRequest.getId();
        if (id != null) {
            learnerMentorships.setID(id);
        }

        learnerMentorships.setCatID(learnerMentorshipsRequest.getCatID());
        learnerMentorships.setMentorID(learnerMentorshipsRequest.getMentorID());
        learnerMentorships.setLearnerID(learnerMentorshipsRequest.getLearnerID());
        learnerMentorships.setDateStart(sharedMapper.dateToXMLGregorianCalendar(learnerMentorshipsRequest.getDateStart()));

        String dateEnd = learnerMentorshipsRequest.getDateEnd();
        if (dateEnd != null) {
            learnerMentorships.setDateEnd(sharedMapper.dateToXMLGregorianCalendar(dateEnd));
        }

        String comment = learnerMentorshipsRequest.getComment();
        if (comment != null) {
            learnerMentorships.setComment(comment);
        }

        return learnerMentorships;

    }

}
