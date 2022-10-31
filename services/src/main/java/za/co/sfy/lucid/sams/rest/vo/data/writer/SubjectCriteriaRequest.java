
package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.sql.Date;


public class SubjectCriteriaRequest implements Serializable {

    private static final long serialVersionUID = 6627252016141632712L;

    private Integer subjectID;
    private Integer criterionID;
    private String description;
    private Integer grade;
    private Integer weighting;
    private String subjectLevel;
    private Integer criterionScore;
    private String dataYear;
    private String subHeading;
    private XMLGregorianCalendar dateAdded;
    private String type;
    private String outcomes;
    private String activities;
    private String assessments;
    private Integer sectionID;
    private Boolean useActivities;
    private Boolean includeFfl;
    private Boolean includeExam;
    private String updated;
    private Boolean quarterlyTest;
    private Boolean fetCommonTest;
    private String descriptionAfr;
    private String descriptionVern;
    private Integer taskType;
    private Boolean sbaTask;
    private Double sbaWeight;
    private Integer fixedCriterionScore;
    private Double fixedWeight;
    private Double fixedSbaWeight;
    private Integer subjSplitNo;
    private Integer offSubjectID;
    private Integer offCriterionID;
    private Boolean recLocked;
    private Short status;
    private Boolean fixed0Weight;

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
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

    public void setWeighting(Integer value) {
        this.weighting = value;
    }

    public String getSubjectLevel() {
        return this.subjectLevel;
    }

    public void setSubjectLevel(String value) {
        this.subjectLevel = value;
    }

    public Integer getCriterionScore() {
        return this.criterionScore;
    }

    public void setCriterionScore(Integer value) {
        this.criterionScore = value;
    }

    public String getDataYear() {
        return this.dataYear;
    }

    public void setDataYear(String value) {
        this.dataYear = value;
    }

    public String getSubHeading() {
        return this.subHeading;
    }

    public void setSubHeading(String value) {
        this.subHeading = value;
    }

    public XMLGregorianCalendar getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(XMLGregorianCalendar value) {
        this.dateAdded = value;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getOutcomes() {
        return this.outcomes;
    }

    public void setOutcomes(String value) {
        this.outcomes = value;
    }

    public String getActivities() {
        return this.activities;
    }

    public void setActivities(String value) {
        this.activities = value;
    }

    public String getAssessments() {
        return this.assessments;
    }

    public void setAssessments(String value) {
        this.assessments = value;
    }

    public Integer getSectionID() {
        return this.sectionID;
    }

    public void setSectionID(Integer value) {
        this.sectionID = value;
    }

    public Boolean getUseActivities() {
        return this.useActivities;
    }

    public void setUseActivities(Boolean value) {
        this.useActivities = value;
    }

    public Boolean getIncludeFFL() {
        return this.includeFfl;
    }

    public void setIncludeFFL(Boolean value) {
        this.includeFfl = value;
    }

    public Boolean getIncludeExam() {
        return this.includeExam;
    }

    public void setIncludeExam(Boolean value) {
        this.includeExam = value;
    }

    public String getUpdated() {
        return this.updated;
    }

    public void setUpdated(String value) {
        this.updated = value;
    }

    public Boolean getQuarterlyTest() {
        return this.quarterlyTest;
    }

    public void setQuarterlyTest(Boolean value) {
        this.quarterlyTest = value;
    }

    public Boolean getFETCommonTest() {
        return this.fetCommonTest;
    }

    public void setFETCommonTest(Boolean value) {
        this.fetCommonTest = value;
    }

    public String getDescriptionAFR() {
        return this.descriptionAfr;
    }

    public void setDescriptionAfr(String value) {
        this.descriptionAfr = value;
    }

    public String getDescriptionVern() {
        return this.descriptionVern;
    }

    public void setDescriptionVern(String value) {
        this.descriptionVern = value;
    }

    public Integer getTaskType() {
        return this.taskType;
    }

    public void setTaskType(Integer value) {
        this.taskType = value;
    }

    public Boolean getSBATask() {
        return this.sbaTask;
    }

    public void setSBATask(Boolean value) {
        this.sbaTask = value;
    }

    public Double getSBAWeight() {
        return this.sbaWeight;
    }

    public void setSBAWeight(Double value) {
        this.sbaWeight = value;
    }

    public Integer getFixedCriterionScore() {
        return this.fixedCriterionScore;
    }

    public void setFixeddCriterionScore(Integer value) {
        this.fixedCriterionScore = value;
    }

    public Double getFixedWeight() {
        return this.fixedWeight;
    }

    public void setFixedWeight(Double value) {
        this.fixedWeight = value;
    }

    public Double getFixedSBAWeight() {
        return this.fixedSbaWeight;
    }

    public void setFixedSBAWeight(Double value) {
        this.fixedSbaWeight = value;
    }

    public Integer getSubjSplitNo() {
        return this.subjSplitNo;
    }

    public void setSubjSplitNo(Integer value) {
        this.subjSplitNo = value;
    }

    public Integer getOFFSubjectID() {
        return this.offSubjectID;
    }

    public void setOFFSubjectID(Integer value) {
        this.offSubjectID = value;
    }

    public Integer getOFFCriterionID() {
        return this.offCriterionID;
    }

    public void setOFFCriterionID(Integer value) {
        this.offCriterionID = value;
    }

    public Boolean getRecLocked() {
        return this.recLocked;
    }

    public void setRecLocked(Boolean value) {
        this.recLocked = value;
    }

    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short value) {
        this.status = value;
    }

    public Boolean getFixed0Weight() {
        return this.fixed0Weight;
    }

    public void setFixed0Weight(Boolean value) {
        this.fixed0Weight = value;
    }
}