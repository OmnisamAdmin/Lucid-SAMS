package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.BusRoutes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class BusRoutesResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "BusRoutes";

    public BusRoutesResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException {

        BusRoutes busRoutes = (BusRoutes) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Route,DepartureTime,RouteDescription,BusName,Responsible) " +
                "VALUES (?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, busRoutes.getRoute());
        preparedStatement.setString(2, busRoutes.getDepartureTime());
        preparedStatement.setString(3, busRoutes.getRouteDescription());
        preparedStatement.setString(4, busRoutes.getBusName());
        preparedStatement.setString(5, busRoutes.getResponsible());

        return preparedStatement;
    }

    @Override
    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object) {
        return null;
    }

    @Override
    public PreparedStatement retrieveUpdatePreparedStatement(Connection connection, Object object) throws SQLException {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
