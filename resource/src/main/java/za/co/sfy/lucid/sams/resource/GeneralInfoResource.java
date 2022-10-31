package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateUtil;
import za.co.sfy.sams.lucid.schema.GeneralInfo;

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
public class GeneralInfoResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final DateUtil dateUtil = new DateUtil();
    private final String TABLE_NAME = "General_Info";

    public GeneralInfoResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    public ResultSet retrieveGeneralInfoBySchoolName(String schoolName) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE SchoolName = ? ";
        Connection connection = getDatabaseConnectionManager().retrieveDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, schoolName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve generalInfo by schoolName '" + schoolName + "' "
                    , exception);
        }
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        GeneralInfo generalInfo = (GeneralInfo) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(SchoolName, ProvincialDep, District, Region, Circuit, Address1," +
                " Address2, Address3, AddressCode, PostAddress1, PostAddress2, PostAddress3, PostCode, TelCode1, Telephone1," +
                " TelCode2, Telephone2, Telcode3, Telephone3, FaxCode, Fax, TSchool, TAdd1, TAdd2, TAdd3, TCode, ttelcode1," +
                " TTel1, Tfaxcode, TFax, TPrincipal, ContactPerson, EmisCode, EMail, PredominantLanguage, PersalPayPoint," +
                " PersalComponent, InternetAccess, Ownership, LandOwnership, Platoon, HostSchool, DoubleShifts, ExamAuthority," +
                " ExamCentre, ExamCentreNumber, Specialised, Specialisation, FeePeriod, FeeMonths, Multigrade, Remedial, " +
                "SGBStatus, MaintainProperty, ExtraMural, Textbooks, Services, Abet, OtherFunctions, CensusArea, ErfNumber," +
                " EmisHostSchool, HostTime, ExamAuthName, CorrespondenceLang, NearestTown, DistanceTown, DistrictCode," +
                " PostalAddressType, SchoolLevel, TSSchoolStatus, TSTransactionCategory, TSStatusFlag, TSReportStatusFlag," +
                " TSReasonCode, LuritsYear, TSSentFileName, TSDateLastUpdate, TSLastUpdatedBy, OwnerBuildings, LuritsIndicator," +
                " Telcode4, Telephone4, AdminComputers, PostAddress0, PostAddress0No, TEmisCode, UseMarksSecurity, PSNP," +
                " TSIncludesANA, LastDBCompact, IQMS_LastExpDate, IQMS_LastImpDate, ExamBoard, ExamBoardOther) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, generalInfo.getSchoolName());
            preparedStatement.setString(2, generalInfo.getProvincialDep());
            preparedStatement.setString(3, generalInfo.getDistrict());
            preparedStatement.setString(4, generalInfo.getRegion());
            preparedStatement.setString(5, generalInfo.getCircuit());
            preparedStatement.setString(6, generalInfo.getAddress1());
            preparedStatement.setString(7, generalInfo.getAddress2());
            preparedStatement.setString(8, generalInfo.getAddress3());
            preparedStatement.setString(9, generalInfo.getAddressCode());
            preparedStatement.setString(10, generalInfo.getPostAddress1());
            preparedStatement.setString(11, generalInfo.getPostAddress2());
            preparedStatement.setString(12, generalInfo.getPostAddress3());
            preparedStatement.setString(13, generalInfo.getPostCode());
            preparedStatement.setString(14, generalInfo.getTelCode1());
            preparedStatement.setString(15, generalInfo.getTelephone1());
            preparedStatement.setString(16, generalInfo.getTelCode2());
            preparedStatement.setString(17, generalInfo.getTelephone2());
            preparedStatement.setString(18, generalInfo.getTelcode3());
            preparedStatement.setString(19, generalInfo.getTelephone3());
            preparedStatement.setString(20, generalInfo.getFaxCode());
            preparedStatement.setString(21, generalInfo.getFax());
            preparedStatement.setString(22, generalInfo.getTSchool());
            preparedStatement.setString(23, generalInfo.getTAdd1());
            preparedStatement.setString(24, generalInfo.getTAdd2());
            preparedStatement.setString(25, generalInfo.getTAdd3());
            preparedStatement.setString(26, generalInfo.getTCode());
            preparedStatement.setString(27, generalInfo.getTtelcode1());
            preparedStatement.setString(28, generalInfo.getTTel1());
            preparedStatement.setString(29, generalInfo.getTfaxcode());
            preparedStatement.setString(30, generalInfo.getTFax());
            preparedStatement.setString(31, generalInfo.getTPrincipal());
            preparedStatement.setString(32, generalInfo.getContactPerson());
            preparedStatement.setString(33, generalInfo.getEmisCode());
            preparedStatement.setString(34, generalInfo.getEMail());
            preparedStatement.setInt(35, generalInfo.getPredominantLanguage());
            preparedStatement.setString(36, generalInfo.getPersalPayPoint());
            preparedStatement.setString(37, generalInfo.getPersalComponent());
            preparedStatement.setString(38, generalInfo.getInternetAccess());
            preparedStatement.setString(39, generalInfo.getOwnership());
            preparedStatement.setString(40, generalInfo.getLandOwnership());
            preparedStatement.setString(41, generalInfo.getPlatoon());
            preparedStatement.setString(42, generalInfo.getHostSchool());
            preparedStatement.setString(43, generalInfo.getDoubleShifts());
            preparedStatement.setString(44, generalInfo.getExamAuthority());
            preparedStatement.setString(45, generalInfo.getExamCentre());
            preparedStatement.setString(46, generalInfo.getExamCentreNumber());
            preparedStatement.setString(47, generalInfo.getSpecialised());
            preparedStatement.setString(48, generalInfo.getSpecialisation());
            preparedStatement.setString(49, generalInfo.getFeePeriod());
            preparedStatement.setInt(50, generalInfo.getFeeMonths());
            preparedStatement.setInt(51, generalInfo.getMultigrade());
            preparedStatement.setInt(52, generalInfo.getRemedial());
            preparedStatement.setString(53, generalInfo.getSGBStatus());
            preparedStatement.setBoolean(54, generalInfo.isMaintainProperty());
            preparedStatement.setBoolean(55, generalInfo.isExtraMural());
            preparedStatement.setBoolean(56, generalInfo.isTextbooks());
            preparedStatement.setBoolean(57, generalInfo.isServices());
            preparedStatement.setBoolean(58, generalInfo.isAbet());
            preparedStatement.setBoolean(59, generalInfo.isOtherFunctions());
            preparedStatement.setString(60, generalInfo.getCensusArea());
            preparedStatement.setString(61, generalInfo.getErfNumber());
            preparedStatement.setString(62, generalInfo.getEmisHostSchool());
            preparedStatement.setInt(63, generalInfo.getHostTime());
            preparedStatement.setString(64, generalInfo.getExamAuthName());
            preparedStatement.setInt(65, generalInfo.getCorrespondenceLang());
            preparedStatement.setString(66, generalInfo.getNearestTown());
            preparedStatement.setDouble(67, generalInfo.getDistanceTown());
            preparedStatement.setInt(68, generalInfo.getDistrictCode());
            preparedStatement.setString(69, generalInfo.getPostalAddressType());
            preparedStatement.setInt(70, generalInfo.getSchoolLevel());
            preparedStatement.setInt(71, generalInfo.getTSSchoolStatus());
            preparedStatement.setInt(72, generalInfo.getTSTransactionCategory());
            preparedStatement.setInt(73, generalInfo.getTSStatusFlag());
            preparedStatement.setInt(74, generalInfo.getTSReportStatusFlag());
            preparedStatement.setInt(75, generalInfo.getTSReasonCode());
            preparedStatement.setInt(76, generalInfo.getLuritsYear());
            preparedStatement.setString(77, generalInfo.getTSSentFileName());

            XMLGregorianCalendar tsDateLastUpdate = generalInfo.getTSDateLastUpdate();
            if (null != tsDateLastUpdate) {
                java.sql.Date tsDateLastUpdateSqlDate = dateUtil.toSQLDate(tsDateLastUpdate);
                preparedStatement.setDate(78, tsDateLastUpdateSqlDate);
            } else {
                preparedStatement.setNull(78, Types.DATE);
            }

            preparedStatement.setString(79, generalInfo.getTSLastUpdatedBy());
            preparedStatement.setString(80, generalInfo.getOwnerBuildings());
            preparedStatement.setInt(81, generalInfo.getLuritsIndicator());
            preparedStatement.setString(82, generalInfo.getTelcode4());
            preparedStatement.setString(83, generalInfo.getTelephone4());
            preparedStatement.setInt(84, generalInfo.getAdminComputers());
            preparedStatement.setString(85, generalInfo.getPostAddress0());
            preparedStatement.setString(86, generalInfo.getPostAddress0No());
            preparedStatement.setString(87, generalInfo.getTEmisCode());
            preparedStatement.setBoolean(88, generalInfo.isUseMarksSecurity());
            preparedStatement.setShort(89, generalInfo.getPSNP());
            preparedStatement.setShort(90, generalInfo.getTSIncludesANA());

            XMLGregorianCalendar lastDBCompactString = generalInfo.getLastDBCompact();
            if (null != lastDBCompactString) {
                java.sql.Date lastDBCompactSQLDate = dateUtil.toSQLDate(lastDBCompactString);
                preparedStatement.setDate(91, lastDBCompactSQLDate);
            } else {
                preparedStatement.setNull(91, Types.DATE);
            }

            XMLGregorianCalendar iqmsLastExpDateString = generalInfo.getIQMSLastExpDate();
            if (null != iqmsLastExpDateString) {
                java.sql.Date sqlIQMSLastExpDate = dateUtil.toSQLDate(iqmsLastExpDateString);
                preparedStatement.setDate(92, sqlIQMSLastExpDate);
            } else {
                preparedStatement.setNull(92, Types.DATE);
            }

            XMLGregorianCalendar iqmsLastImpDate = generalInfo.getIQMSLastImpDate();
            if (null != iqmsLastImpDate) {
                java.sql.Date sqlIQMSLastImpDate = dateUtil.toSQLDate(iqmsLastImpDate);
                preparedStatement.setDate(93, sqlIQMSLastImpDate);
            } else {
                preparedStatement.setNull(93, Types.DATE);
            }

            preparedStatement.setInt(94, generalInfo.getExamBoard());
            preparedStatement.setString(95, generalInfo.getExamBoardOther());
            //These fields exist in the table but don't seem to be utilised and they also don't exist in the 'general info' schema
            //preparedStatement.setInt(96, generalInfo.getMultigrade());   - Multigrades
            //preparedStatement.setString(97, "");                         - EmisOfficer
            //preparedStatement.setBoolean(98, false);                     - EmisOffEducator
            //preparedStatement.setString(99, "");                         - EmailAlt
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