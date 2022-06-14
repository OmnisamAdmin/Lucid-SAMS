package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateConverter;
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
    private final DateConverter dateConverter = new DateConverter();

    public ParentInfoResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    public ResultSet retrieveParentInfoByID(Long parentID) throws LucidSamsExecutionException {

        String sql = "SELECT + FROM " + TABLE_NAME + " ParentID = ?";
        Connection connection = getDatabaseConnectionManager().createDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Math.toIntExact(parentID));
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve parentInfo of id '" + parentID + "' :"
                    + exception.getMessage());
        }
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {

        ParentInfo parentInfo = (ParentInfo) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(parentID, initials, fName, sName, title, employer, occupation," +
                " streetAddress1, streetAddress2, streetAddress3, streetCode, postalAddress1, postalAddress2, postalAddress3" +
                ", postalCode, tel1Code, tel1, tel2Code, tel2, tel3Code, tel3, eMail, govBody, parentsAss, poverty, id" +
                ", relship, idNumber, accPayer, custodial, gender, race, homelanguage, corrTitle, corrSurname, spouse" +
                ", faxCode, faxNo, spouseOccupation, spouseWorkTel, status, spouseGender, spouseFname, spouseCell, spouseEmail" +
                ", spouseID, maritalstatus, archiveDate, archiveReason, birthDate, reasonNoID, religion) " +
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
                java.sql.Date convertedTSDateLastUpdate = dateConverter.getSQLDate(archiveDate);
                preparedStatement.setDate(48, convertedTSDateLastUpdate);
            }
            preparedStatement.setString(49, parentInfo.getArchiveReason());
            preparedStatement.setString(50, parentInfo.getBirthDate());
            preparedStatement.setString(51, parentInfo.getReasonNoID());
            preparedStatement.setString(52, parentInfo.getReligion());
            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve save prepared statement: "
                    + exception.getMessage(), exception);
        }
    }

    @Override
    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public PreparedStatement retrieveUpdatePreparedStatement(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
