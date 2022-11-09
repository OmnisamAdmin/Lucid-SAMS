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
import za.co.sfy.lucid.sams.rest.service.EducatorsService;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.EducatorsRequest;
import za.co.sfy.sams.vo.EducatorsResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("educators")
public class EducatorsController {

    private EducatorsService educatorsService;
    private static final Logger logger = LoggerFactory.getLogger(EducatorsController.class);

    @Autowired
    public EducatorsController(final EducatorsService educatorsService) {
        this.educatorsService = educatorsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducatorsResponse> save(@Valid @RequestBody EducatorsRequest educatorsRequest) {
        EducatorsResponse educatorsResponse = new EducatorsResponse();
        try {
            educatorsResponse = educatorsService.saveEducators(educatorsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            educatorsResponse.setResponseMessage(exception.getMessage());
            educatorsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(educatorsResponse);
        }

        return ResponseEntity.ok(educatorsResponse);
    }
}