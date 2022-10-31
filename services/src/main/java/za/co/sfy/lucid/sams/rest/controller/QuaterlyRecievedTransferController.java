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
import za.co.sfy.lucid.sams.rest.service.QuaterlyRecievedTransferService;
import za.co.sfy.sams.vo.QuaterlyRecievedTransferRequest;
import za.co.sfy.sams.vo.QuaterlyRecievedTransferResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("quaterly-recieved-transfer")
public class QuaterlyRecievedTransferController {

    private static final Logger logger = LoggerFactory.getLogger(QuaterlyRecievedTransferController.class);
    private QuaterlyRecievedTransferService quaterlyRecievedTransferService;

    @Autowired
    public QuaterlyRecievedTransferController(final QuaterlyRecievedTransferService quaterlyRecievedTransferService) {
        this.quaterlyRecievedTransferService = quaterlyRecievedTransferService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "save"
    )
    public ResponseEntity<QuaterlyRecievedTransferResponse> saveQuaterlyRecievedTransfer(
            @Valid @RequestBody QuaterlyRecievedTransferRequest quaterlyRecievedTransferRequest) {

        QuaterlyRecievedTransferResponse quaterlyRecievedTransferResponse = new QuaterlyRecievedTransferResponse();
        try {
            quaterlyRecievedTransferResponse = quaterlyRecievedTransferService.saveQuaterlyRecievedTransfer(quaterlyRecievedTransferRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occured: " + exception.getMessage(), exception);
            quaterlyRecievedTransferResponse.setResponseMessage(exception.getMessage());
            quaterlyRecievedTransferResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(quaterlyRecievedTransferResponse);
        }

        return ResponseEntity.ok(quaterlyRecievedTransferResponse);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "update"
    )
    public ResponseEntity<QuaterlyRecievedTransferResponse> updateQuaterlyRecievedTransfer(
            @Valid @RequestBody QuaterlyRecievedTransferRequest quaterlyRecievedTransferRequest) {

        QuaterlyRecievedTransferResponse quaterlyRecievedTransferResponse = new QuaterlyRecievedTransferResponse();
        try {
            quaterlyRecievedTransferResponse = quaterlyRecievedTransferService.updateQuaterlyRecievedTransfer(quaterlyRecievedTransferRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occured: " + exception.getMessage(), exception);
            quaterlyRecievedTransferResponse.setResponseMessage(exception.getMessage());
            quaterlyRecievedTransferResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(quaterlyRecievedTransferResponse);
        }

        return ResponseEntity.ok(quaterlyRecievedTransferResponse);
    }
}