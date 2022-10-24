
package za.co.sfy.lucid.sams.rest.vo.data.writer;

import java.io.Serializable;


public class SubjectMainTopicsRequest implements Serializable {

    private static final long serialVersionUID = 6627252016141632712L;

    private Integer mainTopicId;
    private Integer mainPosition;
    private Short description;
    private Short afrDescription;
    private Short vernDescription;
    private Integer subjectId;
    private Integer officialSubjectId;
    private String recLocked;
    private Short patchVer;
    private Integer groupNo;


    public Integer getMainTopicID() {
        return this.mainTopicId;
    }

    public void setMainTopicID(Integer value) {
        this.mainTopicId = value;
    }

    public Integer getMainPosition() {
        return this.mainPosition;
    }

    public void setMainPosition(Integer value) {
        this.mainPosition = value;
    }

    public Short getDescription() {
        return this.description;
    }

    public void setDescription(Short value) {
        this.description = value;
    }

    public Short getAfrDescription() {
        return this.afrDescription;
    }

    public void setAfrDescription(Short value) {
        this.afrDescription = value;
    }

    public Short getVernDescription() {
        return this.vernDescription;
    }

    public void setVernDescription(Short value) {
        this.vernDescription = value;
    }

    public Integer getSubjectID() {
        return this.subjectId;
    }

    public void setSubjectID(Integer value) {
        this.subjectId = value;
    }

    public Integer getOfficialSubjectID() {
        return this.officialSubjectId;
    }

    public void setOfficialSubjectID(Integer value) {
        this.officialSubjectId = value;
    }

    public String getRecLocked() {
        return this.recLocked;
    }

    public void setRecLocked(String value) {
        this.recLocked = value;
    }

    public Short getPatchVer() {
        return this.patchVer;
    }

    public void setPatchVer(Short value) {
        this.patchVer = value;
    }

    public Integer getGroupNo() {
        return this.groupNo;
    }

    public void setGroupNo(Integer value) {
        this.groupNo = value;
    }


}