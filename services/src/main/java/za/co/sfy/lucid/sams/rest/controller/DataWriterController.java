package za.co.sfy.lucid.sams.rest.controller;

import javax.validation.Valid;

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
import za.co.sfy.lucid.sams.rest.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.data.writer.DataWriterService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DataWriterRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DataWriterResponse;

@RestController
@RequestMapping("dataWriter")
public class DataWriterController {
    private static final Logger logger = LoggerFactory.getLogger(DataWriterController.class);

    private final DataWriterService dataWriterService;

    @Autowired
    public DataWriterController(final DataWriterService dataWriterService) {
        this.dataWriterService = dataWriterService;
    }

    @PostMapping(
            value = "/write",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DataWriterResponse> authenticate(@Valid @RequestBody DataWriterRequest dataWriterRequest) {
        DataWriterResponse dataWriterResponse = new DataWriterResponse();
        try {
            dataWriterResponse = dataWriterService.writeData(dataWriterRequest);
        } catch (LucidSamsExecutionException executionException) {
            logger.warn("Failure occurred: ", executionException);
            dataWriterResponse.setResponseStatus(ServiceStatus.ERROR.value());
            dataWriterResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity
                    .unprocessableEntity()
                    .body(dataWriterResponse);
        }

        return ResponseEntity.ok(dataWriterResponse);
    }
}
