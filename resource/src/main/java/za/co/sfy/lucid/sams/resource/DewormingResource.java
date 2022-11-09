package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.Deworming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class DewormingResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {
    private final String TABLE_NAME = "Deworming";

    public DewormingResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManagerAbstractDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManagerAbstractDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {
        Deworming deworming = (Deworming) object;
        String sql = "INSERT INTO " + TABLE_NAME + "(Grade,Datayear,Gender,TotalDewormed,TotalWithSideEffects,TotalEducatorsOrientated) " + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, deworming.getGrade());
            preparedStatement.setString(2, deworming.getDatayear());
            preparedStatement.setString(3, deworming.getGender());
            preparedStatement.setInt(4, deworming.getTotalDewormed());
            preparedStatement.setInt(5, deworming.getTotalWithSideEffects());
            preparedStatement.setInt(6, deworming.getTotalEducatorsOrientated());

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
