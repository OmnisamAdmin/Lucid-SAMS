package za.co.sfy.lucid.sams.rest.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.ExtraMuralsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("extra-murals")
public class ExtraMuralsController {

    private ExtraMuralsService extraMuralsService;
    private static final Logger logger = LoggerFactory.getLogger(ExtraMuralsController.class);

    @Autowired
    public ExtraMuralsController(final ExtraMuralsService extraMuralsService) {
        this.extraMuralsService = extraMuralsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ExtraMuralsResponse> saveExtraMurals(@Valid @RequestBody ExtraMuralsRequest extraMuralsRequest) {

        ExtraMuralsResponse extraMuralsResponse = new ExtraMuralsResponse();

        try {
            extraMuralsService.saveExtraMurals(extraMuralsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occured: " + exception.getMessage(), exception);
            extraMuralsResponse.setResponseMessage(exception.getMessage());
            extraMuralsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity
                    .unprocessableEntity()
                    .body(extraMuralsResponse);
        }

        return ResponseEntity.ok(extraMuralsResponse);
    }

}
