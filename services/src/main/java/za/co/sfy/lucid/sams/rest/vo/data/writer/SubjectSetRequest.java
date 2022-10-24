
package za.co.sfy.lucid.sams.rest.vo.data.writer;

import java.io.Serializable;



public class SubjectSetRequest implements Serializable {

    private static final long serialVersionUID = 6627252016141632712L;

    private Short description;
    private Integer subjectID;
    private Integer subjectsetID;
    private Integer subjectsetgrade;

    

    public Short getDescription() {
        return this.description;
    }

    public void setDescription(Short value) {
        this.description = value;
    }
    public Integer getSubjectID() {
        return this.subjectID;
    }

    public void setSubjectID(Integer value) {
        this.subjectID = value;
    }

    public Integer getSubjectSetID() {
        return this.subjectsetID;
    }

    public void setSubjectSetID(Integer value) {
        this.subjectsetID = value;
    }

    public Integer getSubjectSetGrade() {
        return this.subjectsetgrade;
    }

    public void setSubjectSetGrade(Integer value) {
        this.subjectsetgrade = value;
    }
 

  
}

