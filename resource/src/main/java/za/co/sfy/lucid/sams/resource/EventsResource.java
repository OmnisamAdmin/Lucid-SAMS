package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateConverter;
import za.co.sfy.sams.lucid.schema.Events;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class EventsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Events";
    private final DateConverter dateConverter = new DateConverter();

    public EventsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException {

        Events events = (Events) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Date,StartTime,EndTime,Description,Compulsory,Category,ExEventID) " +
                "VALUES(?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, dateConverter.getSQLDate(events.getDate()));
        preparedStatement.setString(2, events.getStartTime());
        preparedStatement.setString(3, events.getEndTime());
        preparedStatement.setString(4, events.getDescription());
        preparedStatement.setString(5, events.getCompulsory());
        preparedStatement.setString(6, events.getCategory());
        preparedStatement.setInt(7, events.getExEventID());

        return preparedStatement;
    }

    @Override
    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object) {
        return null;
    }

    @Override
    public PreparedStatement retrieveUpdatePreparedStatement(Connection connection, Object object) throws SQLException {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
