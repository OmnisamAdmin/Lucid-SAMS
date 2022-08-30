package za.co.sfy.lucid.sams.resource.connection;

import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author muzim
 * Provides generic functionality to connection manager instances e.g. {@link EdusolStrucDatabaseConnectionManager}
 */
public abstract class AbstractDatabaseConnectionManager {

    public abstract String getDatabaseName();

    public abstract Connection retrieveDatabaseConnection() throws LucidSamsExecutionException;

    public Connection createDatabaseConnection(String databaseUrl, String databaseUsername, String databasePassword) throws LucidSamsExecutionException {
        try {
            Connection databaseConnection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            if (null == databaseConnection) {
                throw new LucidSamsExecutionException("Database Connection Creation for database '" + getDatabaseName()
                        + "' failed. Database connection cannot be null.");
            }
            return databaseConnection;
        } catch (SQLException e) {
            throw new LucidSamsExecutionException("Unable to establish a connection to the database '"
                    + getDatabaseName() + "' .", e);
        }
    }

    public void closeDatabaseConnection(Connection connection) throws LucidSamsExecutionException {

        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new LucidSamsExecutionException("Unable to close database connection.");
            }
        }
    }
}
