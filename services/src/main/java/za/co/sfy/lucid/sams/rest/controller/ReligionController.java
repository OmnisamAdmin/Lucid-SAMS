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
import za.co.sfy.lucid.sams.rest.service.ReligionService;
import za.co.sfy.sams.vo.ReligionRequest;
import za.co.sfy.sams.vo.ReligionResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("religions")
public class ReligionController {

    private ReligionService religionService;
    private static final Logger logger = LoggerFactory.getLogger(ReligionController.class);

    @Autowired
    public ReligionController(final ReligionService religionService) {
        this.religionService = religionService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReligionResponse> saveReligion(@Valid @RequestBody ReligionRequest religionRequest) {

        ReligionResponse religionResponse = new ReligionResponse();
        try {
            religionResponse = religionService.saveReligion(religionRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            religionResponse.setResponseMessage(exception.getMessage());
            religionResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(religionResponse);
        }

        return ResponseEntity.ok(religionResponse);
    }

}