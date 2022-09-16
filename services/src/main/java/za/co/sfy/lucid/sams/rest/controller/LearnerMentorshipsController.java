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
import za.co.sfy.lucid.sams.rest.service.LearnerMentorshipsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearnerMentorshipsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearnerMentorshipsResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("learner-mentorships")
public class LearnerMentorshipsController {

    private static final Logger logger = LoggerFactory.getLogger(LearnerMentorshipsController.class);
    private LearnerMentorshipsService learnerMentorshipsService;

    @Autowired
    public LearnerMentorshipsController(final LearnerMentorshipsService learnerMentorshipsService){
        this.learnerMentorshipsService = learnerMentorshipsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LearnerMentorshipsResponse> saveLearnerMentorships(@Valid @RequestBody LearnerMentorshipsRequest learnerMentorshipsRequest) {

        LearnerMentorshipsResponse learnerMentorshipsResponse = new LearnerMentorshipsResponse();

        try {
            learnerMentorshipsResponse = learnerMentorshipsService.saveLearnerMentorships(learnerMentorshipsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            learnerMentorshipsResponse.setResponseMessage(exception.getMessage());
            learnerMentorshipsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(learnerMentorshipsResponse);
        }
        return ResponseEntity.ok(learnerMentorshipsResponse);
    }
}
