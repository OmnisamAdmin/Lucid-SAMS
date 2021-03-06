package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompetitions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class ExtraMuralsCompetitionsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "ExtraMuralsCompetitions";

    public ExtraMuralsCompetitionsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    public ResultSet retrieveExtraMuralsCompetitionsByID(Integer compID) throws LucidSamsExecutionException {

        String sql = "SELECT DISTINCT CompID FROM " + TABLE_NAME + " WHERE CompID = ?";
        Connection connection = getDatabaseConnectionManager().createDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, compID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve ExtraMuralsCompetitions of id '" + compID + "' :"
                    + exception.getMessage(), exception);
        }
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {

        ExtraMuralsCompetitions extraMuralsCompetitions = (ExtraMuralsCompetitions) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(ExID,CompName,CompAfrName,CompPicture,CompOfficialID,RecSelected,RecLocked)" +
                " VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, extraMuralsCompetitions.getExID());
            preparedStatement.setString(2, extraMuralsCompetitions.getCompName());
            preparedStatement.setString(3, extraMuralsCompetitions.getCompAfrName());
            preparedStatement.setBytes(4, extraMuralsCompetitions.getCompPicture());
            preparedStatement.setInt(5, extraMuralsCompetitions.getCompOfficialID());
            preparedStatement.setBoolean(6, extraMuralsCompetitions.isRecSelected());
            preparedStatement.setBoolean(7, extraMuralsCompetitions.isRecLocked());
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
