package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.Educatorgroups;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Azeem
 */
@Component
public class EducatorsGroupResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Educatorgroups";

    public EducatorsGroupResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        String sql = "INSERT INTO " + TABLE_NAME + "(EducatorGroupID, Grade, EducatorId, GroupName, SubjectId)"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Educatorgroups educatorGroups = (Educatorgroups) object;
            preparedStatement.setInt(1, educatorGroups.getEducatorGroupID());
            preparedStatement.setInt(2, educatorGroups.getGrade());
            preparedStatement.setInt(3, educatorGroups.getEducatorId());
            preparedStatement.setString(4, educatorGroups.getGroupName());
            preparedStatement.setInt(5, educatorGroups.getSubjectId());

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

        String sql = "UPDATE " + TABLE_NAME + "EducatorGroup = ? , Grade = ? , EducatorId = ? , GroupName = ? , SubjectId = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Educatorgroups educatorGroups = (Educatorgroups) object;
            preparedStatement.setInt(1, educatorGroups.getEducatorGroupID());
            preparedStatement.setInt(2, educatorGroups.getGrade());
            preparedStatement.setInt(3, educatorGroups.getEducatorId());
            preparedStatement.setString(4, educatorGroups.getGroupName());
            preparedStatement.setInt(5, educatorGroups.getSubjectId());
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