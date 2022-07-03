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
import za.co.sfy.lucid.sams.rest.service.HostelsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.HostelsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.HostelsResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("hostels")
public class HostelsController {

    private HostelsService hostelsService;
    private static final Logger logger = LoggerFactory.getLogger(HostelsController.class);

    @Autowired
    public HostelsController(final HostelsService hostelsService) {
        this.hostelsService = hostelsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<HostelsResponse> saveHostels(@Valid @RequestBody HostelsRequest hostelsRequest) {

        HostelsResponse hostelsResponse = new HostelsResponse();

        try {
            hostelsResponse = hostelsService.saveHostels(hostelsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occured: " + exception.getMessage(), exception);
            hostelsResponse.setResponseMessage(exception.getMessage());
            hostelsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hostelsResponse);
        }

        return ResponseEntity.ok(hostelsResponse);
    }

}
