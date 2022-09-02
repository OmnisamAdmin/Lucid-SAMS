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
import za.co.sfy.lucid.sams.rest.service.TopicsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.TopicsRequests;
import za.co.sfy.lucid.sams.rest.vo.data.writer.TopicsResponse;

/**
 * @author muzim
 */
@RestController
@RequestMapping("Topics")
public class TopicsController {

    private static final Logger logger = LoggerFactory.getLogger(SubjectsController.class);
    private final TopicsService TopicsService;

    @Autowired
    public TopicsController(final TopicsService TopicsService) {
        this.TopicsService = TopicsService;
    }

    @PostMapping(
            path = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TopicsResponse> updateTopics(@Valid @RequestBody TopicsRequests topicsRequests) {

        TopicsResponse subjectsResponse = new TopicsResponse();
        try {
            TopicsResponse topicsResponse = TopicsService.updateTopics(topicsRequests);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            subjectsResponse.setResponseStatus(ServiceStatus.ERROR.value());
            subjectsResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(subjectsResponse);
        }

        return ResponseEntity.ok(subjectsResponse);
    }

    /**
     *
     * @param TopicsRequest
     * @return
     */
    @PostMapping(
            path = "save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TopicsResponse> saveTopics(@Valid @RequestBody TopicsRequests TopicsRequest) {

        TopicsResponse TopicsResponse = new TopicsResponse();
        try {
            TopicsResponse = TopicsService.saveTopics(TopicsRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            TopicsResponse.setResponseStatus(ServiceStatus.ERROR.value());
            TopicsResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(TopicsResponse);
        }

        return ResponseEntity.ok(TopicsResponse);
    }
}
