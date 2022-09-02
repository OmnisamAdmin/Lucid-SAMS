package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import za.co.sfy.lucid.sams.resource.connection.AbstractDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.Topics;

/**
 * @author muzim
 */
@Component
public class TopicsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "SubjectMainTopics";

    public TopicsResource(AbstractDatabaseConnectionManager databaseConnectionManager) throws LucidSamsExecutionException {
        super(databaseConnectionManager);
    }

    public TopicsResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {
       
        String sql = "INSERT INTO " + TABLE_NAME + "( MainPosition, Description, AfrDescription)"
                        + "VALUES(?,?,?)";

        try { 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Topics Topics = (Topics) object;
            

            
            preparedStatement.setString(1, Topics.getMainPosition());
            preparedStatement.setString(2, Topics.getDescription());
            preparedStatement.setString(3, Topics.getAfrDescription());
         
  
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

        String sql = "UPDATE " + TABLE_NAME + " MainPosition = ? , Description = ? , AfrDescription = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Topics SubjectMainTopics = (Topics) object;
            preparedStatement.setString(1, SubjectMainTopics.getMainPosition());
            preparedStatement.setString(2, SubjectMainTopics.getDescription());
            preparedStatement.setString(3, SubjectMainTopics.getAfrDescription());
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve update prepared statement ", exception);
        }
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
