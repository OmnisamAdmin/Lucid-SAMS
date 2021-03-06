package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.ExtraMuralsHouses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class ExtraMuralsHousesResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "ExtraMuralsHouses";

    public ExtraMuralsHousesResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {

        ExtraMuralsHouses extraMuralsHouses = (ExtraMuralsHouses) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(HseName,HseAfrName,HseColour,HseAfrColour,HsePicture,RecSelected)" +
                " VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, extraMuralsHouses.getHseName());
            preparedStatement.setString(2, extraMuralsHouses.getHseAfrName());
            preparedStatement.setString(3, extraMuralsHouses.getHseColour());
            preparedStatement.setString(4, extraMuralsHouses.getHseAfrColour());
            preparedStatement.setBytes(5, extraMuralsHouses.getHsePicture());
            preparedStatement.setBoolean(6, extraMuralsHouses.isRecSelected());
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve save prepared statement: "
                    + exception.getMessage(), exception);
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
