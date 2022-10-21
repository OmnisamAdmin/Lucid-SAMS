package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.LearnerMentorships;

public class LearnerMentorshipsResponse extends ApiResponse {

    private static final long serialVersionUID = -3924530171548114866L;

    private LearnerMentorships learnerMentorships;

    public LearnerMentorships getLearnerMentorships() {
        return learnerMentorships;
    }

    public void setLearnerMentorships(LearnerMentorships learnerMentorships) {
        this.learnerMentorships = learnerMentorships;
    }
}
