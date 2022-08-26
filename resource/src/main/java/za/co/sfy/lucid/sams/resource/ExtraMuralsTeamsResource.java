package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
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

    public ExtraMuralsTeamsResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        ExtraMuralsTeams extraMuralsTeams = (ExtraMuralsTeams) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(ExID,TeamName,TeamAfrName,TeamAgeFrom,TeamAgeTo,TeamEdID" +
                ",TeamDepEdID,TeamPicture,TeamOfficialID,RecSelected,RecLocked) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, extraMuralsTeams.getExID());
            preparedStatement.setString(2, extraMuralsTeams.getTeamName());
            preparedStatement.setString(3, extraMuralsTeams.getTeamAfrName());
            preparedStatement.setShort(4, extraMuralsTeams.getTeamAgeFrom());
            preparedStatement.setShort(5, extraMuralsTeams.getTeamAgeTo());
            preparedStatement.setInt(6, extraMuralsTeams.getTeamEdID());
            preparedStatement.setInt(7, extraMuralsTeams.getTeamDepEdID());
            preparedStatement.setBytes(8, extraMuralsTeams.getTeamPicture());
            preparedStatement.setInt(9, extraMuralsTeams.getTeamOfficialID());
            preparedStatement.setBoolean(10, extraMuralsTeams.isRecSelected());
            preparedStatement.setBoolean(11, extraMuralsTeams.isRecLocked());
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
