package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SchoolTermsRequest implements Serializable {

    private static final long serialVersionUID = 4285025394641057292L;

    private int id;
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

    public int getId() {
        return this.id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getQuater() {
        return this.quater;
    }

    public void setQuater(String value) {
        this.quater = value;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String value) {
        this.startDate = value;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String value) {
        this.endDate = value;
    }

    public String getCurrentYear() {
        return this.currentYear;
    }

    public void setCurrentYear(String value) {
        this.currentYear = value;
    }

    public Integer getTerm() {
        return this.term;
    }

    public void setTerm(Integer value) {
        this.term = value;
    }
}