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
import za.co.sfy.lucid.sams.rest.service.CycleInfoService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.CycleInfoRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.CycleInfoResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("cycle-infos")
public class CycleInfoController {

    private static final Logger logger = LoggerFactory.getLogger(CycleInfoController.class);
    private CycleInfoService cycleInfoService;

    @Autowired
    public CycleInfoController(final CycleInfoService cycleInfoService) {
        this.cycleInfoService = cycleInfoService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CycleInfoResponse> saveCycleInfo(@Valid @RequestBody CycleInfoRequest cycleInfoRequest) {

        CycleInfoResponse cycleInfoResponse = new CycleInfoResponse();

        try {
            cycleInfoResponse = cycleInfoService.saveCycleInfo(cycleInfoRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            cycleInfoResponse.setResponseStatus(ServiceStatus.ERROR.value());
            cycleInfoResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cycleInfoResponse);
        }

        return ResponseEntity.ok(cycleInfoResponse);
    }


}
