package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import za.co.sfy.lucid.sams.resource.connection.AbstractDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.SubjectSets;

/**
 * @author Azeem
 */
@Component
public class SubjectSetResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "SubjectSets";

    public TopicsResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
super(edusolStrucDatabaseConnectionManager);
}

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {
       
        String sql = "INSERT INTO " + TABLE_NAME + "( Description, SubjectID, SubjectSetGrade )"
                        + "VALUES(?,?,?)";

        try { 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                SubjectSets subjectsets = (SubjectSets) object;
            

            
            preparedStatement.setShort(1, subjectsets.getDescription());
            preparedStatement.setInt(2, subjectsets.getSubjectID());
            preparedStatement.setInt(3, subjectsets.getSubjectSetGrade());
         
  
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

        String sql = "UPDATE " + TABLE_NAME + " Description = ? , SubjectID = ? , SubjectSetID  = ? , SubjectSetGrade = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            SubjectSets SubjectSets = (SubjectSets) object;
            preparedStatement.setShort(1, SubjectSets.getDescription());
            preparedStatement.setInt(2, SubjectSets.getSubjectID());
            preparedStatement.setInt(3, SubjectSets.getSubjectSetID());
            preparedStatement.setInt(4, SubjectSets.getSubjectSetGrade());
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
