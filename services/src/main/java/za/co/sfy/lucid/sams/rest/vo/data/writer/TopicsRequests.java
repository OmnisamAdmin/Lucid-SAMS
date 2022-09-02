
package za.co.sfy.lucid.sams.rest.vo.data.writer;

import java.io.Serializable;



public class TopicsRequests implements Serializable {

    private static final long serialVersionUID = 6627252016141632712L;

    private Integer maintopicid;
    private Integer mainposition;
    private Short description;
    private Short afrdescription;
    private Short verndescription;
    private Integer subjectid;
    private Integer officialsubjectid;
    private String reclocked;
    private Short patchver;
    private Integer groupno;
    

    public Integer getMainTopicID() {
        return this.maintopicid;
    }

    public void setMainTopicID(Integer value) {
        this.maintopicid = value;
    }
    public Integer getMainPosition() {
        return this.mainposition;
    }

    public void setMainPosition(Integer value) {
        this.mainposition = value;
    }

    public Short getDescription() {
        return this.description;
    }

    public void setDescription(Short value ) {
        this.description = value;
    }

    public Short getAfrDescription() {
        return this.afrdescription;
    }

    public void setAfrDescription(Short value) {
        this.afrdescription = value;
    }
    public Short getVernDescription() {
    return this.verndescription;
    }

    public void setVernDescription(Short value) {
        this.verndescription = value;
    }

    public Integer getSubjectID() {
        return this.subjectid;
    }

    public void setSubjectID(Integer value) {
        this.subjectid = value;
    }
    public Integer getOfficialSubjectID() {
        return this.officialsubjectid;
    }

    public void setOfficialSubjectID(Integer value) {
        this.officialsubjectid = value;
    }

    public String getRecLocked() {
        return this.reclocked;
    }

    public void setRecLocked(String value) {
        this.reclocked= value;
    }

    /**
     *
     * @return
     */
    public Short getPatchVer() {
        return this.patchver;
    }

    public void setPatchVer(Short value) {
        this.patchver = value;
    }

    public Integer getGroupNo() {
        return this.groupno;
    }

    public void setGroupNo(Integer value) {
        this.groupno = value;
    }

  
}

