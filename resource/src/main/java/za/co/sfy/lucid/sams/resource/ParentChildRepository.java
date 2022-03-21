package za.co.sfy.lucid.sams.resource;

import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.ParentChild;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParentChildRepository extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Parent_Child";

    public ParentChildRepository(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrievePreparedStatement(Connection connection, Object object) throws SQLException {

        ParentChild parentChild = (ParentChild) object;
        String sql = "INSERT INTO " + TABLE_NAME + " (parentId,childId, learnerid, accPayer, status, resides, familyCode," +
                "pastelCustomerAccountDescription, pastelCustomerCategoryCode, pastelContact, sgbReg,relation) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

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
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
