package za.co.sfy.lucid.sams.rest.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.ParentInfoService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ParentInfoRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ParentInfoResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("parent-info")
public class ParentInfoController {

    private static final Logger logger = LoggerFactory.getLogger(ParentInfoController.class);
    private ParentInfoService parentInfoService;

    @Autowired
    public ParentInfoController(final ParentInfoService parentInfoService) {
        this.parentInfoService = parentInfoService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ParentInfoResponse> saveParentInfo(@Valid @RequestBody ParentInfoRequest parentInfoRequest) {

        ParentInfoResponse parentInfoResponse = new ParentInfoResponse();

        try {
            parentInfoResponse = parentInfoService.saveParentInfo(parentInfoRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            parentInfoResponse.setResponseStatus(ServiceStatus.ERROR.value());
            parentInfoResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity
                    .unprocessableEntity()
                    .body(parentInfoResponse);
        }

        return ResponseEntity.ok(parentInfoResponse);
    }
}
