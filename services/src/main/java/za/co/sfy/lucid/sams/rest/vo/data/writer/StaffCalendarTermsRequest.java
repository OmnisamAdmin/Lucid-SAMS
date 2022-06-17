package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class StaffCalendarTermsRequest implements Serializable {

    private static final long serialVersionUID = 1007553683886591996L;

    private Integer id;
    @NotNull
    private String quater;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;
    @NotNull
    private String currentYear;
    @NotNull
    private Integer term;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuater() {
        return quater;
    }

    public void setQuater(String quater) {
        this.quater = quater;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}