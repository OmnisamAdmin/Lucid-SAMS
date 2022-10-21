package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class LearnerMentorsRequest implements Serializable {

    private static final long serialVersionUID = 6868325992640252403L;

    private Integer mentorID;
    @NotNull
    private Integer typeID;
    private Integer linkID;
    @NotBlank
    private String sName;
    @NotBlank
    private String fName;
    private String comment;
    @NotBlank
    private String status;

    public Integer getMentorID() {
        return mentorID;
    }

    public void setMentorID(Integer mentorID) {
        this.mentorID = mentorID;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public Integer getLinkID() {
        return linkID;
    }

    public void setLinkID(Integer linkID) {
        this.linkID = linkID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
