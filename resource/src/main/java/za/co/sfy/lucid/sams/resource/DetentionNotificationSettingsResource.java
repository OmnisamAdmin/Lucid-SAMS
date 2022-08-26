package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.DetentionNotificationSettings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class DetentionNotificationSettingsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "DetentionNotificationSettings";

    public DetentionNotificationSettingsResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManagerAbstractDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManagerAbstractDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public PreparedStatement retrieve(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public PreparedStatement update(Connection connection, Object object) throws LucidSamsExecutionException {

        String sql = "UPDATE " + TABLE_NAME + " SET StartTime = ?, EndTime = ?, DetentionDay = ?, MeritPoint = ? " +
                "WHERE DetentionType = ?";

        DetentionNotificationSettings detentionNotificationSettings = (DetentionNotificationSettings) object;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String startTime = detentionNotificationSettings.getStartTime();
            preparedStatement.setString(1, startTime);
            String endTime = detentionNotificationSettings.getEndTime();
            preparedStatement.setString(2, endTime);
            String detentionDay = detentionNotificationSettings.getDetentionDay();
            preparedStatement.setString(3, detentionDay);
            Integer meritPoint = detentionNotificationSettings.getMeritPoint();
            preparedStatement.setInt(4, meritPoint);
            String detentionType = detentionNotificationSettings.getDetentionType();
            preparedStatement.setString(5, detentionType);

            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve update prepared statement ", exception);
        }
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
