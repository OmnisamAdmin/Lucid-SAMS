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
import za.co.sfy.lucid.sams.rest.service.EducatorsGroupService;
import za.co.sfy.sams.vo.EducatorsGroupRequest;
import za.co.sfy.sams.vo.EducatorsGroupResponse;

import javax.validation.Valid;


/**
 * @author muzim
 */
@RestController
@RequestMapping("educator-groups")
public class EducatorsGroupController {

    private static final Logger logger = LoggerFactory.getLogger(EducatorsGroupController.class);
    private EducatorsGroupService educatorsGroupService;

    @Autowired
    public EducatorsGroupController(final EducatorsGroupService educatorsgroupService) {
        this.educatorsGroupService = educatorsgroupService;
    }

    @PostMapping(
            path = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EducatorsGroupResponse> updateEducatorGroups(@Valid @RequestBody EducatorsGroupRequest educatorsgroupRequest) {

        EducatorsGroupResponse educatorsgroupResponse = new EducatorsGroupResponse();
        try {
            educatorsgroupResponse = educatorsGroupService.updateEducatorGroups(educatorsgroupRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            educatorsgroupResponse.setResponseStatus(ServiceStatus.ERROR.value());
            educatorsgroupResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(educatorsgroupResponse);
        }

        return ResponseEntity.ok(educatorsgroupResponse);
    }

    @PostMapping(
            path = "save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EducatorsGroupResponse> saveEducatorGroups(@Valid @RequestBody EducatorsGroupRequest educatorsgroupRequest) {

        EducatorsGroupResponse educatorsgroupResponse = new EducatorsGroupResponse();
        try {
            educatorsgroupResponse = educatorsGroupService.saveEducatorGroups(educatorsgroupRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            educatorsgroupResponse.setResponseStatus(ServiceStatus.ERROR.value());
            educatorsgroupResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(educatorsgroupResponse);
        }

        return ResponseEntity.ok(educatorsgroupResponse);
    }
}