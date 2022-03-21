package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author muzim
 */
public class CycleInfoRequest implements Serializable {

    private static final long serialVersionUID = 4802851169585541994L;

    @NotBlank
    private String schoolname;
    @NotBlank
    private Integer fetDays;
    @NotBlank
    private Integer rooms;
    @NotBlank
    private Integer fetPeriods;
    @NotBlank
    private Integer lowestGrade;
    @NotBlank
    private Integer highestGrade;
    @NotBlank
    private Integer feTlength;
    @NotBlank
    private String lsen;
    @NotBlank
    private String remedial;
    @NotBlank
    private Integer fetTotal;
    @NotBlank
    private Integer getDays;
    @NotBlank
    private Integer getPeriods;
    @NotBlank
    private Integer getLength;
    @NotBlank
    private Integer getTotal;
    @NotBlank
    private boolean lsenSchool;
    @NotBlank
    private Integer sneSpec;
    @NotBlank
    private String sneSpecOther;
    @NotBlank
    private Short schoolType;
    @NotBlank
    private String multiGrade;
    @NotBlank
    private String sid;
    @NotBlank
    private Integer sidLowestYear;
    @NotBlank
    private Integer sidHighestYear;

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public Integer getFetDays() {
        return fetDays;
    }

    public void setFetDays(Integer fetDays) {
        this.fetDays = fetDays;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getFetPeriods() {
        return fetPeriods;
    }

    public void setFetPeriods(Integer fetPeriods) {
        this.fetPeriods = fetPeriods;
    }

    public Integer getLowestGrade() {
        return lowestGrade;
    }

    public void setLowestGrade(Integer lowestGrade) {
        this.lowestGrade = lowestGrade;
    }

    public Integer getHighestGrade() {
        return highestGrade;
    }

    public void setHighestGrade(Integer highestGrade) {
        this.highestGrade = highestGrade;
    }

    public Integer getFeTlength() {
        return feTlength;
    }

    public void setFeTlength(Integer feTlength) {
        this.feTlength = feTlength;
    }

    public String getLsen() {
        return lsen;
    }

    public void setLsen(String lsen) {
        this.lsen = lsen;
    }

    public String getRemedial() {
        return remedial;
    }

    public void setRemedial(String remedial) {
        this.remedial = remedial;
    }

    public Integer getFetTotal() {
        return fetTotal;
    }

    public void setFetTotal(Integer fetTotal) {
        this.fetTotal = fetTotal;
    }

    public Integer getGetDays() {
        return getDays;
    }

    public void setGetDays(Integer getDays) {
        this.getDays = getDays;
    }

    public Integer getGetPeriods() {
        return getPeriods;
    }

    public void setGetPeriods(Integer getPeriods) {
        this.getPeriods = getPeriods;
    }

    public Integer getGetLength() {
        return getLength;
    }

    public void setGetLength(Integer getLength) {
        this.getLength = getLength;
    }

    public Integer getGetTotal() {
        return getTotal;
    }

    public void setGetTotal(Integer getTotal) {
        this.getTotal = getTotal;
    }

    public boolean isLsenSchool() {
        return lsenSchool;
    }

    public void setLsenSchool(boolean lsenSchool) {
        this.lsenSchool = lsenSchool;
    }

    public Integer getSneSpec() {
        return sneSpec;
    }

    public void setSneSpec(Integer sneSpec) {
        this.sneSpec = sneSpec;
    }

    public String getSneSpecOther() {
        return sneSpecOther;
    }

    public void setSneSpecOther(String sneSpecOther) {
        this.sneSpecOther = sneSpecOther;
    }

    public Short getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(Short schoolType) {
        this.schoolType = schoolType;
    }

    public String getMultiGrade() {
        return multiGrade;
    }

    public void setMultiGrade(String multiGrade) {
        this.multiGrade = multiGrade;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getSidLowestYear() {
        return sidLowestYear;
    }

    public void setSidLowestYear(Integer sidLowestYear) {
        this.sidLowestYear = sidLowestYear;
    }

    public Integer getSidHighestYear() {
        return sidHighestYear;
    }

    public void setSidHighestYear(Integer sidHighestYear) {
        this.sidHighestYear = sidHighestYear;
    }
}
