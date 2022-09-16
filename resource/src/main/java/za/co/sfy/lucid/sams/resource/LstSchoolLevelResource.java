package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.NSNPDatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LstSchoolLevelResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "lst_School_level";

    public LstSchoolLevelResource(NSNPDatabaseConnectionManager nsnpDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(nsnpDatabaseConnectionManager);
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
            throw new LucidSamsExecutionException("Failed to retrieve save prepared statement ", exception);
        }
    }

    @Override
    public PreparedStatement update(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    public ResultSet retrieveLstSchoolLevelByDescription(String schoolLevel) throws LucidSamsExecutionException {
        String sql = "SELECT * FROM " + TABLE_NAME + " Where Description = ?";
        Connection connection = getDatabaseConnectionManager().retrieveDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, schoolLevel);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve lst_School_level of ProductName '" + schoolLevel + "' :"
                    , exception);
        }
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
