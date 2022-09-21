package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import za.co.sfy.lucid.sams.resource.connection.AbstractDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.SubjectCriteria;

/**
 * @author Azeem
 */
@Component
public class SubjectCriteriaResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "SubjectCriteria";
public SubjectCriteriaResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
super(edusolStrucDatabaseConnectionManager);
}

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {
       
        String sql = "INSERT INTO " + TABLE_NAME + "(SubjectID, CriterionID, Description, Grade, Weighting, SubjectLevel, CriterionScore, DataYear, SubHeading, DateAdded, Type, Outcomes, "
 + "Activities,Assessments, SectionID, UseActivities, IncludeFFL, IncludeExam, Updated, QuaterlyTest, FETCommonTest, DescriptionAFR, DescriptionVern, TaskType, SBATask, SBAWeight, FixedCriterionScore, "
 + "FixedWeight, FixedSBAWeight, SubjSplitNo, OFFSubjectID, OFFCriterionID, Reclocked, Status, FIxed0Weight)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try { 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                SubjectCriteria subjectcriteria = (SubjectCriteria) object;
                
            preparedStatement.setInt(1,subjectcriteria.getSubjectID());
            preparedStatement.setInt(2,subjectcriteria.getCriterionID());
            preparedStatement.setShort(3,subjectcriteria.getDescription());
            preparedStatement.setInt(4,subjectcriteria.getGrade());
            preparedStatement.setDouble(5,subjectcriteria.getWeighting());
            preparedStatement.setShort(6,subjectcriteria.getSubjectLevel());
            preparedStatement.setInt(7,subjectcriteria.getCriterionScore());
            preparedStatement.setShort(8,subjectcriteria.getDataYear());
            preparedStatement.setShort(9,subjectcriteria.getSubHeading());
            preparedStatement.setDate(10,subjectcriteria.getDateAdded());
            preparedStatement.setShort(11,subjectcriteria.getType());
            preparedStatement.setLong(12,subjectcriteria.getOutcomes());
            preparedStatement.setLong(13,subjectcriteria.getActivities());
            preparedStatement.setLong(14,subjectcriteria.getAssessments());
            preparedStatement.setInt(15,subjectcriteria.getSectionId());
            preparedStatement.setBoolean(16,subjectcriteria.getUseActivities());
            preparedStatement.setBoolean(17,subjectcriteria.getIncludeFFL());
            preparedStatement.setBoolean(18,subjectcriteria.getIncludeExam());
            preparedStatement.setShort(19,subjectcriteria.getUpdated());
            preparedStatement.setBoolean(20,subjectcriteria.getQuarterlyTest());
            preparedStatement.setBoolean(21,subjectcriteria.getFETCommonTest());
            preparedStatement.setShort(22,subjectcriteria.getDescriptionAFR());
            preparedStatement.setShort(23,subjectcriteria.getDescriptionVern());
            preparedStatement.setInt(24,subjectcriteria.getTaskType());
            preparedStatement.setBoolean(25,subjectcriteria.getSBATask());
            preparedStatement.setInt(26,subjectcriteria.getSBAWeight());
            preparedStatement.setInt(27,subjectcriteria.getFixedCriterionScore());
            preparedStatement.setInt(28,subjectcriteria.getFixedWeight());
            preparedStatement.setInt(29,subjectcriteria.getFixedSBAWeight());
            preparedStatement.setInt(30,subjectcriteria.getSubjSplitNo());
            preparedStatement.setInt(31,subjectcriteria.getOFFSubjectID());
            preparedStatement.setInt(32,subjectcriteria.getOFFCriterionID());
            preparedStatement.setBoolean(33,subjectcriteria.getRecLocked());
            preparedStatement.setInt(34,subjectcriteria.getStatus());
            preparedStatement.setBoolean(35,subjectcriteria.getFixed0Weight());
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

        String sql = "UPDATE " + TABLE_NAME + "SubjectCriteria = ? , Grade = ? , EducatorId = ? , GroupName = ? , SubjectId = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            SubjectCriteria subjectcriteria = (SubjectCriteria) object;
            preparedStatement.setInt(1,subjectcriteria.getSubjectID());
            preparedStatement.setInt(2,subjectcriteria.getCriterionID());
            preparedStatement.setShort(3,subjectcriteria.getDescription());
            preparedStatement.setInt(4,subjectcriteria.getGrade());
            preparedStatement.setDouble(5,subjectcriteria.getWeighting());
            preparedStatement.setShort(6,subjectcriteria.getSubjectLevel());
            preparedStatement.setInt(7,subjectcriteria.getCriterionScore());
            preparedStatement.setShort(8,subjectcriteria.getDataYear());
            preparedStatement.setShort(9,subjectcriteria.getSubHeading());
            preparedStatement.setDate(10,subjectcriteria.getDateAdded());
            preparedStatement.setShort(11,subjectcriteria.getType());
            preparedStatement.setLong(12,subjectcriteria.getOutcomes());
            preparedStatement.setLong(13,subjectcriteria.getActivities());
            preparedStatement.setLong(14,subjectcriteria.getAssessments());
            preparedStatement.setInt(15,subjectcriteria.getSectionId());
            preparedStatement.setBoolean(16,subjectcriteria.getUseActivities());
            preparedStatement.setBoolean(17,subjectcriteria.getIncludeFFL());
            preparedStatement.setBoolean(18,subjectcriteria.getIncludeExam());
            preparedStatement.setShort(19,subjectcriteria.getUpdated());
            preparedStatement.setBoolean(20,subjectcriteria.getQuaterlyTest());
            preparedStatement.setBoolean(21,subjectcriteria.getFETCommonTest());
            preparedStatement.setShort(22,subjectcriteria.getDescriptionAFR());
            preparedStatement.setShort(23,subjectcriteria.getDescriptionVern());
            preparedStatement.setInt(24,subjectcriteria.getTaskType());
            preparedStatement.setBoolean(25,subjectcriteria.getSBATask());
            preparedStatement.setInt(26,subjectcriteria.getSBAWeight());
            preparedStatement.setInt(27,subjectcriteria.getFixedCriterionScore());
            preparedStatement.setInt(28,subjectcriteria.getFixedWeight());
            preparedStatement.setInt(29,subjectcriteria.getFixedSBAWeight());
            preparedStatement.setInt(30,subjectcriteria.getSubjSplitNo());
            preparedStatement.setInt(31,subjectcriteria.getOFFSubjectID());
            preparedStatement.setInt(32,subjectcriteria.getOFFCriterionID());
            preparedStatement.setBoolean(33,subjectcriteria.getRecLocked());
            preparedStatement.setInt(34,subjectcriteria.getStatus());
            preparedStatement.setBoolean(35,subjectcriteria.getFixed0Weight());
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve update prepared statement", exception);
        }
    }
    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
