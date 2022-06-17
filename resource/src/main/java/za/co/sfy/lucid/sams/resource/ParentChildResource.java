package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.ParentChild;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class ParentChildResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Parent_Child";

    public ParentChildResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {

        ParentChild parentChild = (ParentChild) object;

        String sql = "INSERT INTO " + TABLE_NAME + " (parentId,childId, learnerid, accPayer, status, resides, familyCode," +
                "pastelCustomerAccountDescription, pastelCustomerCategoryCode, pastelContact, sgbReg,relation) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, parentChild.getParentId());
            preparedStatement.setInt(2, parentChild.getChildId());
            preparedStatement.setString(3, parentChild.getLearnerid());
            preparedStatement.setBoolean(4, parentChild.isAccPayer());
            preparedStatement.setString(5, parentChild.getStatus());
            preparedStatement.setString(6, parentChild.getResides());
            preparedStatement.setString(7, parentChild.getFamilyCode());
            preparedStatement.setString(8, parentChild.getPastelCustomerAccountDescription());
            preparedStatement.setInt(9, parentChild.getPastelCustomerCategoryCode());
            preparedStatement.setString(10, parentChild.getPastelContact());
            preparedStatement.setString(11, parentChild.getSGBReg());
            preparedStatement.setString(12, parentChild.getRelation());
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve save prepared statement: " + exception.getMessage(), exception);
        }
    }

    @Override
    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
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
