package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;

public class ExtraMuralsCompEventsRequest implements Serializable {

    private static final long serialVersionUID = -6230990465397277966L;

    private int eventID;
    @NotNull
    private Integer compID;
    @NotNull
    private XMLGregorianCalendar eventDate;
    @NotNull
    private String eventTimeStart;
    @NotNull
    private String eventTimeEnd;
    @NotNull
    private String eventDesc;
    private String eventAfrDesc;

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public Integer getCompID() {
        return compID;
    }

    public void setCompID(Integer compID) {
        this.compID = compID;
    }

    public XMLGregorianCalendar getEventDate() {
        return eventDate;
    }

    public void setEventDate(XMLGregorianCalendar eventDate) {
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
