package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class ReportLanguagesResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "ReportLanguages";

    public ReportLanguagesResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    public ResultSet retrieveReportLanguagesByID(Long id) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME + " Where id = ?";
        Connection connection = getDatabaseConnectionManager().getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve ReportLanguage of id '" + id + "' ", exception);
        }
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public PreparedStatement retrieve(Connection connection, Object object) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve retrieve prepared statement ", exception);
        }
    }

    @Override
    public PreparedStatement update(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
