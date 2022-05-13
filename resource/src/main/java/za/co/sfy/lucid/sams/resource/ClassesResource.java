package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class ClassesResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Classes";

    public ClassesResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException {
        Classes classes = (Classes) object;
        String sql = "INSERT INTO " + TABLE_NAME + "(Grade,ClassName,EdCode,Room,Type) " +
                "VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, classes.getGrade());
        preparedStatement.setString(2, classes.getClassName());
        preparedStatement.setString(3, classes.getEdCode());
        preparedStatement.setString(4, classes.getRoom());
        preparedStatement.setInt(5, classes.getType());
        return preparedStatement;
    }

    @Override
    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object) {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

}
