package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateConverter;
import za.co.sfy.sams.lucid.schema.Educators;

import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

@Component
public class EducatorsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Educators";
    private final DateConverter dateConverter = new DateConverter();

    public EducatorsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        Educators educators = (Educators) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(FName,SName,Initials,Key,Address1,Address2,Address3,Code,Tel1Code" +
                ",Tel1,BirthDate,IDNumber,DepCode,Subsidies,MedName,MedNo,Spouse,ENumber,Licenses,TaxNo,Academic,Institution" +
                ",Skills,DateJoined,ManagementPosition,PostLevel,Tel2Code,Tel2,Professional,RegisterClass,PersalNumber" +
                ",Homelanguage,2ndlanguage,Race,Title,Gender,EducatorType,MaritalStatus,DisabilityStatus,Actual,Acting" +
                ",natureofApointment,Remuneration,Qualification,QualificationType,PreGradeR,Secondary,GradeR,Primary,LSEN" +
                ",AcademicDegree,ProfessionalDegree,TechnicalCerDip,ProfessionalDiploma,YearsExperience,Time,InstructionLanguage" +
                ",Status,SACE,WCType,EmailAddress,ICTSkill,ICTUsage,Country,Photoname,Intermediate,LuritsNumber" +
                ",TSTransactionCategory,TSStatusFlag,TSReportStatusFlag,TSReasonCode,LuritsIndicator,LuritsFlag,TSSentFileName" +
                ",TSDateLastUpdate,TSLastUpdatedBy,LuritsStatus,KinSName,KinFName,SACitizen,WorkPermit,WorkPermitNo" +
                ",WorkPermitDate,PrevSName,CompUsage,ReasonForNoSACE,UnionName,UnionNo,UnionName2,UnionNo2,UnionNameX,UnionNoX" +
                ",Religion,ForeignID,Bursar) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, educators.getFName());
            preparedStatement.setString(2, educators.getSName());
            preparedStatement.setString(3, educators.getInitials());
            preparedStatement.setString(4, educators.getKey());
            preparedStatement.setString(5, educators.getAddress1());
            preparedStatement.setString(6, educators.getAddress2());
            preparedStatement.setString(7, educators.getAddress3());
            preparedStatement.setString(8, educators.getCode());
            preparedStatement.setString(9, educators.getTel1Code());
            preparedStatement.setString(10, educators.getTel1());
            preparedStatement.setString(11, educators.getBirthDate());
            preparedStatement.setString(12, educators.getIDNumber());
            preparedStatement.setString(13, educators.getDepCode());
            preparedStatement.setString(14, educators.getSubsidies());
            preparedStatement.setString(15, educators.getMedName());
            preparedStatement.setString(16, educators.getMedNo());
            preparedStatement.setString(17, educators.getSpouse());
            preparedStatement.setString(18, educators.getENumber());
            preparedStatement.setString(19, educators.getLicenses());
            preparedStatement.setString(20, educators.getTaxNo());
            preparedStatement.setString(21, educators.getAcademic());
            preparedStatement.setString(22, educators.getInstitution());
            preparedStatement.setString(23, educators.getSkills());
            preparedStatement.setString(24, educators.getDateJoined());
            preparedStatement.setString(25, educators.getManagementPosition());
            preparedStatement.setString(26, educators.getPostLevel());
            preparedStatement.setString(27, educators.getTel2Code());
            preparedStatement.setString(28, educators.getTel2());
            preparedStatement.setString(29, educators.getProfessional());
            preparedStatement.setString(30, educators.getRegisterClass());
            preparedStatement.setString(31, educators.getPersalNumber());
            preparedStatement.setString(32, educators.getHomelanguage());
            preparedStatement.setString(33, educators.getX0032Ndlanguage());
            preparedStatement.setString(34, educators.getRace());
            preparedStatement.setString(35, educators.getTitle());
            preparedStatement.setString(36, educators.getGender());
            preparedStatement.setString(37, educators.getEducatorType());
            preparedStatement.setString(38, educators.getMaritalStatus());
            preparedStatement.setString(39, educators.getDisabilityStatus());
            preparedStatement.setString(40, educators.getActual());
            preparedStatement.setString(41, educators.getActing());
            preparedStatement.setString(42, educators.getNatureofApointment());
            preparedStatement.setString(43, educators.getRemuneration());
            preparedStatement.setString(44, educators.getQualification());
            preparedStatement.setString(45, educators.getQualificationType());
            preparedStatement.setString(46, educators.getPreGradeR());
            preparedStatement.setString(47, educators.getSecondary());
            preparedStatement.setString(48, educators.getGradeR());
            preparedStatement.setString(49, educators.getPrimary());
            preparedStatement.setString(50, educators.getLSEN());
            preparedStatement.setString(51, educators.getAcademicDegree());
            preparedStatement.setString(52, educators.getProfessionalDegree());
            preparedStatement.setString(53, educators.getTechnicalCerDip());
            preparedStatement.setString(54, educators.getProfessionalDiploma());
            preparedStatement.setInt(55, educators.getYearsExperience());
            preparedStatement.setString(56, educators.getTime());
            preparedStatement.setString(57, educators.getInstructionLanguage());
            preparedStatement.setString(58, educators.getStatus());
            preparedStatement.setString(59, educators.getSACE());
            preparedStatement.setInt(60, educators.getWCType());
            preparedStatement.setString(61, educators.getEmailAddress());
            preparedStatement.setString(62, educators.getICTSkill());
            preparedStatement.setString(63, educators.getICTUsage());
            preparedStatement.setString(64, educators.getCountry());
            preparedStatement.setString(65, educators.getPhotoname());
            preparedStatement.setString(66, educators.getIntermediate());
            Integer luritsNumber = educators.getLuritsNumber();
            if (null == luritsNumber) {
                preparedStatement.setNull(67, Types.INTEGER);
            } else {
                preparedStatement.setInt(67, luritsNumber);
            }
            preparedStatement.setInt(68, educators.getTSTransactionCategory());
            preparedStatement.setInt(69, educators.getTSStatusFlag());
            Integer tsReportStatusFlag = educators.getTSReportStatusFlag();
            if (null == tsReportStatusFlag) {
                preparedStatement.setNull(70, Types.INTEGER);
            } else {
                preparedStatement.setInt(70, tsReportStatusFlag);
            }
            Integer tsReasonCode = educators.getTSReasonCode();
            if (null == tsReasonCode) {
                preparedStatement.setNull(71, Types.INTEGER);
            } else {
                preparedStatement.setInt(71, educators.getTSReasonCode());
            }
            Integer luritsIndicator = educators.getLuritsIndicator();
            if (null == luritsIndicator) {
                preparedStatement.setNull(72, Types.INTEGER);
            } else {
                preparedStatement.setInt(72, luritsIndicator);
            }
            preparedStatement.setInt(73, educators.getLuritsFlag());
            preparedStatement.setString(74, educators.getTSSentFileName());
            XMLGregorianCalendar tSDateLastUpdate = educators.getTSDateLastUpdate();
            if (tSDateLastUpdate != null) {
                preparedStatement.setDate(75, dateConverter.getSQLDate(tSDateLastUpdate));
            } else {
                preparedStatement.setNull(75, Types.DATE);
            }
            preparedStatement.setString(76, educators.getTSLastUpdatedBy());
            preparedStatement.setString(77, educators.getLuritsStatus());
            preparedStatement.setString(78, educators.getKinSName());
            preparedStatement.setString(79, educators.getKinFName());
            preparedStatement.setShort(80, educators.getSACitizen());
            Short workPermit = educators.getWorkPermit();
            if(null==workPermit){
                preparedStatement.setNull(81,Types.SMALLINT);
            }else {
                preparedStatement.setShort(81, educators.getWorkPermit());
            }
            preparedStatement.setString(82, educators.getWorkPermitNo());
            preparedStatement.setString(83, educators.getWorkPermitDate());
            preparedStatement.setString(84, educators.getPrevSName());
            preparedStatement.setString(85, educators.getCompUsage());
            preparedStatement.setShort(86, educators.getReasonForNoSACE());
            preparedStatement.setString(87, educators.getUnionName());
            preparedStatement.setString(88, educators.getUnionNo());
            preparedStatement.setString(89, educators.getUnionName2());
            preparedStatement.setString(90, educators.getUnionNo2());
            preparedStatement.setString(91, educators.getUnionNameX());
            preparedStatement.setString(92, educators.getUnionNoX());
            preparedStatement.setString(93, educators.getReligion());
            preparedStatement.setString(94, educators.getForeignID());
            preparedStatement.setInt(95, educators.getBursar());

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

    public ResultSet retrieveEducatorsByID(Long educatorID) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME + " Where EdID = ?";
        Connection connection = getDatabaseConnectionManager().createDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Math.toIntExact(educatorID));
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve Educators of id '" + educatorID + "' :"
                    , exception);
        }
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
