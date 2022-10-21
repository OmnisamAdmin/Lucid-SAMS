package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.NSNPDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.QuaterlyRecievedTransfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuaterlyRecievedTransferResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "QuarterlyRecievedTransfer";

    public QuaterlyRecievedTransferResource(NSNPDatabaseConnectionManager nsnpDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(nsnpDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        QuaterlyRecievedTransfer quaterlyRecievedTransfer = (QuaterlyRecievedTransfer) object;
        String sql = "INSERT INTO " + TABLE_NAME + "(Amount,Data_Year,Quarter,Date_Recieved) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, quaterlyRecievedTransfer.getAmount());
            preparedStatement.setInt(2, quaterlyRecievedTransfer.getDataYear());
            preparedStatement.setString(3, quaterlyRecievedTransfer.getQuarter());
            preparedStatement.setString(4, quaterlyRecievedTransfer.getDateRecieved());

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
        String sql = "UPDATE " + TABLE_NAME + " SET Amount = ?, Data_Year = ? ,Quarter = ?, Date_Recieved = ? WHERE Quarter = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            QuaterlyRecievedTransfer quaterlyRecievedTransfer = (QuaterlyRecievedTransfer) object;
            preparedStatement.setString(1, quaterlyRecievedTransfer.getAmount());
            preparedStatement.setInt(2, quaterlyRecievedTransfer.getDataYear());
            preparedStatement.setString(3, quaterlyRecievedTransfer.getQuarter());
            preparedStatement.setString(4, quaterlyRecievedTransfer.getDateRecieved());

            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve update prepared statement ", exception);
        }
    }

    public ResultSet retrieveQuaterlyRecievedTransferByQuarter(String quarter) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME + " Where Qaurter = ?";
        Connection connection = getDatabaseConnectionManager().retrieveDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, quarter);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve QuaterlyRecievedTransfer of quarter value '" + quarter + "' :"
                    , exception);
        }
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
