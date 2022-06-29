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
     *
     * @param object
     * @param iLucidSamsResource
     * @return {@link Long}
     * @throws LucidSamsExecutionException
     */
    public Long save(Object object, ILucidSAMSResource iLucidSamsResource) throws LucidSamsExecutionException {

        Connection databaseConnection = databaseConnectionManager.createDatabaseConnection();
        String tableName = iLucidSamsResource.getTABLE_NAME();
        try {
            PreparedStatement preparedStatement = iLucidSamsResource.save(databaseConnection, object);
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
            throw new LucidSamsExecutionException("Unable to save to the '" + tableName + "' table. ", e);
        } finally {
            databaseConnectionManager.closeDatabaseConnection(databaseConnection);
        }
    }

    /**
     * Saves Lucid-SAMS POJOs that don't return a generated id e.g. {@link za.co.sfy.sams.lucid.schema.CycleInfo}
     *
     * @param object
     * @param iLucidSamsResource
     * @throws LucidSamsExecutionException
     */
    public void saveObjectWithoutGeneratedKey(Object object, ILucidSAMSResource iLucidSamsResource) throws LucidSamsExecutionException {

        Connection databaseConnection = databaseConnectionManager.createDatabaseConnection();
        String tableName = iLucidSamsResource.getTABLE_NAME();
        try {
            PreparedStatement preparedStatement = iLucidSamsResource.save(databaseConnection, object);
            int result = preparedStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("'" + tableName + "' insertion failed, no rows were affected");
            }
        } catch (SQLException e) {
            throw new LucidSamsExecutionException("Unable to save to the '" + tableName + "' table. ", e);
        } finally {
            databaseConnectionManager.closeDatabaseConnection(databaseConnection);
        }
    }

    /**
     * Updates Lucid-SAMS POJOs that returns a generated id e.g. {@link za.co.sfy.sams.lucid.schema.Subjects}
     *
     * @param object
     * @param iLucidSamsResource
     * @return {@link Integer} id of updated object
     * @throws LucidSamsExecutionException
     */
    public Integer update(Object object, ILucidSAMSResource iLucidSamsResource) throws LucidSamsExecutionException {

        Connection databaseConnection = databaseConnectionManager.createDatabaseConnection();
        String tableName = iLucidSamsResource.getTABLE_NAME();
        try {
            PreparedStatement preparedStatement = iLucidSamsResource.update(databaseConnection, object);
            int result = preparedStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("'" + tableName + "' update failed, no rows were affected");
            }
            return result;
        } catch (SQLException e) {
            throw new LucidSamsExecutionException("Unable to perform update to the '" + tableName + "' table. ", e);
        } finally {
            databaseConnectionManager.closeDatabaseConnection(databaseConnection);
        }
    }

    /**
     * Retrieves a Lucid-SAMS object given a search criteria
     *
     * @param object
     * @param iLucidSAMSResource
     * @return {@link ResultSet} retrieved Object(s)
     * @throws LucidSamsExecutionException
     */
    public ResultSet retrieve(Object object, ILucidSAMSResource iLucidSAMSResource) throws LucidSamsExecutionException {

        Connection databaseConnection = databaseConnectionManager.createDatabaseConnection();
        String tableName = iLucidSAMSResource.getTABLE_NAME();
        try {

            //TODO: Create search criteria and implementation method to build retrievalPreparedStatements
            PreparedStatement preparedStatement = iLucidSAMSResource.retrieve(databaseConnection, object);

            ResultSet result = preparedStatement.executeQuery();
            if (result == null) {
                throw new SQLException(" retrieval from '" + tableName + "' failed, no data was returned");
            }

            return result;
        } catch (SQLException e) {
            throw new LucidSamsExecutionException("Unable to retrieve from the '" + tableName + "' table. ", e);
        } finally {
            databaseConnectionManager.closeDatabaseConnection(databaseConnection);
        }
    }

    public DatabaseConnectionManager getDatabaseConnectionManager() {
        return databaseConnectionManager;
    }

}
