package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import za.co.sfy.sams.lucid.schema.SubjectMainTopics;

/**
 * @author ahussain
 */
@Component
public class SubjectMainTopicsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "SubjectMainTopics";

    public SubjectMainTopicsResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        String sql = "INSERT INTO " + TABLE_NAME + "(MainPosition, Description, AfrDescription)"
                + "VALUES(?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            SubjectMainTopics subjectMainTopics = (SubjectMainTopics) object;

            preparedStatement.setString(1, String.valueOf(subjectMainTopics.getMainPosition()));
            preparedStatement.setString(2, subjectMainTopics.getDescription());
            preparedStatement.setString(3, subjectMainTopics.getAfrDescription());


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
            SubjectMainTopics SubjectMainTopics = (SubjectMainTopics) object;
            preparedStatement.setString(1, String.valueOf(SubjectMainTopics.getMainPosition()));
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