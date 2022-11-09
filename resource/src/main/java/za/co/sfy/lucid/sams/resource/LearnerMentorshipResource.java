package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateUtil;
import za.co.sfy.sams.lucid.schema.LearnerMentorships;

import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

@Component
public class LearnerMentorshipResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final DateUtil dateUtil = new DateUtil();
    private final String TABLE_NAME = "LearnerMentorships";

    public LearnerMentorshipResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {
        LearnerMentorships learnerMentorships = (LearnerMentorships) object;
        String sql = "INSERT INTO " + TABLE_NAME + "(CatID,MentorID,LearnerID,DateStart,DateEnd,Comment) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, learnerMentorships.getCatID());
            preparedStatement.setInt(2, learnerMentorships.getMentorID());
            preparedStatement.setInt(3, learnerMentorships.getLearnerID());

            XMLGregorianCalendar dateStart = learnerMentorships.getDateStart();
            if (dateStart != null) {
                preparedStatement.setDate(4, dateUtil.toSQLDate(dateStart));
            } else {
                preparedStatement.setNull(4, Types.DATE);
            }

            XMLGregorianCalendar dateEnd = learnerMentorships.getDateEnd();
            if (dateEnd != null) {
                preparedStatement.setDate(5, dateUtil.toSQLDate(dateEnd));
            } else {
                preparedStatement.setNull(5, Types.DATE);
            }

            preparedStatement.setString(6, learnerMentorships.getComment());

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

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

}