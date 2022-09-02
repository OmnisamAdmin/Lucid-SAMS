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
import za.co.sfy.lucid.sams.rest.service.DeliveryReceivedService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DeliveryReceivedRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DeliveryReceivedResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("delivery-receiveds")
public class DeliveryReceivedController {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryReceivedController.class);
    private DeliveryReceivedService deliveryReceivedService;

    @Autowired
    public DeliveryReceivedController(final DeliveryReceivedService deliveryReceivedService) {
        this.deliveryReceivedService = deliveryReceivedService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DeliveryReceivedResponse> saveDeliveryReceived(@Valid @RequestBody DeliveryReceivedRequest deliveryReceivedRequest) {

        DeliveryReceivedResponse deliveryReceivedResponse = new DeliveryReceivedResponse();

        try {
            deliveryReceivedResponse = deliveryReceivedService.saveDeliveryReceived(deliveryReceivedRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            deliveryReceivedResponse.setResponseMessage(exception.getMessage());
            deliveryReceivedResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(deliveryReceivedResponse);
        }
        return ResponseEntity.ok(deliveryReceivedResponse);
    }
}
