package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.LearnerMentors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LearnerMentorsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "LearnerMentors";

    public LearnerMentorsResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        LearnerMentors learnerMentors = (LearnerMentors) object;
        String sql = "INSERT INTO " + TABLE_NAME + "(TypeID,LinkID,SName,FName,Comment,Status) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, learnerMentors.getTypeID());
            preparedStatement.setInt(2, learnerMentors.getLinkID());
            preparedStatement.setString(3, learnerMentors.getSName());
            preparedStatement.setString(4, learnerMentors.getFName());
            preparedStatement.setString(5, learnerMentors.getComment());
            preparedStatement.setString(6, learnerMentors.getStatus());

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
        return null;
    }

    public ResultSet retrieveLearnerMentorsByMentorID(Long mentorID) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME + " Where MentorID = ?";
        Connection connection = getDatabaseConnectionManager().retrieveDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Math.toIntExact(mentorID));
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve LearnerMentors of MentorID '" + mentorID + "' :"
                    , exception);
        }
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
