package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EventsRequest;
import za.co.sfy.sams.lucid.schema.Events;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class EventsMapper {

    private final SharedMapper sharedMapper;

    public EventsMapper(SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public Events eventsRequestToEvents(EventsRequest eventsRequest) throws LucidSamsExecutionException {

        Events events = new Events();

        events.setCategory(eventsRequest.getCategory());

        String compulsory = eventsRequest.getCompulsory();
        if (null != compulsory) {
            if (!compulsory.equalsIgnoreCase("yes") && !compulsory.equalsIgnoreCase("no")) {
                throw new LucidSamsExecutionException("Field 'Compulsory' is constrained to the values 'yes' or 'no'");
            }
            events.setCompulsory(eventsRequest.getCompulsory());
        }

        String date = eventsRequest.getDate();
        if (null != date) {
            XMLGregorianCalendar convertedDate = sharedMapper.dateToXMLGregorianCalendar(date);
            events.setDate(convertedDate);
        }

        String description = eventsRequest.getDescription();
        if (null != description) {
            events.setDescription(eventsRequest.getDescription());
        }

        String endTime = eventsRequest.getEndTime();
        if (null != endTime) {
            events.setEndTime(eventsRequest.getEndTime());
        }

        Integer exEventID = eventsRequest.getExEventID();
        if (null != exEventID) {
            events.setExEventID(exEventID);
        } else {
            eventsRequest.setExEventID(0);
        }

        String startTime = eventsRequest.getStartTime();
        if (null != startTime) {
            events.setStartTime(eventsRequest.getStartTime());
        }

        return events;
    }
}
