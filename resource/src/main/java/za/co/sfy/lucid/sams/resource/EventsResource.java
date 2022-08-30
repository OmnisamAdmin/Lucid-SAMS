package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateUtil;
import za.co.sfy.sams.lucid.schema.Events;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author muzim
 */
@Component
public class EventsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Events";
    private final DateUtil dateUtil = new DateUtil();

    public EventsResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        Events events = (Events) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Date,StartTime,EndTime,Description,Compulsory,Category,ExEventID) " +
                "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, dateUtil.getSQLDate(events.getDate()));
            preparedStatement.setString(2, events.getStartTime());
            preparedStatement.setString(3, events.getEndTime());
            preparedStatement.setString(4, events.getDescription());
            preparedStatement.setString(5, events.getCompulsory());
            preparedStatement.setString(6, events.getCategory());
            Integer exEventID = events.getExEventID();
            if (null != exEventID) {
                preparedStatement.setInt(7, events.getExEventID());
            } else {
                preparedStatement.setNull(7, Types.INTEGER);
            }
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve save prepared statement ", exception);
        }
    }

    @Override
    public PreparedStatement retrieve(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public PreparedStatement update(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
