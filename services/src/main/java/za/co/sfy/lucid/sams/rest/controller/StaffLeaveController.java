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
import za.co.sfy.lucid.sams.rest.service.StaffLeaveService;
import za.co.sfy.sams.vo.StaffLeaveRequest;
import za.co.sfy.sams.vo.StaffLeaveResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("staff-leave")
public class StaffLeaveController {

    private static final Logger logger = LoggerFactory.getLogger(StaffLeaveController.class);
    private StaffLeaveService staffLeaveService;

    public StaffLeaveController(final StaffLeaveService staffLeaveService) {
        this.staffLeaveService = staffLeaveService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StaffLeaveResponse> saveStaffLearner(@Valid @RequestBody StaffLeaveRequest staffLeaveRequest) {

        StaffLeaveResponse staffLeaveResponse = new StaffLeaveResponse();
        try {
            staffLeaveResponse = staffLeaveService.saveStaffLeaveService(staffLeaveRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            staffLeaveResponse.setResponseStatus(ServiceStatus.ERROR.value());
            staffLeaveResponse.setResponseMessage(exception.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(staffLeaveResponse);
        }
        return ResponseEntity.ok(staffLeaveResponse);
    }

}