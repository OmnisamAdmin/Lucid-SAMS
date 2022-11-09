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
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.ExtraMuralsHousesService;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.ExtraMuralsHousesRequest;
import za.co.sfy.sams.vo.ExtraMuralsHousesResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("extra-murals-houses")
public class ExtraMuralsHousesController {

    private ExtraMuralsHousesService extraMuralsHousesService;
    private static final Logger logger = LoggerFactory.getLogger(ExtraMuralsHousesController.class);

    @Autowired
    public ExtraMuralsHousesController(final ExtraMuralsHousesService extraMuralsHousesService) {
        this.extraMuralsHousesService = extraMuralsHousesService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ExtraMuralsHousesResponse> saveExtraMuralsHouses(@Valid @RequestBody ExtraMuralsHousesRequest extraMuralsHousesRequest) {

        ExtraMuralsHousesResponse extraMuralsHousesResponse = new ExtraMuralsHousesResponse();

        try {
            extraMuralsHousesResponse = extraMuralsHousesService.saveExtraMuralsHouse(extraMuralsHousesRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            extraMuralsHousesResponse.setResponseMessage(exception.getMessage());
            extraMuralsHousesResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(extraMuralsHousesResponse);
        }
        return ResponseEntity.ok(extraMuralsHousesResponse);
    }
}