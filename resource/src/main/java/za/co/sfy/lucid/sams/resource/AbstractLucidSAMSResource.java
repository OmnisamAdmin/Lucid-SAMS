package za.co.sfy.lucid.sams.resource;

import org.springframework.beans.factory.annotation.Autowired;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */

public abstract class AbstractLucidSAMSResource {

    private final DatabaseConnectionManager databaseConnectionManager;

    @Autowired
    public AbstractLucidSAMSResource(final DatabaseConnectionManager databaseConnectionManager) {
        this.databaseConnectionManager = databaseConnectionManager;
    }

    /**
     * Saves Lucid-SAMS POJOs that return a generated id e.g. {@link za.co.sfy.sams.lucid.schema.GeneralInfo}
     * @param object
     * @param iLucidSamsResource
     * @return
     * @throws LucidSamsExecutionException
     */
    public Long save(Object object, ILucidSAMSResource iLucidSamsResource) throws LucidSamsExecutionException {

        Connection databaseConnection = databaseConnectionManager.createDatabaseConnection();
        String tableName = iLucidSamsResource.getTABLE_NAME();
        try {
            PreparedStatement preparedStatement = iLucidSamsResource.retrievePreparedStatement(databaseConnection, object);
            int result = preparedStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("'" + tableName + "' insertion failed, no rows were affected");
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new SQLException("'" + tableName + "' insertion failed, no ID obtained.");
            }
            return generatedKeys.getLong(1);
        } catch (SQLException e) {
            throw new LucidSamsExecutionException("Unable to save to the '" + tableName + "' table. " + e.getMessage(), e);
        } finally {
            databaseConnectionManager.closeDatabaseConnection(databaseConnection);
        }
    }

    /**
     * Saves Lucid-SAMS POJOs that don't return a generated id e.g. {@link za.co.sfy.sams.lucid.schema.CycleInfo}
     * @param object
     * @param iLucidSamsResource
     * @throws LucidSamsExecutionException
     */
    public void saveObjectWithoutGeneratedKey(Object object, ILucidSAMSResource iLucidSamsResource) throws LucidSamsExecutionException {

        Connection databaseConnection = databaseConnectionManager.createDatabaseConnection();
        String tableName = iLucidSamsResource.getTABLE_NAME();
        try {
            PreparedStatement preparedStatement = iLucidSamsResource.retrievePreparedStatement(databaseConnection, object);
            int result = preparedStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("'" + tableName + "' insertion failed, no rows were affected");
            }
        } catch (SQLException e) {
            throw new LucidSamsExecutionException("Unable to save to the '" + tableName + "' table. " + e.getMessage(), e);
        } finally {
            databaseConnectionManager.closeDatabaseConnection(databaseConnection);
        }
    }

}
