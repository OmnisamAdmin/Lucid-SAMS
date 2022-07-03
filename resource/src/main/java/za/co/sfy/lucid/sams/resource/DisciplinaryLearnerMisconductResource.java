package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.DisciplinaryLearnerMisconduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class DisciplinaryLearnerMisconductResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "DisciplinaryLearnerMisconduct";

    public DisciplinaryLearnerMisconductResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    public ResultSet retrieveLevels() throws LucidSamsExecutionException {

        String sql = "SELECT DISTINCT Level FROM " + TABLE_NAME + " ORDER BY Level ASC ";
        Connection connection = getDatabaseConnectionManager().createDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve levels ", exception);
        }
    }

    public ResultSet retrieveCodes() throws LucidSamsExecutionException {

        String sql = "SELECT DISTINCT Code FROM " + TABLE_NAME + " ORDER BY Code ASC";
        Connection connection = getDatabaseConnectionManager().createDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve codes ", exception);
        }
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        DisciplinaryLearnerMisconduct disciplinaryLearnerMisconduct = (DisciplinaryLearnerMisconduct) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Level,Code,Description,EditStatus,AfrDesc,Type) " +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, disciplinaryLearnerMisconduct.getLevel());
            preparedStatement.setString(2, disciplinaryLearnerMisconduct.getCode());
            preparedStatement.setString(3, disciplinaryLearnerMisconduct.getDescription());
            preparedStatement.setString(4, disciplinaryLearnerMisconduct.getEditStatus());
            preparedStatement.setString(5, disciplinaryLearnerMisconduct.getAfrDesc());
            preparedStatement.setString(6, disciplinaryLearnerMisconduct.getType());
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve save prepared statement ", exception);
        }
    }

    @Override
    public PreparedStatement retrieve(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
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
