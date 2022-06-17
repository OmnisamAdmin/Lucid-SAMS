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
        
        String compulsory2 = eventsRequest.getCompulsory();
        if (null != compulsory2) {
        events.setCompulsory(eventsRequest.getCompulsory());
        }
        
        events.setDate(eventsRequest.getDate());
        
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
        events.setExEventID(Integer.valueOf(exEventID));
        } else {
        	eventsRequest.setExEventID(Integer.valueOf(0));
        }
        
        Integer exEventID2 = eventsRequest.getExEventID();
        if (null != exEventID2) {
        events.setID(Integer.valueOf(exEventID2));
        } else {
        	eventsRequest.setExEventID(Integer.valueOf(0));
        }
        
        String startTime = eventsRequest.getStartTime();
        if (null != startTime) {
        events.setStartTime(eventsRequest.getStartTime());
        }

        return events;
    }
}