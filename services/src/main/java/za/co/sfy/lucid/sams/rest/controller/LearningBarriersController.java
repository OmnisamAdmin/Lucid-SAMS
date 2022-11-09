package za.co.sfy.lucid.sams.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.LearningBarriersService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearningBarriersRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearningBarriersResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("learning-barriers")
public class LearningBarriersController {
    private static final Logger logger = LoggerFactory.getLogger(LearningBarriersController.class);
    private LearningBarriersService learningBarriersService;

    public LearningBarriersController(final LearningBarriersService learningBarriersService) {
        this.learningBarriersService = learningBarriersService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LearningBarriersResponse> save(@Valid @RequestBody LearningBarriersRequest learningBarriersRequest) {
        LearningBarriersResponse learningBarriersResponse = new LearningBarriersResponse();
        try {
            learningBarriersResponse = learningBarriersService.saveLearningBarriers(learningBarriersRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            learningBarriersResponse.setResponseMessage(exception.getMessage());
            learningBarriersResponse.setResponseStatus(ServiceStatus.ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(learningBarriersResponse);
        }
        return ResponseEntity.ok().body(learningBarriersResponse);
    }
}
