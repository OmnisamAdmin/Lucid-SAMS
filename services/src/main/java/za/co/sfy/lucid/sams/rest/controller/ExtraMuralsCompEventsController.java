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
import za.co.sfy.lucid.sams.rest.service.ExtraMuralsCompEventsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompEventsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompEventsResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("extra-murals-comp-events")
public class ExtraMuralsCompEventsController {

    private static final Logger logger = LoggerFactory.getLogger(ExtraMuralsCompEventsController.class);
    private ExtraMuralsCompEventsService extraMuralsCompEventsService;

    @Autowired
    public ExtraMuralsCompEventsController(final ExtraMuralsCompEventsService extraMuralsCompEventsService) {
        this.extraMuralsCompEventsService = extraMuralsCompEventsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ExtraMuralsCompEventsResponse> saveExtraMuralsCompEvents
            (@Valid @RequestBody ExtraMuralsCompEventsRequest extraMuralsCompEventsRequest) {

        ExtraMuralsCompEventsResponse extraMuralsCompEventsResponse = new ExtraMuralsCompEventsResponse();

        try {
            extraMuralsCompEventsResponse = extraMuralsCompEventsService.saveExtraMuralsCompEvents(extraMuralsCompEventsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            extraMuralsCompEventsResponse.setResponseMessage(exception.getMessage());
            extraMuralsCompEventsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(extraMuralsCompEventsResponse);
        }

        return ResponseEntity.ok(extraMuralsCompEventsResponse);
    }

}
