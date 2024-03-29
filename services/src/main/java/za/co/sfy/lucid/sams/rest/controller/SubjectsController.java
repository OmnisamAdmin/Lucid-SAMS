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
import za.co.sfy.lucid.sams.rest.service.SubjectsService;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.SubjectsRequest;
import za.co.sfy.sams.vo.SubjectsResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("subjects")
public class SubjectsController {

    private static final Logger logger = LoggerFactory.getLogger(SubjectsController.class);
    private final SubjectsService subjectsService;

    @Autowired
    public SubjectsController(final SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SubjectsResponse> saveParentInfo(@Valid @RequestBody SubjectsRequest subjectsRequest) {

        SubjectsResponse subjectsResponse = new SubjectsResponse();
        try {
            subjectsResponse = subjectsService.updateSubjects(subjectsRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            subjectsResponse.setResponseStatus(ServiceStatus.ERROR.value());
            subjectsResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(subjectsResponse);
        }

        return ResponseEntity.ok(subjectsResponse);
    }
}