package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.sams.vo.DetentionNotificationSettingsRequest;
import za.co.sfy.sams.lucid.schema.DetentionNotificationSettings;


@Component
public class DetentionNotificationSettingsMapper {

    public DetentionNotificationSettings detentionNotificationSettingsRequestToDetentionNotificationSettings
            (DetentionNotificationSettingsRequest detentionNotificationSettingsRequest) {

        DetentionNotificationSettings detentionNotificationSettings = new DetentionNotificationSettings();

        Integer id = detentionNotificationSettingsRequest.getId();
        if (id != null) {
            detentionNotificationSettings.setId(id);
        }

        String detentionType = detentionNotificationSettingsRequest.getDetentionType();
        detentionNotificationSettings.setDetentionType(detentionType);

        String startTime = detentionNotificationSettingsRequest.getStartTime();
        detentionNotificationSettings.setStartTime(startTime);

        String endTime = detentionNotificationSettingsRequest.getEndTime();
        detentionNotificationSettings.setEndTime(endTime);

        String detentionDay = detentionNotificationSettingsRequest.getDetentionDay();
        detentionNotificationSettings.setDetentionDay(detentionDay);

        Integer meritPoint = detentionNotificationSettingsRequest.getMeritPoint();
        detentionNotificationSettings.setMeritPoint(meritPoint);

        return detentionNotificationSettings;
    }
}