package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.LearnerInfo;

import java.io.Serializable;

/**
 * @author muzim
 */
public class LearnerInfoResponse extends ApiResponse implements Serializable {

    private static final long serialVersionUID = 232515403339057426L;

    private LearnerInfo learnerInfo;

    public LearnerInfo getLearnerInfo() {
        return learnerInfo;
    }

    public void setLearnerInfo(LearnerInfo learnerInfo) {
        this.learnerInfo = learnerInfo;
    }
}
