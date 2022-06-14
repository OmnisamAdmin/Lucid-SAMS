package za.co.sfy.lucid.sams.resource;

import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportLanguagesResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "ReportLanguages";

    public ReportLanguagesResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    public ResultSet retrieveReportLanguagesByID(Long id) throws LucidSamsExecutionException {

        String sql = "SELECT + FROM " + TABLE_NAME + " id = ?";
        Connection connection = getDatabaseConnectionManager().createDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve ReportLanguage of id '" + id + "':"
                    + exception.getMessage());
        }
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve retrieve prepared statement"
                    + exception.getMessage(), exception);
        }
    }

    @Override
    public PreparedStatement retrieveUpdatePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
