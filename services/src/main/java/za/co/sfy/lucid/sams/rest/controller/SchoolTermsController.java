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
import za.co.sfy.lucid.sams.rest.service.SchoolTermsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SchoolTermsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SchoolTermsResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("school-terms")
public class SchoolTermsController {

    private static final Logger logger = LoggerFactory.getLogger(SchoolTermsController.class);
    private SchoolTermsService schoolTermsService;

    @Autowired
    public SchoolTermsController(final SchoolTermsService schoolTermsService) {
        this.schoolTermsService = schoolTermsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTermsResponse> saveSchoolTerms(@Valid @RequestBody SchoolTermsRequest schoolTermsRequest) {

        SchoolTermsResponse schoolTermsResponse = new SchoolTermsResponse();

        try {
            schoolTermsResponse = schoolTermsService.saveSchoolTerms(schoolTermsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            schoolTermsResponse.setResponseStatus(ServiceStatus.ERROR.value());
            schoolTermsResponse.setResponseMessage(exception.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(schoolTermsResponse);
        }

        return ResponseEntity.ok(schoolTermsResponse);
    }

}
