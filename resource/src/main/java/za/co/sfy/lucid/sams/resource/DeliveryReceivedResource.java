package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.NSNPDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.DeliveryRecieved;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class DeliveryReceivedResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Delivery_Received";

    public DeliveryReceivedResource(NSNPDatabaseConnectionManager nsnpDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(nsnpDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {
        DeliveryRecieved deliveryRecieved = (DeliveryRecieved) object;
        String sql = "INSERT INTO " + TABLE_NAME + "(Supplier,Date_Recieved,ProductName,AprovedQuantity,QuantityOrdered" +
                ",Quantity,Food_Group,Data_Year,Left_Quantity,instore) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deliveryRecieved.getSupplier());
            preparedStatement.setString(2, deliveryRecieved.getDateRecieved());
            preparedStatement.setString(3, deliveryRecieved.getProductName());
            preparedStatement.setInt(4, deliveryRecieved.getAprovedQuantity());
            preparedStatement.setInt(5, deliveryRecieved.getQuantityOrdered());
            preparedStatement.setInt(6, deliveryRecieved.getQuantity());
            preparedStatement.setInt(7, deliveryRecieved.getFoodGroup());
            preparedStatement.setInt(8, deliveryRecieved.getDataYear());
            preparedStatement.setInt(9, deliveryRecieved.getLeftQuantity());
            preparedStatement.setInt(10, deliveryRecieved.getInstore());

            return preparedStatement;
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve update prepared statement ", exception);
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
