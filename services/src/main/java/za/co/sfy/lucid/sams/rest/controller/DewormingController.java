package za.co.sfy.lucid.sams.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.DewormingService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DewormingRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DewormingResponse;
import za.co.sfy.sams.response.ServiceStatus;

import javax.validation.Valid;

@RestController
@RequestMapping("deworming")
public class DewormingController {
    private static final Logger logger = LoggerFactory.getLogger(DewormingController.class);
    private DewormingService dewormingService;

    public DewormingController(final DewormingService dewormingService) {
        this.dewormingService = dewormingService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DewormingResponse> save(@Valid @RequestBody DewormingRequest dewormingRequest) {
        DewormingResponse dewormingResponse = new DewormingResponse();
        try {
            dewormingResponse = dewormingService.saveDeworming(dewormingRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            dewormingResponse.setResponseMessage(exception.getMessage());
            dewormingResponse.setResponseStatus(ServiceStatus.ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dewormingResponse);
        }
        return ResponseEntity.ok().body(dewormingResponse);

    }

}
