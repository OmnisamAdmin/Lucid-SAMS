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
import za.co.sfy.lucid.sams.rest.service.ExtraMuralsCompetitionsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompetitionsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompetitionsResponse;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * @author muzim
 */
@RestController
@RequestMapping("ExtraMuralsCompetitions")
public class ExtraMuralsCompetitionsController {

    private static final Logger logger = LoggerFactory.getLogger(ExtraMuralsCompetitionsController.class);
    private ExtraMuralsCompetitionsService extraMuralsCompetitionsService;

    @Autowired
    public ExtraMuralsCompetitionsController(final ExtraMuralsCompetitionsService extraMuralsCompetitionsService) {
        this.extraMuralsCompetitionsService = extraMuralsCompetitionsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ExtraMuralsCompetitionsResponse> saveExtraMuralsCompetitions
            (@Valid @RequestBody ExtraMuralsCompetitionsRequest extraMuralsCompetitionsRequest) {

        ExtraMuralsCompetitionsResponse extraMuralsCompetitionsResponse = new ExtraMuralsCompetitionsResponse();

        try {
            extraMuralsCompetitionsResponse = extraMuralsCompetitionsService
                    .saveExtraMuralsCompetitions(extraMuralsCompetitionsRequest);

        } catch (LucidSamsExecutionException | SQLException exception) {
            logger.error("Failure occurred: " + exception.getMessage());
            extraMuralsCompetitionsResponse.setResponseMessage(exception.getMessage());
            extraMuralsCompetitionsResponse.setResponseStatus(ServiceStatus.ERROR.value());
        }

        return ResponseEntity.ok(extraMuralsCompetitionsResponse);
    }
}
