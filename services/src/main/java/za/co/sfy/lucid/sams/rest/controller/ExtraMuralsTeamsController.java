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
import za.co.sfy.lucid.sams.rest.service.ExtraMuralsTeamsService;
import za.co.sfy.sams.vo.ExtraMuralsTeamsRequest;
import za.co.sfy.sams.vo.ExtraMuralsTeamsResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("extra-murals-teams")
public class ExtraMuralsTeamsController {

    private static final Logger logger = LoggerFactory.getLogger(ExtraMuralsTeamsController.class);
    private ExtraMuralsTeamsService extraMuralsTeamsService;

    @Autowired
    public ExtraMuralsTeamsController(final ExtraMuralsTeamsService extraMuralsTeamsService) {
        this.extraMuralsTeamsService = extraMuralsTeamsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ExtraMuralsTeamsResponse> saveExtraMuralsTeamsResponse
            (@Valid @RequestBody ExtraMuralsTeamsRequest extraMuralsTeamsRequest) {

        ExtraMuralsTeamsResponse extraMuralsTeamsResponse = new ExtraMuralsTeamsResponse();

        try {
            extraMuralsTeamsResponse = extraMuralsTeamsService.saveExtraMuralsTeams(extraMuralsTeamsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            extraMuralsTeamsResponse.setResponseMessage(exception.getMessage());
            extraMuralsTeamsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(extraMuralsTeamsResponse);
        }
        return ResponseEntity.ok(extraMuralsTeamsResponse);
    }

}