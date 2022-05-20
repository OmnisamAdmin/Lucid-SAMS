package za.co.sfy.lucid.sams.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 * <p>
 * Allows for different implementations of setting up a prepared statement for saves,updates and retrievals
 */
public interface ILucidSAMSResource {

    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException;

    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object);

    public PreparedStatement retrieveUpdatePreparedStatement(Connection connection, Object object) throws SQLException;

    public String getTABLE_NAME();
}
