package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.DisciplinaryLearnerMisconduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author muzim
 */
@Component
public class DisciplinaryLearnerMisconductResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "DisciplinaryLearnerMisconduct";

    public DisciplinaryLearnerMisconductResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    public ResultSet retrieveByCode(String code) throws LucidSamsExecutionException {

        String sql = "SELECT *  FROM " + TABLE_NAME + " WHERE Code = ? ";
        Connection connection = getDatabaseConnectionManager().getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve levels ", exception);
        }
    }

    public ResultSet retrieveLevels() throws LucidSamsExecutionException {

        String sql = "SELECT DISTINCT Level FROM " + TABLE_NAME + " ORDER BY Level ASC ";
        Connection connection = getDatabaseConnectionManager().getDatabaseConnection();

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
        Connection connection = getDatabaseConnectionManager().getDatabaseConnection();
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
        String sql = "UPDATE " + TABLE_NAME + "Description = ?, EditStatus = ?, AfrDesc = ?" +
                ", Type = ?, Point = ? WHERE Code = ?";

        DisciplinaryLearnerMisconduct disciplinaryLearnerMisconduct = (DisciplinaryLearnerMisconduct) object;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            String description = disciplinaryLearnerMisconduct.getDescription();
            preparedStatement.setString(1, description);

            String editStatus = disciplinaryLearnerMisconduct.getEditStatus();
            preparedStatement.setString(2, editStatus);

            String afrDesc = disciplinaryLearnerMisconduct.getAfrDesc();
            preparedStatement.setString(3, afrDesc);

            String type = disciplinaryLearnerMisconduct.getType();
            preparedStatement.setString(4, type);

            Integer point = disciplinaryLearnerMisconduct.getPoint();
            if (null == point) {
                preparedStatement.setNull(5, Types.INTEGER);
            } else {
                preparedStatement.setInt(5, point);
            }

            String code = disciplinaryLearnerMisconduct.getCode();
            preparedStatement.setString(6, code);

            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve update prepared statement ", exception);
        }
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
