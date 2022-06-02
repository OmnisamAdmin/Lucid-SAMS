package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;

public class EventsRequest implements Serializable {

    private static final long serialVersionUID = -2612607476431909238L;

    private int id;
    @NotNull
    private XMLGregorianCalendar date;
    @NotNull
    private String startTime;
    @NotNull
    private String endTime;
    @NotNull
    private String description;
    @NotNull
    private String compulsory;
    @NotNull
    private String category;
    private Integer exEventID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public XMLGregorianCalendar getDate() {
        return date;
    }

    public void setDate(XMLGregorianCalendar date) {
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
