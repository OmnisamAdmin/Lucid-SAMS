
package za.co.sfy.lucid.sams.rest.vo.data.writer;

import java.io.Serializable;



public class EducatorsGroupRequest implements Serializable {

    private static final long serialVersionUID = 6627252016141632712L;
    
    private Integer educatorgroupID;
    private Integer grade;
    private Integer educatorID;
    private Short groupname;
    private Integer subjectID;

    
 public Integer getEducatorGroupID() {
        return this.educatorgroupID;
    }

    public void setEducatorGroupID(Integer value) {
        this.educatorgroupID = value;
    }  

    public Integer getGrade() {
        return this.grade;
    }

    public void setGrade(Integer value) {
        this.grade = value;
    }
    public Integer getEducatorID() {
        return this.educatorID;
    }

    public void setEducatorID(Integer value) {
        this.educatorID = value;
    }

    public Short getGroupName() {
        return this.groupname;
    }

    public void setGroupName(Short value ) {
        this.groupname = value;
    }

    public Integer getSubjectID() {
        return this.subjectID;
    }

    public void setSubjectID(Integer value) {
        this.subjectID = value;
    }
   
}

