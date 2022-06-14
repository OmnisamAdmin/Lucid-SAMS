package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.FeederSchools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class FeederSchoolsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "FeederSchools";

    public FeederSchoolsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {

        FeederSchools feederSchools = (FeederSchools) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Name,Tel,Principal,Address) VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, feederSchools.getName());
            preparedStatement.setString(2, feederSchools.getTel());
            preparedStatement.setString(3, feederSchools.getPrincipal());
            preparedStatement.setString(4, feederSchools.getAddress());
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
