package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.Subjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author Azeem
 */
@Component
public class SubjectsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Subjects";

    public SubjectsResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        String sql = "INSERT INTO " + TABLE_NAME + "(Name, Key, Code, Group, Selected, Phase, Afrname, PrintOrder, "
                + "CTAWeight, ExcludeSchedule, LuritsCode, SubjectStatus, SubjectGrade, OfficialSubjectID)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Subjects subjects = (Subjects) object;
            preparedStatement.setString(1, subjects.getName());
            preparedStatement.setString(2, subjects.getKey());
            preparedStatement.setString(3, subjects.getCode());
            preparedStatement.setString(4, subjects.getGroup());

            Integer Select = subjects.getSelected();
            if (null == Select) {
                preparedStatement.setNull(5, Types.INTEGER);
            } else {
                preparedStatement.setInt(5, Select);
            }

            Integer phase = subjects.getPhase();
            if (null == phase) {
                preparedStatement.setNull(6, Types.INTEGER);
            } else {
                preparedStatement.setInt(6, phase);
            }

            preparedStatement.setString(7, subjects.getAfrname());

            Integer printOrder = subjects.getPrintOrder();
            if (null == printOrder) {
                preparedStatement.setNull(8, Types.INTEGER);
            } else {
                preparedStatement.setInt(8, printOrder);
            }

            Integer ctaWeight = subjects.getCTAWeight();
            if (null == ctaWeight) {
                preparedStatement.setNull(9, Types.INTEGER);
            } else {
                preparedStatement.setInt(9, ctaWeight);
            }

            Integer excludeSchedule = subjects.getExcludeSchedule();
            if (null == excludeSchedule) {
                preparedStatement.setNull(10, Types.INTEGER);
            } else {
                preparedStatement.setInt(10, excludeSchedule);
            }

            preparedStatement.setString(11, subjects.getLuritsCode());


            Short subjectStatus = subjects.getSubjectStatus();
            if (null == subjectStatus) {
                preparedStatement.setNull(12, Types.INTEGER);
            } else {
                preparedStatement.setInt(12, subjectStatus);
            }

            Integer subjectGrade = subjects.getSubjectGrade();
            if (null == subjectGrade) {
                preparedStatement.setNull(13, Types.INTEGER);
            } else {
                preparedStatement.setInt(13, subjectGrade);
            }
            Integer officialSubjectID = subjects.getOfficialSubjectID();
            if (null == officialSubjectID) {
                preparedStatement.setNull(14, Types.INTEGER);
            } else {
                preparedStatement.setInt(14, officialSubjectID);
            }

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

        String sql = "UPDATE " + TABLE_NAME + " SET Selected = ? , SubjectGrade = ? WHERE Code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Subjects subjects = (Subjects) object;
            preparedStatement.setInt(1, subjects.getSelected());
            preparedStatement.setInt(2, subjects.getSubjectGrade());
            preparedStatement.setString(3, subjects.getCode());
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