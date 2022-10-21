package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateUtil;
import za.co.sfy.sams.lucid.schema.LearnerInfo;

import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author muzim
 */
@Component
public class LearnerInfoResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final DateUtil dateUtil = new DateUtil();
    private final String TABLE_NAME = "Learner_Info";

    public LearnerInfoResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    public ResultSet retrieveLearnerInfoByID(Long id) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME + " Where ID = ?";
        Connection connection = getDatabaseConnectionManager().retrieveDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve LearnerInfo of id '" + id + "' :"
                    , exception);
        }
    }

    public ResultSet retrieveLearnerInfoByLearnerID(String learnerID) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME + " Where LearnerID = ?";
        Connection connection = getDatabaseConnectionManager().retrieveDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, learnerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve LearnerInfo of LearnerID '" + learnerID + "' :"
                    , exception);
        }
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        LearnerInfo learnerInfo = (LearnerInfo) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(LearnerID, AccessionNo, TheDate, SName, " +
                "FName, NickName, BirthDate, IDNo, Gender, HomeLanguage, InstructionLanguage" +
                ", PreferredLanguage, Address1, Address2, Address3, AddressCode, Guardian, " +
                "Tel1Code, Tel1, Tel2Code, Tel2, Tel3Code, Tel3, Grade, Class, " +
                "GradeYears, PreviousSchool, SchoolAddress1, SchoolAddress2, SchoolAddress3," +
                " SchoolCode, Religion, Disciplinary, MedicalConditions, DrInfo, MedicalAidName, " +
                "MedicalAidNo, MedicalAidMember, Guidance, Initials, Citizenship, Provincial," +
                " SchoolProvince, PreviousSchoolProvince, AssignClass, PhysProvince, Race, Title," +
                " PreviousPlacementofSchool, Transport, lSENDisabilities, DateLeft, Reason," +
                " LSENStatus, Status, Boarder, CountryResidence, ProvinceResidence, FirstProvince," +
                " DeceasedParent, SGRegister, SGReceive, DrName, DrTel, Dexterity, PSNP," +
                " NoFamily, PositionFamily, ReportLanguage, ForeignID, LearnerComment, PhotoName, " +
                "GradeEntered, GradeLeft, BoarderNumber, BoarderHostel, ThirdName, Email, " +
                "SocialGrantNo, TSTransactionCategory, TSStatusFlag, TSReporTStatusFlag, TSReasonCode," +
                " LuritsIndicator, LuritsFlag, LuritsNumber, TSSentfileName, TSDateLastUpdate," +
                " TSLastUpdatedBy, LearnerName2, LearnerName3, NameDiacritics, OtherHomeLanguage, " +
                "OtherLanguage, OtherPreferredLanguage, OtherTeachingLanguage, LuritsStatus, SecondName," +
                " PastelCode, BusRouteId, Subj_HL, Subj_FAL, PrevSName, PositionFamilyF, " +
                "ReasonForNoIDNo, GrantCReg, GrantCReceive, GrantCNo, Grant4Reg, Grant4Receive," +
                " Grant4No, Grant5Reg, Grant5Receive, Grant5No, Grant9Reg, Grant9Receive, " +
                "Grant9No, ClinicName, ClinicAccRef, ClinicTelCode, ClinicTel, subj_LOI, HseID," +
                " PhaseYears, ProgressedToGrade, StudyPermit, StudyPermitNo, StudyPermitDate," +
                " IDNoNotValidating, OldMentor, LSENAnaInc, LSENAnaHL, LSENAnaFAL, " +
                "PreviousPlacementofSchoolYear, ForeignIDType, AgeRuleOverwritten, ReasonForNoForeignID," +
                " FarmProj, Road2Health, ImmunizationCard, ICEName, ICESurname, ICERelation) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, learnerInfo.getLearnerID());
            preparedStatement.setString(2, learnerInfo.getAccessionNo());
            preparedStatement.setString(3, learnerInfo.getTheDate());
            preparedStatement.setString(4, learnerInfo.getSName());
            preparedStatement.setString(5, learnerInfo.getFName());
            preparedStatement.setString(6, learnerInfo.getNickName());
            preparedStatement.setString(7, learnerInfo.getBirthDate());
            preparedStatement.setString(8, learnerInfo.getIDNo());
            preparedStatement.setString(9, learnerInfo.getGender());
            preparedStatement.setInt(10, learnerInfo.getHomeLanguage());
            preparedStatement.setInt(11, learnerInfo.getInstructionLanguage());
            preparedStatement.setInt(12, learnerInfo.getPreferredLanguage());
            preparedStatement.setString(13, learnerInfo.getAddress1());
            preparedStatement.setString(14, learnerInfo.getAddress2());
            preparedStatement.setString(15, learnerInfo.getAddress3());
            preparedStatement.setString(16, learnerInfo.getAddressCode());
            preparedStatement.setString(17, learnerInfo.getGuardian());
            preparedStatement.setString(18, learnerInfo.getTel1Code());
            preparedStatement.setString(19, learnerInfo.getTel1());
            preparedStatement.setString(20, learnerInfo.getTel2Code());
            preparedStatement.setString(21, learnerInfo.getTel2());
            preparedStatement.setString(22, learnerInfo.getTel3Code());
            preparedStatement.setString(23, learnerInfo.getTel3());
            preparedStatement.setInt(24, learnerInfo.getGrade());
            preparedStatement.setInt(25, learnerInfo.getClazz());
            preparedStatement.setInt(26, learnerInfo.getGradeYears());
            preparedStatement.setString(27, learnerInfo.getPreviousSchool());
            preparedStatement.setString(28, learnerInfo.getSchoolAddress1());
            preparedStatement.setString(29, learnerInfo.getSchoolAddress2());
            preparedStatement.setString(30, learnerInfo.getSchoolAddress3());
            preparedStatement.setString(31, learnerInfo.getSchoolCode());
            preparedStatement.setString(32, learnerInfo.getReligion());
            preparedStatement.setString(33, learnerInfo.getDisciplinary());
            preparedStatement.setString(34, learnerInfo.getMedicalConditions());
            preparedStatement.setString(35, learnerInfo.getDrInfo());
            preparedStatement.setString(36, learnerInfo.getMedicalAidName());
            preparedStatement.setString(37, learnerInfo.getMedicalAidNo());
            preparedStatement.setString(38, learnerInfo.getMedicalAidMember());
            preparedStatement.setString(39, learnerInfo.getGuidance());
            preparedStatement.setString(40, learnerInfo.getInitials());
            preparedStatement.setString(41, learnerInfo.getCitizenship());
            preparedStatement.setString(42, learnerInfo.getProvincial());
            preparedStatement.setString(43, learnerInfo.getSchoolProvince());
            preparedStatement.setString(44, learnerInfo.getPreviousSchoolProvince());
            preparedStatement.setBoolean(45, learnerInfo.isAssignClass());
            preparedStatement.setString(46, learnerInfo.getPhysProvince());
            preparedStatement.setString(47, learnerInfo.getRace());
            preparedStatement.setString(48, learnerInfo.getTitle());
            preparedStatement.setInt(49, learnerInfo.getPreviousPlacementofSchool());
            preparedStatement.setInt(50, learnerInfo.getTransport());
            preparedStatement.setInt(51, learnerInfo.getLSENDisabilities());
            preparedStatement.setString(52, learnerInfo.getDateLeft());
            preparedStatement.setString(53, learnerInfo.getReason());
            preparedStatement.setInt(54, learnerInfo.getLSENStatus());
            preparedStatement.setString(55, learnerInfo.getStatus());
            preparedStatement.setInt(56, learnerInfo.getBoarder());
            preparedStatement.setString(57, learnerInfo.getCountryResidence());
            preparedStatement.setString(58, learnerInfo.getProvinceResidence());
            preparedStatement.setInt(59, learnerInfo.getFirstProvince());
            preparedStatement.setInt(60, learnerInfo.getDeceasedParent());
            preparedStatement.setInt(61, learnerInfo.getSGRegister());
            preparedStatement.setInt(62, learnerInfo.getSGReceive());
            preparedStatement.setString(63, learnerInfo.getDrName());
            preparedStatement.setString(64, learnerInfo.getDrTel());
            preparedStatement.setInt(65, learnerInfo.getDexterity());
            preparedStatement.setInt(66, learnerInfo.getPSNP());
            preparedStatement.setInt(67, learnerInfo.getNoFamily());
            preparedStatement.setString(68, learnerInfo.getPositionFamily());
            preparedStatement.setInt(69, learnerInfo.getReportLanguage());
            preparedStatement.setString(70, learnerInfo.getForeignID());
            preparedStatement.setString(71, learnerInfo.getLearnerComment());
            preparedStatement.setString(72, learnerInfo.getPhotoName());
            preparedStatement.setInt(73, learnerInfo.getGradeEntered());
            preparedStatement.setInt(74, learnerInfo.getGradeLeft());//
            preparedStatement.setString(75, learnerInfo.getBoarderNumber());
            preparedStatement.setString(76, learnerInfo.getBoarderHostel());
            preparedStatement.setString(77, learnerInfo.getThirdName());
            preparedStatement.setString(78, learnerInfo.getEmail());
            preparedStatement.setString(79, learnerInfo.getSocialGrantNo());
            preparedStatement.setInt(80, learnerInfo.getTSTransactionCategory());
            preparedStatement.setInt(81, learnerInfo.getTSStatusFlag());
            preparedStatement.setInt(82, learnerInfo.getTSReportStatusFlag());
            preparedStatement.setInt(83, learnerInfo.getTSReasonCode());
            preparedStatement.setInt(84, learnerInfo.getLuritsIndicator());
            preparedStatement.setInt(85, learnerInfo.getLuritsFlag());
            preparedStatement.setDouble(86, learnerInfo.getLuritsNumber());
            preparedStatement.setString(87, learnerInfo.getTSSentfileName());
            XMLGregorianCalendar tSDateLastUpdate = learnerInfo.getTSDateLastUpdate();
            if (tSDateLastUpdate == null) {
                preparedStatement.setNull(88, Types.DATE);
            } else {
                java.sql.Date convertedTSDateLastUpdate = dateUtil.getSQLDate(tSDateLastUpdate);
                preparedStatement.setDate(88, convertedTSDateLastUpdate);
            }
            preparedStatement.setString(89, learnerInfo.getTSLastUpdatedBy());
            preparedStatement.setString(90, learnerInfo.getLearnerName2());
            preparedStatement.setString(91, learnerInfo.getLearnerName3());
            preparedStatement.setString(92, learnerInfo.getNameDiacritics());
            preparedStatement.setString(93, learnerInfo.getOtherHomeLanguage());
            preparedStatement.setString(94, learnerInfo.getOtherLanguage());
            preparedStatement.setString(95, learnerInfo.getOtherPreferredLanguage());
            preparedStatement.setString(96, learnerInfo.getOtherTeachingLanguage());
            preparedStatement.setString(97, learnerInfo.getLuritsStatus());
            preparedStatement.setString(98, learnerInfo.getSecondName());
            preparedStatement.setString(99, learnerInfo.getPastelCode());
            preparedStatement.setInt(100, learnerInfo.getBusRouteId());
            preparedStatement.setString(101, learnerInfo.getSubjHL());
            preparedStatement.setString(102, learnerInfo.getSubjFAL());
            preparedStatement.setString(103, learnerInfo.getPrevSName());
            preparedStatement.setString(104, learnerInfo.getPositionFamilyF());
            preparedStatement.setInt(105, learnerInfo.getReasonForNoIDNo());
            preparedStatement.setInt(106, learnerInfo.getGrantCReg());
            preparedStatement.setInt(107, learnerInfo.getGrantCReceive());
            preparedStatement.setString(108, learnerInfo.getGrantCNo());
            preparedStatement.setInt(109, learnerInfo.getGrant4Reg());
            preparedStatement.setInt(110, learnerInfo.getGrant4Receive());
            preparedStatement.setString(111, learnerInfo.getGrant4No());
            preparedStatement.setInt(112, learnerInfo.getGrant5Reg());
            preparedStatement.setInt(113, learnerInfo.getGrant5Receive());
            preparedStatement.setString(114, learnerInfo.getGrant5No());
            preparedStatement.setInt(115, learnerInfo.getGrant9Reg());
            preparedStatement.setInt(116, learnerInfo.getGrant9Receive());
            preparedStatement.setString(117, learnerInfo.getGrant9No());
            preparedStatement.setString(118, learnerInfo.getClinicName());
            preparedStatement.setString(119, learnerInfo.getClinicAccRef());
            preparedStatement.setString(120, learnerInfo.getClinicTelCode());
            preparedStatement.setString(121, learnerInfo.getClinicTel());
            preparedStatement.setString(122, learnerInfo.getSubjLOI());
            preparedStatement.setInt(123, learnerInfo.getHseID());
            preparedStatement.setShort(124, learnerInfo.getPhaseYears());
            preparedStatement.setBoolean(125, learnerInfo.isProgressedToGrade());
            preparedStatement.setShort(126, learnerInfo.getStudyPermit());
            preparedStatement.setString(127, learnerInfo.getStudyPermitNo());
            preparedStatement.setString(128, learnerInfo.getStudyPermitDate());
            preparedStatement.setString(129, learnerInfo.getIDNoNotValidating());
            preparedStatement.setString(130, learnerInfo.getOldMentor());
            preparedStatement.setBoolean(131, learnerInfo.isLSENAnaInc());
            preparedStatement.setString(132, learnerInfo.getLSENAnaHL());
            preparedStatement.setString(133, learnerInfo.getLSENAnaFAL());
            preparedStatement.setInt(134, learnerInfo.getPreviousPlacementofSchoolYear());
            preparedStatement.setInt(135, learnerInfo.getForeignIDType());
            preparedStatement.setBoolean(136, learnerInfo.isAgeRuleOverwritten());
            preparedStatement.setInt(137, learnerInfo.getReasonForNoForeignID());
            preparedStatement.setString(138, learnerInfo.getFarmProj());
            preparedStatement.setBoolean(139, learnerInfo.isRoad2Health());
            preparedStatement.setBoolean(140, learnerInfo.isImmunizationCard());
            preparedStatement.setString(141, learnerInfo.getICEName());
            preparedStatement.setString(142, learnerInfo.getICESurname());
            preparedStatement.setString(143, learnerInfo.getICERelation());
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
