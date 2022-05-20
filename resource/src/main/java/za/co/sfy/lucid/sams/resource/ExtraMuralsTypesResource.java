package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException {
        ExtraMuralsTypes extraMuralsTypes = (ExtraMuralsTypes) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(ExTypeName, ExTypeAfrName, ExTypeShortName, ExTypeShortAfrName," +
                " ExTypePicKey, ExTypePicture, ExTypeOfficialID, RecSelected, RecLocked) VALUES(?,?,?,?,?,?,?,?,?)";

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
