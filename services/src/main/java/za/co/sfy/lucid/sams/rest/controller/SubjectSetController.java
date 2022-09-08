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

import javax.validation.Valid;

import za.co.sfy.lucid.sams.rest.service.SubjectSetService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectSetRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectSetResponse;


/**
 * @author Azeem
 */
@RestController
@RequestMapping("subject-sets")
public class SubjectSetController {

<<<<<<<< HEAD:services/src/main/java/za/co/sfy/lucid/sams/rest/controller/SubjectSetController.java
    private static final Logger logger = LoggerFactory.getLogger(SubjectSetController.class);
    private SubjectSetService subjectsetService;
========
    private static final Logger logger = LoggerFactory.getLogger(TopicsController.class);
    private final TopicsService TopicsService;
>>>>>>>> 369468b... SAA-1113: SASAMS Module 12.1.14 and 12.1.16:services/src/main/java/za/co/sfy/lucid/sams/rest/controller/TopicsController.java

    @Autowired
    public SubjectSetController(final SubjectSetService subjectsetService) {
        this.subjectsetService = subjectsetService;
    }

    @PostMapping(
            path = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SubjectSetResponse> updateSubjectSets(@Valid @RequestBody SubjectSetRequest subjectsetRequest) {

        SubjectSetResponse subjectsetResponse = new SubjectSetResponse();
        try {
            subjectsetResponse = subjectsetService.updateSubjectSet(subjectsetRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            subjectsetResponse.setResponseStatus(ServiceStatus.ERROR.value());
            subjectsetResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(subjectsetResponse);
        }

        return ResponseEntity.ok(subjectsetResponse);
    }

    @PostMapping(
            path = "save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SubjectSetResponse> saveSubjectSets(@Valid @RequestBody SubjectSetRequest subjectsetRequest) {

        SubjectSetResponse subjectsetResponse = new SubjectSetResponse();
        try {
            subjectsetResponse = subjectsetService.saveSubjectSets(subjectsetRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            subjectsetResponse.setResponseStatus(ServiceStatus.ERROR.value());
            subjectsetResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(subjectsetResponse);
        }

        return ResponseEntity.ok(subjectsetResponse);
    }
}