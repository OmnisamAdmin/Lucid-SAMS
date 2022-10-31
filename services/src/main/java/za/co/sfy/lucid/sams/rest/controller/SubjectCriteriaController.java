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
import za.co.sfy.lucid.sams.rest.service.SubjectCriteriaService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectCriteriaRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectCriteriaResponse;

import javax.validation.Valid;


/**
 * @author ahussain
 */
@RestController
@RequestMapping("subject-criteria")
public class SubjectCriteriaController {

    private static final Logger logger = LoggerFactory.getLogger(SubjectCriteriaController.class);
    private SubjectCriteriaService subjectCriteriaService;

    @Autowired
    public SubjectCriteriaController(final SubjectCriteriaService subjectcriteriaService) {
        this.subjectCriteriaService = subjectcriteriaService;
    }

    @PostMapping(
            path = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SubjectCriteriaResponse> updateSubjectCriteria(@Valid @RequestBody SubjectCriteriaRequest subjectcriteriaRequest) {

        SubjectCriteriaResponse subjectcriteriaResponse = new SubjectCriteriaResponse();
        try {
            subjectcriteriaResponse = subjectCriteriaService.updateSubjectCriteria(subjectcriteriaRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            subjectcriteriaResponse.setResponseStatus(ServiceStatus.ERROR.value());
            subjectcriteriaResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(subjectcriteriaResponse);
        }

        return ResponseEntity.ok(subjectcriteriaResponse);
    }

    @PostMapping(
            path = "save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SubjectCriteriaResponse> saveSubjectCriteria(@Valid @RequestBody SubjectCriteriaRequest subjectcriteriaRequest) {

        SubjectCriteriaResponse subjectcriteriaResponse = new SubjectCriteriaResponse();
        try {
            subjectcriteriaResponse = subjectCriteriaService.saveSubjectCriteria(subjectcriteriaRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            subjectcriteriaResponse.setResponseStatus(ServiceStatus.ERROR.value());
            subjectcriteriaResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(subjectcriteriaResponse);
        }

        return ResponseEntity.ok(subjectcriteriaResponse);
    }
}