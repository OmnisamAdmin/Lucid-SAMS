
package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SubjectsRequest implements Serializable {

    private static final long serialVersionUID = 6627252016141632712L;

    private Integer id;
    private String name;
    private String key;
    @NotBlank
    private String code;
    private String group;
    @NotNull
    private Integer selected;
    private Integer phase;
    private String afrname;
    private Integer printOrder;
    private Integer ctaWeight;
    private Integer excludeSchedule;
    private String luritsCode;
    private Short subjectStatus;
    @NotNull
    private Integer subjectGrade;
    private Integer officialSubjectID;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String value) {
        this.key = value;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String value) {
        this.group = value;
    }

    public Integer getSelected() {
        return this.selected;
    }

    public void setSelected(Integer value) {
        this.selected = value;
    }

    public Integer getPhase() {
        return this.phase;
    }

    public void setPhase(Integer value) {
        this.phase = value;
    }

    public String getAfrname() {
        return this.afrname;
    }

    public void setAfrname(String value) {
        this.afrname = value;
    }

    public Integer getPrintOrder() {
        return this.printOrder;
    }

    public void setPrintOrder(Integer value) {
        this.printOrder = value;
    }

    public Integer getCTAWeight() {
        return this.ctaWeight;
    }

    public void setCTAWeight(Integer value) {
        this.ctaWeight = value;
    }

    public Integer getExcludeSchedule() {
        return this.excludeSchedule;
    }

    public void setExcludeSchedule(Integer value) {
        this.excludeSchedule = value;
    }

    public String getLuritsCode() {
        return this.luritsCode;
    }

    public void setLuritsCode(String value) {
        this.luritsCode = value;
    }

    public Short getSubjectStatus() {
        return this.subjectStatus;
    }

    public void setSubjectStatus(Short value) {
        this.subjectStatus = value;
    }

    public Integer getSubjectGrade() {
        return this.subjectGrade;
    }

    public void setSubjectGrade(Integer value) {
        this.subjectGrade = value;
    }

    public Integer getOfficialSubjectID() {
        return this.officialSubjectID;
    }

    public void setOfficialSubjectID(Integer value) {
        this.officialSubjectID = value;
    }
}
