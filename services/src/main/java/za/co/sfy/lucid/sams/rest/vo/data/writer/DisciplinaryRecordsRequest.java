package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DisciplinaryRecordsRequest implements Serializable {

    private static final long serialVersionUID = 7596257080579932111L;

    private Integer id;
    @NotNull
    private Integer learnerid;
    @NotBlank
    private String date;
    private String comment;
    @NotBlank
    private String levelMisconduct;
    @NotBlank
    private String misconductCode;
    @NotBlank
    private String misconductDescription;
    private String actionLevel;
    private String actionCode;
    private String actionDescription;
    private String disciplinedBy;
    @NotBlank
    private String authorisedBy;
    private String agency;
    @NotNull
    private Integer suspension;
    @NotBlank
    private String option;
    private String expulsionDate;
    @NotBlank
    private String month;
    private String recommendedExpulsion;
    @NotBlank
    private String datayear;
    private Integer demerit;
    private Integer merit;
    @NotBlank
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLearnerid() {
        return learnerid;
    }

    public void setLearnerid(Integer learnerid) {
        this.learnerid = learnerid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLevelMisconduct() {
        return levelMisconduct;
    }

    public void setLevelMisconduct(String levelMisconduct) {
        this.levelMisconduct = levelMisconduct;
    }

    public String getMisconductCode() {
        return misconductCode;
    }

    public void setMisconductCode(String misconductCode) {
        this.misconductCode = misconductCode;
    }

    public String getMisconductDescription() {
        return misconductDescription;
    }

    public void setMisconductDescription(String misconductDescription) {
        this.misconductDescription = misconductDescription;
    }

    public String getActionLevel() {
        return actionLevel;
    }

    public void setActionLevel(String actionLevel) {
        this.actionLevel = actionLevel;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public String getDisciplinedBy() {
        return disciplinedBy;
    }

    public void setDisciplinedBy(String disciplinedBy) {
        this.disciplinedBy = disciplinedBy;
    }

    public String getAuthorisedBy() {
        return authorisedBy;
    }

    public void setAuthorisedBy(String authorisedBy) {
        this.authorisedBy = authorisedBy;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Integer getSuspension() {
        return suspension;
    }

    public void setSuspension(Integer suspension) {
        this.suspension = suspension;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getExpulsionDate() {
        return expulsionDate;
    }

    public void setExpulsionDate(String expulsionDate) {
        this.expulsionDate = expulsionDate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getRecommendedExpulsion() {
        return recommendedExpulsion;
    }

    public void setRecommendedExpulsion(String recommendedExpulsion) {
        this.recommendedExpulsion = recommendedExpulsion;
    }

    public String getDatayear() {
        return datayear;
    }

    public void setDatayear(String datayear) {
        this.datayear = datayear;
    }

    public Integer getDemerit() {
        return demerit;
    }

    public void setDemerit(Integer demerit) {
        this.demerit = demerit;
    }

    public Integer getMerit() {
        return merit;
    }

    public void setMerit(Integer merit) {
        this.merit = merit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
