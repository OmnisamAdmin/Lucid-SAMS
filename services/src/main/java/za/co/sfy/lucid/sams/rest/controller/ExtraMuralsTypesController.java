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
import za.co.sfy.lucid.sams.rest.service.ExtraMuralsTypesService;
import za.co.sfy.sams.vo.ExtraMuralsTypesRequest;
import za.co.sfy.sams.vo.ExtraMuralsTypesResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("extra-murals-types")
public class ExtraMuralsTypesController {

    private ExtraMuralsTypesService extraMuralsTypesService;
    private static final Logger logger = LoggerFactory.getLogger(ExtraMuralsTypesController.class);

    @Autowired
    public ExtraMuralsTypesController(final ExtraMuralsTypesService extraMuralsTypesService) {
        this.extraMuralsTypesService = extraMuralsTypesService;

    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ExtraMuralsTypesResponse> saveExtraMuralsTypes(@Valid @RequestBody ExtraMuralsTypesRequest extraMuralsTypesRequest) {

        ExtraMuralsTypesResponse extraMuralsTypesResponse = new ExtraMuralsTypesResponse();

        try {
            extraMuralsTypesResponse = extraMuralsTypesService.saveExtraMuralsTypes(extraMuralsTypesRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occured: " + exception.getMessage(), exception);
            extraMuralsTypesResponse.setResponseMessage(exception.getMessage());
            extraMuralsTypesResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(extraMuralsTypesResponse);
        }

        return ResponseEntity.ok(extraMuralsTypesResponse);
    }
}