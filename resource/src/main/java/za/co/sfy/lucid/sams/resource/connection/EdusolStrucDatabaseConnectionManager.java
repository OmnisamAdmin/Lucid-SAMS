package za.co.sfy.lucid.sams.resource.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;

import java.sql.Connection;

/**
 * @author muzim
 * Provides a connection to the 'EdusolStruc' database
 */
@Component
public class EdusolStrucDatabaseConnectionManager extends AbstractDatabaseConnectionManager {

    private static final String databaseName = "EdusolStruc";

    @Value("${datasource.edusolstruc.url}")
    private String databaseUrl;

    @Value("${datasource.edusolstruc.username}")
    private String databaseUsername;

    @Value("${datasource.edusolstruc.password}")
    private String databasePassword;

    private Connection createEdusolStrucDatabaseConnection() throws LucidSamsExecutionException {
        Connection databaseConnection = createDatabaseConnection(databaseUrl, databaseUsername, databasePassword);
        return databaseConnection;
    }

    @Override
    public String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Connection getDatabaseConnection() throws LucidSamsExecutionException {
        return createEdusolStrucDatabaseConnection();
    }
}
