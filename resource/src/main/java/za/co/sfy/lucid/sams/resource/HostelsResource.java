package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.Hostels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class HostelsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Hostels";

    public HostelsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException {

        Hostels hostels = (Hostels) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Name,ContactPerson,address,Tel) VALUES(?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, hostels.getName());
        preparedStatement.setString(2, hostels.getContactPerson());
        preparedStatement.setString(3, hostels.getAddress());
        preparedStatement.setString(4, hostels.getTel());

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
