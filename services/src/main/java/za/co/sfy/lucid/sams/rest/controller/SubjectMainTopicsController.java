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
import za.co.sfy.lucid.sams.rest.service.SubjectMainTopicsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectMainTopicsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectMainTopicsResponse;

/**
 * @author muzim
 */
@RestController
@RequestMapping("subject-main-topics")
public class SubjectMainTopicsController {

    private static final Logger logger = LoggerFactory.getLogger(SubjectsController.class);
    private SubjectMainTopicsService subjectMainTopicsService;

    @Autowired
    public SubjectMainTopicsController(final SubjectMainTopicsService SubjectMainTopicsService) {
        this.subjectMainTopicsService = SubjectMainTopicsService;
    }

    @PostMapping(
            path = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SubjectMainTopicsResponse> updateTopics(@Valid @RequestBody SubjectMainTopicsRequest subjectMainTopicsRequest) {

        SubjectMainTopicsResponse subjectsResponse = new SubjectMainTopicsResponse();
        try {
            subjectsResponse = subjectMainTopicsService.updateTopics(subjectMainTopicsRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            subjectsResponse.setResponseStatus(ServiceStatus.ERROR.value());
            subjectsResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(subjectsResponse);
        }

        return ResponseEntity.ok(subjectsResponse);
    }

    @PostMapping(
            path = "save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SubjectMainTopicsResponse> saveTopics(@Valid @RequestBody SubjectMainTopicsRequest subjectMainTopicsRequest) {

        SubjectMainTopicsResponse subjectMainTopicsResponse = new SubjectMainTopicsResponse();
        try {
            subjectMainTopicsResponse = subjectMainTopicsService.saveTopics(subjectMainTopicsRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            subjectMainTopicsResponse.setResponseStatus(ServiceStatus.ERROR.value());
            subjectMainTopicsResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(subjectMainTopicsResponse);
        }

        return ResponseEntity.ok(subjectMainTopicsResponse);
    }
}