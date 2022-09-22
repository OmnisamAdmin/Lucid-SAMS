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
 * @author muzim
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

              Integer Phase = subjects.getPhase();
            if (null == Phase) {
                preparedStatement.setNull(6, Types.INTEGER);
            } else {
                preparedStatement.setInt(6, Phase);
            }

            preparedStatement.setString(7, subjects.getAfrname());

              Integer PrintOrder = subjects.getPrintOrder();
            if (null == PrintOrder) {
                preparedStatement.setNull(8, Types.INTEGER);
            } else {
                preparedStatement.setInt(8, Select);
            }

              Integer CTAWeight = subjects.getCTAWeight();
            if (null == CTAWeight) {
                preparedStatement.setNull(9, Types.INTEGER);
            } else {
                preparedStatement.setInt(9, CTAWeight);
            }

              Integer ExcludeSchedule = subjects.getExcludeSchedule();
            if (null == ExcludeSchedule) {
                preparedStatement.setNull(10, Types.INTEGER);
            } else {
                preparedStatement.setInt(10, ExcludeSchedule);
            }

            preparedStatement.setString(11, subjects.getLuritsCode());

           
                 Short SubjectStatus = subjects.getSubjectStatus();
            if (null == SubjectStatus) {
                preparedStatement.setNull(12, Types.INTEGER);
            } else {
                preparedStatement.setInt(12, ExcludeSchedule);
            }
            
              Integer SubjectGrade = subjects.getSubjectGrade();
            if (null == SubjectGrade) {
                preparedStatement.setNull(13, Types.INTEGER);
            } else {
                preparedStatement.setInt(13, Select);
            }
              Integer OfficialSubjectID = subjects.getOfficialSubjectID();
            if (null == OfficialSubjectID) {
                preparedStatement.setNull(14, Types.INTEGER);
            } else {
                preparedStatement.setInt(14, Select);
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