package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompEventsRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompEvents;

@Component
public class ExtraMuralsCompEventsMapper {

    private final SharedMapper sharedMapper;

    public ExtraMuralsCompEventsMapper(final SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public ExtraMuralsCompEvents extraMuralsCompEventsRequestToExtraMuralsCompEvents
            (ExtraMuralsCompEventsRequest extraMuralsCompEventsRequest) {

        ExtraMuralsCompEvents extraMuralsCompEvents = new ExtraMuralsCompEvents();

        extraMuralsCompEvents.setCompID(extraMuralsCompEventsRequest.getCompID());
        extraMuralsCompEvents.setEventAfrDesc(extraMuralsCompEventsRequest.getEventAfrDesc());
        extraMuralsCompEvents.setEventDate(extraMuralsCompEventsRequest.getEventDate());
        extraMuralsCompEvents.setEventDesc(extraMuralsCompEventsRequest.getEventDesc());
        extraMuralsCompEvents.setEventID(extraMuralsCompEventsRequest.getEventID());
        extraMuralsCompEvents.setEventTimeEnd(extraMuralsCompEventsRequest.getEventTimeEnd());
        extraMuralsCompEvents.setEventTimeStart(extraMuralsCompEventsRequest.getEventTimeStart());

        return extraMuralsCompEvents;
    }

}
