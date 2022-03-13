package za.co.sfy.lucid.sams.resource.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnectionManager {

    @Value("${datasource.url}")
    private String databaseUrl;

    @Value("${datasource.username}")
    private String databaseUsername;

    @Value("${datasource.password}")
    private String databasePassword;

    public Connection createDatabaseConnection() throws LucidSamsExecutionException {

        Connection databaseConnection = null;
        try {
             databaseConnection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
             if (null == databaseConnection) {
                 throw new LucidSamsExecutionException("Database Connection Creation failed. Database connection cannot be null.");
             }
        } catch (SQLException e) {
            throw new LucidSamsExecutionException("Unable to establish a connection to the database.", e);
        }
        return databaseConnection;
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