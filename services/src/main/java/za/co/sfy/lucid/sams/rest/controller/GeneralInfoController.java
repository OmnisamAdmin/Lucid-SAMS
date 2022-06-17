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
import za.co.sfy.lucid.sams.rest.service.GeneralInfoService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.GeneralInfoRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.GeneralInfoResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("general-infos")
public class GeneralInfoController {

    private static final Logger logger = LoggerFactory.getLogger(GeneralInfoController.class);
    private GeneralInfoService generalInfoService;

    @Autowired
    public GeneralInfoController(final GeneralInfoService generalInfoService) {
        this.generalInfoService = generalInfoService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GeneralInfoResponse> saveGeneralInfo(@Valid @RequestBody GeneralInfoRequest generalInfoRequest) {

        GeneralInfoResponse generalInfoResponse = new GeneralInfoResponse();

        try {
            generalInfoResponse = generalInfoService.saveGeneralInfo(generalInfoRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            generalInfoResponse.setResponseStatus(ServiceStatus.ERROR.value());
            generalInfoResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity
                    .unprocessableEntity()
                    .body(generalInfoResponse);
        }

        return ResponseEntity.ok(generalInfoResponse);
    }


}
