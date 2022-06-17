package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ExtraMuralsCompEventsRequest implements Serializable {

    private static final long serialVersionUID = -6230990465397277966L;

    private Integer eventID;
    @NotNull
    private Integer compID;
    @NotNull
    private String eventDate;
    @NotBlank
    private String eventTimeStart;
    @NotBlank
    private String eventTimeEnd;
    @NotBlank
    private String eventDesc;
    private String eventAfrDesc;

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getCompID() {
        return compID;
    }

    public void setCompID(Integer compID) {
        this.compID = compID;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTimeStart() {
        return eventTimeStart;
    }

    public void setEventTimeStart(String eventTimeStart) {
        this.eventTimeStart = eventTimeStart;
    }

    public String getEventTimeEnd() {
        return eventTimeEnd;
    }

    public void setEventTimeEnd(String eventTimeEnd) {
        this.eventTimeEnd = eventTimeEnd;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventAfrDesc() {
        return eventAfrDesc;
    }

    public void setEventAfrDesc(String eventAfrDesc) {
        this.eventAfrDesc = eventAfrDesc;
    }
}
