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
import za.co.sfy.lucid.sams.rest.service.FeederSchoolsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.FeederSchoolResponse;
import za.co.sfy.lucid.sams.rest.vo.data.writer.FeederSchoolsRequest;

import javax.validation.Valid;

@RestController
@RequestMapping("feeder-schools")
public class FeederSchoolsController {

    private FeederSchoolsService feederSchoolsService;
    private static final Logger logger = LoggerFactory.getLogger(FeederSchoolsController.class);

    @Autowired
    public FeederSchoolsController(final FeederSchoolsService feederSchoolsService) {
        this.feederSchoolsService = feederSchoolsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FeederSchoolResponse> saveFeederSchools(@Valid @RequestBody FeederSchoolsRequest feederSchoolsRequest) {

        FeederSchoolResponse feederSchoolResponse = new FeederSchoolResponse();

        try {
            feederSchoolResponse = feederSchoolsService.saveFeederSchools(feederSchoolsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occured: " + exception.getMessage());
            feederSchoolResponse.setResponseMessage(exception.getMessage());
            feederSchoolResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity
                    .unprocessableEntity()
                    .body(feederSchoolResponse);
        }

        return ResponseEntity.ok(feederSchoolResponse);
    }
}
