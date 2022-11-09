package za.co.sfy.lucid.sams.rest.controller;

import javax.validation.Valid;

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
import za.co.sfy.lucid.sams.rest.service.DisciplinaryLearnerMisconductService;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.DisciplinaryLearnerMisconductRequest;
import za.co.sfy.sams.vo.DisciplinaryLearnerMisconductResponse;

/**
 * @author muzim
 */
@RestController
@RequestMapping("disciplinary-learner-misconduct")
public class DisciplinaryLearnerMisconductController {

    private DisciplinaryLearnerMisconductService disciplinaryLearnerMisconductService;
    private static final Logger logger = LoggerFactory.getLogger(DisciplinaryLearnerMisconductController.class);

    @Autowired
    public DisciplinaryLearnerMisconductController(final DisciplinaryLearnerMisconductService disciplinaryLearnerMisconductService) {
        this.disciplinaryLearnerMisconductService = disciplinaryLearnerMisconductService;
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DisciplinaryLearnerMisconductResponse> saveDisciplinaryLearnerMisconduct
            (@Valid @RequestBody DisciplinaryLearnerMisconductRequest disciplinaryLearnerMisconductRequest) {

        DisciplinaryLearnerMisconductResponse disciplinaryLearnerMisconductResponse = new DisciplinaryLearnerMisconductResponse();

        try {
            disciplinaryLearnerMisconductResponse = disciplinaryLearnerMisconductService.saveDisciplinaryLearnerMisconduct(disciplinaryLearnerMisconductRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            disciplinaryLearnerMisconductResponse.setResponseStatus(ServiceStatus.ERROR.value());
            disciplinaryLearnerMisconductResponse.setResponseMessage(exception.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(disciplinaryLearnerMisconductResponse);
        }

        return ResponseEntity.ok(disciplinaryLearnerMisconductResponse);
    }
}