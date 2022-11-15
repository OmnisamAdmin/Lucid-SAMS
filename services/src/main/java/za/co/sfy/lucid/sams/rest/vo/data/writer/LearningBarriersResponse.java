package za.co.sfy.lucid.sams.rest.vo.data.writer;


import za.co.sfy.sams.lucid.schema.LearningBarriers;
import za.co.sfy.sams.response.ApiResponse;

public class LearningBarriersResponse extends ApiResponse {
    private static final long serialVersionUID = 5619901686093495790L;
    private LearningBarriers learningBarriers;

    public LearningBarriers getLearningBarriers() {
        return learningBarriers;
    }

    public void setLearningBarriers(LearningBarriers learningBarriers) {
        this.learningBarriers = learningBarriers;
    }
}
