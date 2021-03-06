package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class ExtraMuralsTypesResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "ExtraMuralsTypes";

    public ExtraMuralsTypesResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    public ResultSet retrieveExtraMuralsTypesByID(Integer exTypeID) throws LucidSamsExecutionException {

        String sql = "SELECT DISTINCT ExTypeID FROM " + TABLE_NAME + " WHERE ExTypeID = ?";
        Connection connection = getDatabaseConnectionManager().createDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, exTypeID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve extraMuralsTypes by id '" + exTypeID + "': "
                    + exception.getMessage(), exception);
        }
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {
        ExtraMuralsTypes extraMuralsTypes = (ExtraMuralsTypes) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(ExTypeName, ExTypeAfrName, ExTypeShortName, ExTypeShortAfrName," +
                " ExTypePicKey, ExTypePicture, ExTypeOfficialID, RecSelected, RecLocked) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, extraMuralsTypes.getExTypeName());
            preparedStatement.setString(2, extraMuralsTypes.getExTypeAfrName());
            preparedStatement.setString(3, extraMuralsTypes.getExTypeShortName());
            preparedStatement.setString(4, extraMuralsTypes.getExTypeShortAfrName());
            preparedStatement.setString(5, extraMuralsTypes.getExTypePicKey());
            preparedStatement.setBytes(6, extraMuralsTypes.getExTypePicture());
            preparedStatement.setInt(7, extraMuralsTypes.getExTypeOfficialID());
            preparedStatement.setBoolean(8, extraMuralsTypes.isRecSelected());
            preparedStatement.setBoolean(9, extraMuralsTypes.isRecLocked());
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
