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
import za.co.sfy.lucid.sams.rest.service.LearnerInfoService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearnerInfoRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearnerInfoResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("learner-infos")
public class LearnerInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LearnerInfoController.class);
    private LearnerInfoService learnerInfoService;

    @Autowired
    public LearnerInfoController(final LearnerInfoService learnerInfoService) {
        this.learnerInfoService = learnerInfoService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LearnerInfoResponse> saveLearnerInfo(@Valid @RequestBody LearnerInfoRequest learnerInfoRequest) {

        LearnerInfoResponse learnerInfoResponse = new LearnerInfoResponse();

        try {
            learnerInfoResponse = learnerInfoService.saveLearnerInfo(learnerInfoRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            learnerInfoResponse.setResponseStatus(ServiceStatus.ERROR.value());
            learnerInfoResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(learnerInfoResponse);
        }

        return ResponseEntity.ok(learnerInfoResponse);
    }

}
