package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateUtil;
import za.co.sfy.sams.lucid.schema.ParentInfo;

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
public class ParentInfoResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Parent_Info";
    private final DateUtil dateUtil = new DateUtil();

    public ParentInfoResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    public ResultSet retrieveParentInfoByID(Long parentID) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE ParentID = ?";
        Connection connection = getDatabaseConnectionManager().getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Math.toIntExact(parentID));
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve parentInfo of id '" + parentID + "' :", exception);
        }
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        ParentInfo parentInfo = (ParentInfo) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(ParentID, Initials, FName, SName, Title, Employer, Occupation," +
                " StreetAddress1, StreetAddress2, StreetAddress3, StreetCode, PostalAddress1, PostalAddress2, PostalAddress3" +
                ", PostalCode, Tel1Code, Tel1, Tel2Code, Tel2, Tel3Code, Tel3, EMail, GovBody, ParentsAss, Poverty, ID" +
                ", Relship, IDNumber, AccPayer, Custodial, Gender, Race, Homelanguage, CorrTitle, CorrSurname, Spouse" +
                ", FaxCode, FaxNo, SpouseOccupation, SpouseWorkTel, Status, SpouseGender, SpouseFname, SpouseCell, SpouseEmail" +
                ", SpouseID, Maritalstatus, Archive_Date, Archive_Reason, BirthDate, ReasonNoID, Religion) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, parentInfo.getParentID());
            preparedStatement.setString(2, parentInfo.getInitials());
            preparedStatement.setString(3, parentInfo.getFName());
            preparedStatement.setString(4, parentInfo.getSName());
            preparedStatement.setString(5, parentInfo.getTitle());
            preparedStatement.setString(6, parentInfo.getEmployer());
            preparedStatement.setString(7, parentInfo.getOccupation());
            preparedStatement.setString(8, parentInfo.getStreetAddress1());
            preparedStatement.setString(9, parentInfo.getStreetAddress2());
            preparedStatement.setString(10, parentInfo.getStreetAddress3());
            preparedStatement.setString(11, parentInfo.getStreetCode());
            preparedStatement.setString(12, parentInfo.getPostalAddress1());
            preparedStatement.setString(13, parentInfo.getPostalAddress2());
            preparedStatement.setString(14, parentInfo.getPostalAddress3());
            preparedStatement.setString(15, parentInfo.getPostalCode());
            preparedStatement.setString(16, parentInfo.getTel1Code());
            preparedStatement.setString(17, parentInfo.getTel1());
            preparedStatement.setString(18, parentInfo.getTel2Code());
            preparedStatement.setString(19, parentInfo.getTel2());
            preparedStatement.setString(20, parentInfo.getTel3Code());
            preparedStatement.setString(21, parentInfo.getTel3());
            preparedStatement.setString(22, parentInfo.getEMail());
            preparedStatement.setString(23, parentInfo.getGovBody());
            preparedStatement.setString(24, parentInfo.getParentsAss());
            preparedStatement.setString(25, parentInfo.getPoverty());
            preparedStatement.setString(26, parentInfo.getID());
            preparedStatement.setString(27, parentInfo.getRelship());
            preparedStatement.setString(28, parentInfo.getIDNumber());
            preparedStatement.setString(29, parentInfo.getAccPayer());
            preparedStatement.setString(30, parentInfo.getCustodial());
            preparedStatement.setString(31, parentInfo.getGender());
            preparedStatement.setString(32, parentInfo.getRace());
            preparedStatement.setString(33, parentInfo.getHomelanguage());
            preparedStatement.setString(34, parentInfo.getCorrTitle());
            preparedStatement.setString(35, parentInfo.getCorrSurname());
            preparedStatement.setString(36, parentInfo.getSpouse());
            preparedStatement.setString(37, parentInfo.getFaxCode());
            preparedStatement.setString(38, parentInfo.getFaxNo());
            preparedStatement.setString(39, parentInfo.getSpouseOccupation());
            preparedStatement.setString(40, parentInfo.getSpouseWorkTel());
            preparedStatement.setString(41, parentInfo.getStatus());
            preparedStatement.setString(42, parentInfo.getSpouseGender());
            preparedStatement.setString(43, parentInfo.getSpouseFname());
            preparedStatement.setString(44, parentInfo.getSpouseCell());
            preparedStatement.setString(45, parentInfo.getSpouseEmail());
            preparedStatement.setString(46, parentInfo.getSpouseID());
            preparedStatement.setString(47, parentInfo.getMaritalstatus());
            XMLGregorianCalendar archiveDate = parentInfo.getArchiveDate();
            if (archiveDate == null) {
                preparedStatement.setNull(48, Types.DATE);
            } else {
                java.sql.Date convertedTSDateLastUpdate = dateUtil.getSQLDate(archiveDate);
                preparedStatement.setDate(48, convertedTSDateLastUpdate);
            }
            preparedStatement.setString(49, parentInfo.getArchiveReason());
            preparedStatement.setString(50, parentInfo.getBirthDate());
            preparedStatement.setString(51, parentInfo.getReasonNoID());
            preparedStatement.setString(52, parentInfo.getReligion());
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
