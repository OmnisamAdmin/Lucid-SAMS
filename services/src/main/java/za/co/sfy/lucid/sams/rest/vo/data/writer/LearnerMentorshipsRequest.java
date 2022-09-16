package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class LearnerMentorshipsRequest implements Serializable {

    private static final long serialVersionUID = -294896491543941768L;

    private Integer id;
    @NotNull
    private Integer catID;
    @NotNull
    private Integer mentorID;
    @NotNull
    private Integer learnerID;
    @NotBlank
    private String dateStart;
    private String dateEnd;
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatID() {
        return catID;
    }

    public void setCatID(Integer catID) {
        this.catID = catID;
    }

    public Integer getMentorID() {
        return mentorID;
    }

    public void setMentorID(Integer mentorID) {
        this.mentorID = mentorID;
    }

    public Integer getLearnerID() {
        return learnerID;
    }

    public void setLearnerID(Integer learnerID) {
        this.learnerID = learnerID;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
