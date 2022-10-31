package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import za.co.sfy.lucid.sams.resource.util.DateUtil;
import za.co.sfy.sams.lucid.schema.SubjectCriteria;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author Azeem
 */
@Component
public class SubjectCriteriaResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "SubjectCriteria";
    private final DateUtil dateUtil = new DateUtil();

    public SubjectCriteriaResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        String sql = "INSERT INTO " + TABLE_NAME + "(SubjectID,CriterionID,Description,Grade,Weighting,SubjectLevel," +
                "CriterionScore,DataYear,SubHeading,DateAdded,Type,Outcomes,Activities,Assessments,SectionID," +
                "UseActivities,IncludeFFL,IncludeExam,Updated,QuaterlyTest,FETCommonTest,DescriptionAFR," +
                "DescriptionVern,TaskType,SBATask,SBAWeight,FixedCriterionScore,FixedWeight,FixedSBAWeight," +
                "SubjSplitNo,OFFSubjectID,OFFCriterionID,Reclocked,Status,FIxed0Weight)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            SubjectCriteria subjectcriteria = (SubjectCriteria) object;

            preparedStatement.setInt(1, subjectcriteria.getSubjectid());
            preparedStatement.setInt(2, subjectcriteria.getCriterionId());
            preparedStatement.setShort(3, Short.parseShort(subjectcriteria.getDescription()));
            preparedStatement.setInt(4, subjectcriteria.getGrade());
            preparedStatement.setDouble(5, subjectcriteria.getWeighting());
            preparedStatement.setShort(6, Short.parseShort(subjectcriteria.getSubjectLevel()));
            preparedStatement.setInt(7, subjectcriteria.getCriterionScore());
            preparedStatement.setShort(8, Short.parseShort(subjectcriteria.getDataYear()));
            preparedStatement.setShort(9, Short.parseShort(subjectcriteria.getSubHeading()));

            XMLGregorianCalendar dateAdded = subjectcriteria.getDateAdded();
            if (dateAdded != null) {
                preparedStatement.setDate(10, dateUtil.toSQLDate(dateAdded));
            } else {
                preparedStatement.setNull(10, Types.DATE);
            }
            preparedStatement.setShort(11, Short.parseShort(subjectcriteria.getType()));
            preparedStatement.setLong(12, Long.parseLong(subjectcriteria.getOutcomes()));
            preparedStatement.setLong(13, Long.parseLong(subjectcriteria.getActivities()));
            preparedStatement.setLong(14, Long.parseLong(subjectcriteria.getAssessments()));
            preparedStatement.setInt(15, subjectcriteria.getSectionId());
            preparedStatement.setBoolean(16, subjectcriteria.isUseActivities());
            preparedStatement.setBoolean(17, subjectcriteria.isIncludeFFL());
            preparedStatement.setBoolean(18, subjectcriteria.isIncludeExam());
            preparedStatement.setShort(19, Short.parseShort(subjectcriteria.getUpdated()));
            preparedStatement.setBoolean(20, subjectcriteria.isQuarterlyTest());
            preparedStatement.setBoolean(21, subjectcriteria.isFETCommonTest());
            preparedStatement.setShort(22, Short.parseShort(subjectcriteria.getDescriptionAfr()));
            preparedStatement.setShort(23, Short.parseShort(subjectcriteria.getDescriptionVern()));
            preparedStatement.setInt(24, subjectcriteria.getTaskType());
            preparedStatement.setBoolean(25, subjectcriteria.isSBATask());
            preparedStatement.setDouble(26, subjectcriteria.getSBAWeight());
            preparedStatement.setInt(27, subjectcriteria.getFixedCriterionScore());
            preparedStatement.setDouble(28, subjectcriteria.getFixedWeight());
            preparedStatement.setDouble(29, subjectcriteria.getFixedSBAWeight());
            preparedStatement.setInt(30, subjectcriteria.getSubjSplitNo());
            preparedStatement.setInt(31, subjectcriteria.getOffSubjectID());
            preparedStatement.setInt(32, subjectcriteria.getOffCriterionId());
            preparedStatement.setBoolean(33, subjectcriteria.isRecLocked());
            preparedStatement.setInt(34, subjectcriteria.getStatus());
            preparedStatement.setBoolean(35, subjectcriteria.isFixed0Weight());
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
            preparedStatement.setInt(1, subjectcriteria.getSubjectid());
            preparedStatement.setInt(2, subjectcriteria.getGrade());
            preparedStatement.setInt(3, subjectcriteria.getSubjSplitNo());
            preparedStatement.setString(4, subjectcriteria.getDescriptionVern());
            preparedStatement.setDouble(5, subjectcriteria.getSubjectid());
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