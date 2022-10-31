package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.EventsResource;
import za.co.sfy.lucid.sams.rest.mapper.EventsMapper;
import za.co.sfy.sams.vo.EventsRequest;
import za.co.sfy.sams.vo.EventsResponse;
import za.co.sfy.sams.lucid.schema.Events;

@Service
public class EventsService {

    private final EventsResource eventsResource;
    private final EventsMapper eventsMapper;

    @Autowired
    public EventsService(final EventsResource eventsResource, final EventsMapper eventsMapper) {
        this.eventsResource = eventsResource;
        this.eventsMapper = eventsMapper;
    }

    public EventsResponse saveEvents(EventsRequest eventsRequest) throws LucidSamsExecutionException {

        Events events = eventsMapper.eventsRequestToEvents(eventsRequest);

        Long generatedKey = eventsResource.save(events, eventsResource);
        events.setID(Math.toIntExact(generatedKey));

        EventsResponse eventsResponse = new EventsResponse();
        eventsResponse.setEvents(events);
        eventsResponse.setResponseMessage("Successfully saved 'Events' data");
        eventsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return eventsResponse;
    }
}