package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.sams.vo.ExtraMuralsCompEventsRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompEvents;

@Component
public class ExtraMuralsCompEventsMapper {

    private final SharedMapper sharedMapper;

    public ExtraMuralsCompEventsMapper(SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public ExtraMuralsCompEvents extraMuralsCompEventsRequestToExtraMuralsCompEvents(
            ExtraMuralsCompEventsRequest extraMuralsCompEventsRequest) throws LucidSamsExecutionException {

        ExtraMuralsCompEvents extraMuralsCompEvents = new ExtraMuralsCompEvents();

        Integer compID = extraMuralsCompEventsRequest.getCompID();
        if (null != compID) {
            extraMuralsCompEvents.setCompID(compID);
        }

        String eventAfrDesc = extraMuralsCompEventsRequest.getEventAfrDesc();
        if (null != eventAfrDesc) {
            extraMuralsCompEvents.setEventAfrDesc(extraMuralsCompEventsRequest.getEventAfrDesc());
        }

        String eventDate = extraMuralsCompEventsRequest.getEventDate();
        if (null != eventDate) {
            extraMuralsCompEvents.setEventDate(sharedMapper.dateToXMLGregorianCalendar(eventDate));
        }

        String eventDesc = extraMuralsCompEventsRequest.getEventDesc();
        if (null != eventDesc) {
            extraMuralsCompEvents.setEventDesc(extraMuralsCompEventsRequest.getEventDesc());
        }

        Integer eventID = extraMuralsCompEventsRequest.getEventID();
        if (null != eventID) {
            extraMuralsCompEvents.setEventID(eventID);
        }

        String eventTimeEnd = extraMuralsCompEventsRequest.getEventTimeEnd();
        if (null != eventTimeEnd) {
            extraMuralsCompEvents.setEventTimeEnd(extraMuralsCompEventsRequest.getEventTimeEnd());
        }

        String eventTimeStart = extraMuralsCompEventsRequest.getEventTimeStart();
        if (null != eventTimeStart) {
            extraMuralsCompEvents.setEventTimeStart(extraMuralsCompEventsRequest.getEventTimeStart());
        }

        return extraMuralsCompEvents;
    }

}