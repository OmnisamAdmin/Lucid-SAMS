package za.co.sfy.lucid.sams.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.LearnerMentorsService;
import za.co.sfy.sams.vo.LearnerMentorsRequest;
import za.co.sfy.sams.vo.LearnerMentorsResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("learner-mentors")
public class LearnerMentorsController {

    private static final Logger logger = LoggerFactory.getLogger(LearnerMentorsController.class);
    private LearnerMentorsService learnerMentorsService;

    @Autowired
    public LearnerMentorsController(final LearnerMentorsService learnerMentorsService) {
        this.learnerMentorsService = learnerMentorsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{identifier}"
            /* The header field 'identifier' may be a persal number (Educator or Staff) or learnerID (Learner)
            and this discrimination is made via the typeID field in the {@link LearnerMentorsRequest} request
            */
    )
    public ResponseEntity<LearnerMentorsResponse> saveLearnerMentors(@Valid @RequestBody LearnerMentorsRequest learnerMentorsRequest
            , @PathVariable String identifier) {

        LearnerMentorsResponse learnerMentorsResponse = new LearnerMentorsResponse();

        try {
            learnerMentorsResponse = learnerMentorsService.saveLearnerMentors(identifier, learnerMentorsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            learnerMentorsResponse.setResponseMessage(exception.getMessage());
            learnerMentorsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(learnerMentorsResponse);
        }
        return ResponseEntity.ok(learnerMentorsResponse);
    }

}