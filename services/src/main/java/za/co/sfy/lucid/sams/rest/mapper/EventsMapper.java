package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EventsRequest;
import za.co.sfy.sams.lucid.schema.Events;

@Component
public class EventsMapper {

    public Events eventsRequestToEvents(EventsRequest eventsRequest) throws LucidSamsExecutionException {

        Events events = new Events();

        events.setCategory(eventsRequest.getCategory());
        String compulsory = eventsRequest.getCompulsory();
        if (!compulsory.equalsIgnoreCase("yes") || !compulsory.equalsIgnoreCase("no")) {
            throw new LucidSamsExecutionException("Field 'Compulsory' is constrained to the values 'yes' or 'no'");
        }
        events.setCompulsory(eventsRequest.getCompulsory());
        events.setDate(eventsRequest.getDate());
        events.setDescription(eventsRequest.getDescription());
        events.setEndTime(eventsRequest.getEndTime());
        events.setExEventID(eventsRequest.getExEventID());
        events.setID(eventsRequest.getExEventID());
        events.setStartTime(eventsRequest.getStartTime());

        return events;
    }
}
