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
import za.co.sfy.lucid.sams.rest.service.EducatorCalendarTermsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorCalendarTermsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorCalendarTermsResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("educator-calendar-terms")
public class EducatorCalendarTermsController {

    private static final Logger logger = LoggerFactory.getLogger(EducatorCalendarTermsController.class);
    private EducatorCalendarTermsService educatorCalendarTermsService;

    @Autowired
    public EducatorCalendarTermsController(final EducatorCalendarTermsService educatorCalendarTermsService) {
        this.educatorCalendarTermsService = educatorCalendarTermsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EducatorCalendarTermsResponse> saveEducatorCalendarTerms(@Valid @RequestBody EducatorCalendarTermsRequest educatorCalendarTermsRequest) {

        EducatorCalendarTermsResponse educatorCalendarTermsResponse = new EducatorCalendarTermsResponse();

        try {
            educatorCalendarTermsResponse = educatorCalendarTermsService.saveEducatorCalendarTerms(educatorCalendarTermsRequest);


        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            educatorCalendarTermsResponse.setResponseMessage(exception.getMessage());
            educatorCalendarTermsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity
                    .unprocessableEntity()
                    .body(educatorCalendarTermsResponse);
        }

        return ResponseEntity.ok(educatorCalendarTermsResponse);
    }
}
