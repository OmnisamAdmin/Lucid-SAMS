package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.DetentionNotificationSettingsResource;
import za.co.sfy.lucid.sams.rest.mapper.DetentionNotificationSettingsMapper;
import za.co.sfy.sams.vo.DetentionNotificationSettingsRequest;
import za.co.sfy.sams.vo.DetentionNotificationSettingsResponse;
import za.co.sfy.sams.lucid.schema.DetentionNotificationSettings;

@Service
public class DetentionNotificationSettingsService {

    private final DetentionNotificationSettingsMapper detentionNotificationSettingsMapper;
    private final DetentionNotificationSettingsResource detentionNotificationSettingsResource;

    @Autowired
    public DetentionNotificationSettingsService(final DetentionNotificationSettingsMapper detentionNotificationSettingsMapper
            , final DetentionNotificationSettingsResource detentionNotificationSettingsResource) {
        this.detentionNotificationSettingsMapper = detentionNotificationSettingsMapper;
        this.detentionNotificationSettingsResource = detentionNotificationSettingsResource;
    }

    public DetentionNotificationSettingsResponse saveDetentionNotificationSettings(DetentionNotificationSettingsRequest
                                                                                           detentionNotificationSettingsRequest) throws LucidSamsExecutionException {
        DetentionNotificationSettings detentionNotificationSettings = detentionNotificationSettingsMapper
                .detentionNotificationSettingsRequestToDetentionNotificationSettings(detentionNotificationSettingsRequest);

        detentionNotificationSettingsResource.update(detentionNotificationSettings, detentionNotificationSettingsResource);

        DetentionNotificationSettingsResponse detentionNotificationSettingsResponse = new DetentionNotificationSettingsResponse();
        detentionNotificationSettingsResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        detentionNotificationSettingsResponse.setResponseStatus("Successfully updated 'DetentionNotificationSettings' table");
        detentionNotificationSettingsResponse.setDetentionNotificationSettings(detentionNotificationSettings);

        return detentionNotificationSettingsResponse;
    }

}