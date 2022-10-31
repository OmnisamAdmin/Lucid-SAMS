package za.co.sfy.lucid.sams.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.EventsService;
import za.co.sfy.sams.vo.EventsRequest;
import za.co.sfy.sams.vo.EventsResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("events")
public class EventsController {

    private EventsService eventsService;
    private static final Logger logger = LoggerFactory.getLogger(EventsController.class);

    @Autowired
    public EventsController(final EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EventsResponse> saveEvents(@Valid @RequestBody EventsRequest eventsRequest) {

        EventsResponse eventsResponse = new EventsResponse();
        try {
            eventsResponse = eventsService.saveEvents(eventsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            eventsResponse.setResponseMessage(exception.getMessage());
            eventsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(eventsResponse);
        }

        return ResponseEntity.ok(eventsResponse);
    }

}