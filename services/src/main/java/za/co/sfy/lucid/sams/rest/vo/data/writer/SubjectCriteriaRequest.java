
package za.co.sfy.lucid.sams.rest.vo.data.writer;

import java.io.Serializable;
import java.sql.Date;



public class SubjectCriteriaRequest implements Serializable {

    private static final long serialVersionUID = 6627252016141632712L;
    
    private Integer subjectID;
    private Integer criterionID;
    private Short description;
    private Integer grade;
    private Integer weighting;
    private Short subjectlevel;
    private Integer criterionscore;
    private Short datayear;
    private Short subheading;
    private Date dateadded;
    private Short type;
    private Long outcomes;
    private Long activities;
    private Long assessments;
    private Integer sectionID;
    private Boolean useactivities;
    private Boolean includeffl;
    private Boolean includeExam;
    private Short updated;
    private Boolean quaterlytest;
    private Boolean fetcommontest;
    private Short descriptionafr;
    private Short descriptionvern;
    private Integer tasktype;
    private Boolean sbatask;
    private Integer sbaweight;
    private Integer fixedcriterionscore;
    private Integer fixedweight;
    private Integer fixedsbaweight;
    private Integer subjsplitno;
    private Integer offsubjectID;
    private Integer offcriterionID;
    private Boolean reclocked;
    private Integer status;
    private Boolean fixed0weight;



 public Integer getSubjectID() {
        return this.subjectID;
    }

    public void setSubjectID(Integer value) {
        this.subjectID = value;
    }  
    public Integer getCriterionID() {
        return this.criterionID;
    }

    public void setCriterionID(Integer value) {
        this.criterionID = value;
    }  
    public Short getDescription() {
        return this.description;
    }

    public void setDescription(Short value) {
        this.description = value;
    }
    public Integer getGrade() {
        return this.grade;
    }

    public void setGrade(Integer value) {
        this.grade = value;
    }

    public Integer getWeighting() {
        return this.weighting;
    }

    public void setWeighting(Integer value ) {
        this.weighting = value;
    }

    public Short getSubjectLevel() {
        return this.subjectlevel;
    }

    public void setSubjectLevel(Short value) {
        this.subjectlevel = value;
    }

 public Integer getCriterionScore() {
        return this.criterionscore;
    }

    public void setCriterionScore(Integer value) {
        this.criterionscore = value;
    }  

    public Short getDataYear() {
        return this.datayear;
    }

    public void setDataYear(Short value) {
        this.datayear = value;
    }

    public Short getSubHeading() {
    return this.subheading;
    }

    public void setSubHeading(Short value) {
        this.subheading = value;
    }
    public Date getDateAdded() {
        return this.dateadded;
    }

    public void setDateAdded(Date value) {
        this.dateadded = value;
    }

    public Short getType() {
        return this.type;
    }

    public void setType(Short value ) {
        this.type = value;
    }

    public Long getOutcomes() {
        return this.outcomes;
    }

    public void setOutcomes(Long value) {
        this.outcomes = value;
    }
    
    public Long getActivities() {
    return this.activities;
    }

    public void setActivities(Long value) {
        this.activities = value;
    }

    public Long getAssessments() {
    return this.assessments;
    }

    public void setAssessments(Long value) {
        this.assessments = value;
    }

    public Integer getSectionID() {
        return this.sectionID;
    }

    public void setSectionID(Integer value) {
        this.sectionID = value;
    }

    public Boolean getUseActivities() {
        return this.useactivities;
    }

    public void setUseActivities(Boolean value ) {
        this.useactivities = value;
    }
   
    public Boolean getIncludeFFL() {
    return this.includeffl;
    }

    public void setIncludeFFL(Boolean value ) {
        this.includeffl = value;
    }

    public Boolean getIncludeExam() {
    return this.includeExam;
    }

    public void setIncludeExam(Boolean value ) {
        this.includeExam = value;
    }

    public Short getUpdated() {
        return this.updated;
    }

    public void setUpdated(Short value) {
        this.updated = value;
    }
    
    public Boolean getQuaterlyTest() {
       return this.quaterlytest;
    }

    public void setQuaterlyTest(Boolean value ) {
        this.quaterlytest = value;
    }

    public Boolean getFETCommonTest() {
      return this.fetcommontest;
    }

    public void setFETCommonTest(Boolean value ) {
        this.fetcommontest = value;
    }
    
     public Short getDescriptionAFR() {
    return this.descriptionafr;
    }

    public void setDescriptionAfr(Short value) {
        this.descriptionafr = value;
    }
    
     public Short getDescriptionVern() {
    return this.descriptionvern;
    }

    public void setDescriptionVern(Short value) {
        this.descriptionvern = value;
    } 

    public Integer getTaskType() {
        return this.tasktype;
    }

    public void setTaskType(Integer value) {
        this.tasktype = value;
    }  

    public Boolean getSBATask() {
      return this.sbatask;
    }

    public void setSBATask(Boolean value ) {
        this.sbatask = value;
    }

     public Integer getSBAWeight() {
        return this.sbaweight;
    }

    public void setSBAWeight(Integer value) {
        this.sbaweight = value;
    }  
    
    public Integer getFixedCriterionScore() {
        return this.fixedcriterionscore;
    }

    public void setFixeddCriterionScore(Integer value) {
        this.fixedcriterionscore = value;
    }  
    
     public Integer getFixedWeight() {
        return this.fixedweight;
    }

    public void setFixedWeight(Integer value) {
        this.fixedweight = value;
    }  

    public Integer getFixedSBAWeight() {
        return this.fixedsbaweight;
    }

    public void setFixedSBAWeight(Integer value) {
        this.fixedsbaweight= value;
    }  

    public Integer getSubjSplitNo() {
        return this.subjsplitno;
    }

    public void setSubjSplitNo(Integer value) {
        this.subjsplitno = value;
    }  

     public Integer getOFFSubjectID() {
        return this.offsubjectID;
    }

    public void setOFFSubjectID(Integer value) {
        this.offsubjectID = value;
    }  
    
    public Integer getOFFCriterionID() {
        return this.offcriterionID;
    }

    public void setOFFCriterionID(Integer value) {
        this.offcriterionID = value;
    }  

    public Boolean getRecLocked() {
      return this.reclocked;
    }

    public void setRecLocked(Boolean value ) {
        this.reclocked = value;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer value) {
        this.status = value;
    }  

     public Boolean getFixed0Weight() {
      return this.fixed0weight;
    }

    public void setFixed0Weight(Boolean value ) {
        this.fixed0weight = value;
    }

   
}

