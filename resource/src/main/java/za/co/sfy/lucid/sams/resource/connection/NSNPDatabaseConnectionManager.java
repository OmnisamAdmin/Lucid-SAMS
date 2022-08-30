package za.co.sfy.lucid.sams.resource.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;

import java.sql.Connection;

/**
 * @author muzim
 * Provides a connection to the 'NSNP' database
 */
@Component
public class NSNPDatabaseConnectionManager extends AbstractDatabaseConnectionManager{
    private static final String databaseName = "NSNP";

    @Value("${datasource.nsnp.url}")
    private String databaseUrl;

    @Value("${datasource.nsnp.username}")
    private String databaseUsername;

    @Value("${datasource.nsnp.password}")
    private String databasePassword;

    private Connection createNSNPDatabaseConnection() throws LucidSamsExecutionException {
        Connection databaseConnection = createDatabaseConnection(databaseUrl, databaseUsername, databasePassword);
        return databaseConnection;
    }

    @Override
    public String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Connection retrieveDatabaseConnection() throws LucidSamsExecutionException {
        return createNSNPDatabaseConnection();
    }
}
