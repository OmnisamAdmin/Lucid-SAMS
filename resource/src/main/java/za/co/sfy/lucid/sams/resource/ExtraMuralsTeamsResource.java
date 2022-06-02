package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTeams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class ExtraMuralsTeamsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "ExtraMuralsTeams";

    public ExtraMuralsTeamsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException {

        ExtraMuralsTeams extraMuralsTeams = (ExtraMuralsTeams) object;

        String sql = "ExID,TeamName,TeamAfrName,TeamAgeFrom,TeamAgeTo,TeamEdID,TeamDepEdID,TeamPicture,TeamOfficialID,RecSelected,RecLocked";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,extraMuralsTeams.getExID());
        preparedStatement.setString(2,extraMuralsTeams.getTeamName());
        preparedStatement.setString(3,extraMuralsTeams.getTeamAfrName());
        preparedStatement.setShort(4,extraMuralsTeams.getTeamAgeFrom());
        preparedStatement.setShort(5,extraMuralsTeams.getTeamAgeTo());
        preparedStatement.setInt(6,extraMuralsTeams.getTeamEdID());
        preparedStatement.setInt(7,extraMuralsTeams.getTeamDepEdID());
        preparedStatement.setBytes(8,extraMuralsTeams.getTeamPicture());
        preparedStatement.setInt(9,extraMuralsTeams.getTeamOfficialID());
        preparedStatement.setBoolean(10,extraMuralsTeams.isRecSelected());
        preparedStatement.setBoolean(11,extraMuralsTeams.isRecLocked());

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
