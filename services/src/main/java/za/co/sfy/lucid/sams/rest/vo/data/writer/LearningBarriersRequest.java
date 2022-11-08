package za.co.sfy.lucid.sams.rest.vo.data.writer;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;

public class LearningBarriersRequest implements Serializable {
    private static final long serialVersionUID = 5158847541100342936L;
    private Integer id;
    @NotNull
    private String date;
    @NotNull
    private Integer learnerId;
    @NotBlank
    private String comment;
    @NotNull
    private Integer barrierCode;
    @NotNull
    private Integer actionCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(Integer learnerId) {
        this.learnerId = learnerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getBarrierCode() {
        return barrierCode;
    }

    public void setBarrierCode(Integer barrierCode) {
        this.barrierCode = barrierCode;
    }

    public Integer getActionCode() {
        return actionCode;
    }

    public void setActionCode(Integer actionCode) {
        this.actionCode = actionCode;
    }
}
