package za.co.sfy.lucid.sams.rest.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.ParentChildService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ParentChildRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ParentChildResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("parent-child")
public class ParentChildController {

    private static final Logger logger = LoggerFactory.getLogger(ParentChildController.class);
    private ParentChildService parentChildService;

    @Autowired
    public ParentChildController(final ParentChildService parentChildService) {
        this.parentChildService = parentChildService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ParentChildResponse> saveParentChild(@Valid @RequestBody ParentChildRequest parentChildRequest) {
        ParentChildResponse parentChildResponse = new ParentChildResponse();
        try {
            parentChildResponse = parentChildService.saveParentChild(parentChildRequest);
        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            parentChildResponse.setResponseStatus(ServiceStatus.ERROR.value());
            parentChildResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity
                    .unprocessableEntity()
                    .body(parentChildResponse);
        }

        return ResponseEntity.ok(parentChildResponse);
    }
}
