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
import za.co.sfy.lucid.sams.rest.service.DisciplinaryRecordsService;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.DisciplinaryRecordsRequest;
import za.co.sfy.sams.vo.DisciplinaryRecordsResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("disciplinary-records")
public class DisciplinaryRecordsController {

    private DisciplinaryRecordsService disciplinaryRecordsService;
    private static final Logger logger = LoggerFactory.getLogger(DisciplinaryRecordsController.class);

    @Autowired
    public DisciplinaryRecordsController (final DisciplinaryRecordsService disciplinaryRecordsService){
        this.disciplinaryRecordsService = disciplinaryRecordsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DisciplinaryRecordsResponse> save(@Valid @RequestBody DisciplinaryRecordsRequest disciplinaryRecordsRequest) {

        DisciplinaryRecordsResponse disciplinaryRecordsResponse = new DisciplinaryRecordsResponse();

        try {
            disciplinaryRecordsResponse = disciplinaryRecordsService.saveDisciplinaryRecords(disciplinaryRecordsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            disciplinaryRecordsResponse.setResponseMessage(exception.getMessage());
            disciplinaryRecordsResponse.setResponseStatus(ServiceStatus.ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(disciplinaryRecordsResponse);
        }

        return ResponseEntity.ok().body(disciplinaryRecordsResponse);
    }
}