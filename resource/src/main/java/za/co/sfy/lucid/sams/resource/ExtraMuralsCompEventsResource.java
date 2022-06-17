package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateConverter;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompEvents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class ExtraMuralsCompEventsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final DateConverter dateConverter = new DateConverter();
    private final String TABLE_NAME = "ExtraMuralsCompetitionEvents";

    public ExtraMuralsCompEventsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {

        ExtraMuralsCompEvents extraMuralsCompEvents = (ExtraMuralsCompEvents) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(CompID,EventDate,EventTimeStart,EventTimeEnd,EventDesc,EventAfrDesc) " +
                "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, extraMuralsCompEvents.getCompID());
            preparedStatement.setDate(2, dateConverter.getSQLDate(extraMuralsCompEvents.getEventDate()));
            preparedStatement.setString(3, extraMuralsCompEvents.getEventTimeStart());
            preparedStatement.setString(4, extraMuralsCompEvents.getEventTimeEnd());
            preparedStatement.setString(5, extraMuralsCompEvents.getEventDesc());
            preparedStatement.setString(6, extraMuralsCompEvents.getEventAfrDesc());
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve save prepared statement: "
                    + exception.getMessage(), exception);
        }
    }

    @Override
    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public PreparedStatement retrieveUpdatePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
