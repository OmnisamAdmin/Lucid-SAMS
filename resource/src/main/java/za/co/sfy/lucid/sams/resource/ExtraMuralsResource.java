package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.ExtraMurals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class ExtraMuralsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "ExtraMurals";

    public ExtraMuralsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException {

        ExtraMurals extraMurals = (ExtraMurals) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(ExTypeID, ExName, ExAfrName, ExPicKey, ExPicture, ExOfficialID," +
                " RecSelected, RecLocked) VALUES(?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, extraMurals.getExTypeID());
        preparedStatement.setString(2, extraMurals.getExName());
        preparedStatement.setString(3, extraMurals.getExAfrName());
        preparedStatement.setString(4, extraMurals.getExPicKey());
        preparedStatement.setBytes(5, extraMurals.getExPicture());
        preparedStatement.setInt(6, extraMurals.getExOfficialID());
        preparedStatement.setBoolean(7, extraMurals.isRecSelected());
        preparedStatement.setBoolean(8, extraMurals.isRecLocked());

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
