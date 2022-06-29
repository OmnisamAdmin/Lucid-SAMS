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
import za.co.sfy.lucid.sams.rest.service.StaffCalendarTermsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.StaffCalendarTermsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.StaffCalendarTermsResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("staff-calendar-terms")
public class StaffCalendarTermsController {

    private static final Logger logger = LoggerFactory.getLogger(StaffCalendarTermsController.class);
    private StaffCalendarTermsService staffCalendarTermsService;

    @Autowired
    public StaffCalendarTermsController(final StaffCalendarTermsService staffCalendarTermsService) {
        this.staffCalendarTermsService = staffCalendarTermsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StaffCalendarTermsResponse> saveStaffCalendarTerms(@Valid @RequestBody StaffCalendarTermsRequest staffCalendarTermsRequest) {

        StaffCalendarTermsResponse staffCalendarTermsResponse = new StaffCalendarTermsResponse();

        try {
            staffCalendarTermsResponse = staffCalendarTermsService.saveStaffCalendarTerms(staffCalendarTermsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            staffCalendarTermsResponse.setResponseMessage(exception.getMessage());
            staffCalendarTermsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(staffCalendarTermsResponse);
        }

        return ResponseEntity.ok(staffCalendarTermsResponse);
    }
}
