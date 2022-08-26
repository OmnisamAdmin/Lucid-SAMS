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
import za.co.sfy.lucid.sams.rest.service.DetentionNotificationSettingsService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DetentionNotificationSettingsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DetentionNotificationSettingsResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("detention-notification-settings")
public class DetentionNotificationSettingsController {

    private DetentionNotificationSettingsService detentionNotificationSettingsService;
    private static final Logger logger = LoggerFactory.getLogger(DetentionNotificationSettingsController.class);

    @Autowired
    public DetentionNotificationSettingsController(final DetentionNotificationSettingsService detentionNotificationSettingsService) {
        this.detentionNotificationSettingsService = detentionNotificationSettingsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetentionNotificationSettingsResponse> update(@Valid @RequestBody DetentionNotificationSettingsRequest detentionNotificationSettingsRequest) {

        DetentionNotificationSettingsResponse detentionNotificationSettingsResponse = new DetentionNotificationSettingsResponse();
        try {
            detentionNotificationSettingsResponse = detentionNotificationSettingsService.saveDetentionNotificationSettings(detentionNotificationSettingsRequest);
        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            detentionNotificationSettingsResponse.setResponseStatus(ServiceStatus.ERROR.value());
            detentionNotificationSettingsResponse.setResponseMessage(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(detentionNotificationSettingsResponse);
        }
        return ResponseEntity.ok().body(detentionNotificationSettingsResponse);
    }
}
