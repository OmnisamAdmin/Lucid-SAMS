package za.co.sfy.lucid.sams.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 *
 * Allows for different implementations of setting up a prepared statement
 */
public interface ILucidSAMSResource {

    public PreparedStatement retrievePreparedStatement(Connection connection, Object object) throws SQLException;

    public String getTABLE_NAME();
}
