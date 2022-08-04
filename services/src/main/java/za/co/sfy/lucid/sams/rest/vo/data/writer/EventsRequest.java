package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;

public class EventsRequest implements Serializable {

    private static final long serialVersionUID = -2612607476431909238L;

    private Integer id;
    @NotNull
    private String date;
    @NotBlank
    private String startTime;
    @NotBlank
    private String endTime;
    @NotBlank
    private String description;
    @NotBlank
    private String compulsory;
    @NotBlank
    private String category;
    private Integer exEventID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompulsory() {
        return compulsory;
    }

    public void setCompulsory(String compulsory) {
        this.compulsory = compulsory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getExEventID() {
        return exEventID;
    }

    public void setExEventID(Integer exEventID) {
        this.exEventID = exEventID;
    }
}
