package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class StaffLeaveRequest implements Serializable {

    private static final long serialVersionUID = -6897247073900161829L;

    private Integer id;
    @NotNull
    private Integer linkId;
    @NotBlank
    private String dateStart;
    @NotBlank
    private String dateEnd;
    @NotBlank
    private String type;
    @NotNull
    private Integer days;
    private String comment;
    @NotBlank
    private String personnelCategory;
    @NotBlank
    private String year;
    @NotBlank
    private String replaced;
    @NotBlank
    private String paid;
    private String documentation;
    @NotNull
    private Boolean leaveDocRequired;
    @NotBlank
    private String weekID;
    private String tmpField;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPersonnelCategory() {
        return personnelCategory;
    }

    public void setPersonnelCategory(String personnelCategory) {
        this.personnelCategory = personnelCategory;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getReplaced() {
        return replaced;
    }

    public void setReplaced(String replaced) {
        this.replaced = replaced;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public Boolean getLeaveDocRequired() {
        return leaveDocRequired;
    }

    public void setLeaveDocRequired(Boolean leaveDocRequired) {
        this.leaveDocRequired = leaveDocRequired;
    }

    public String getWeekID() {
        return weekID;
    }

    public void setWeekID(String weekID) {
        this.weekID = weekID;
    }

    public String getTmpField() {
        return tmpField;
    }

    public void setTmpField(String tmpField) {
        this.tmpField = tmpField;
    }
}
