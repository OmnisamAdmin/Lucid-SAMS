package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.CycleInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class CycleInfoResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Cycleinfo";

    public CycleInfoResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    public ResultSet retrieveGrades() throws LucidSamsExecutionException, SQLException {

        String sql = "SELECT LowestGrade,HighestGrade FROM " + TABLE_NAME;
        Connection connection = getDatabaseConnectionManager().createDatabaseConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException {

        CycleInfo CycleInfo = (CycleInfo) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Schoolname, FETDays, Rooms, FETPeriods, LowestGrade, HighestGrade," +
                " FETlength, LSEN, Remedial, FETTotal, GETDays, GETPeriods, GETLength, GETTotal, LSENSchool, SNESpec, " +
                "SNESpecOther, SchoolType, MultiGrade, SID, SIDLowestYear, SIDHighestYear) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, CycleInfo.getSchoolname());
        preparedStatement.setInt(2, CycleInfo.getFETDays());
        preparedStatement.setInt(3, CycleInfo.getRooms());
        preparedStatement.setInt(4, CycleInfo.getFETPeriods());
        preparedStatement.setInt(5, CycleInfo.getLowestGrade());
        preparedStatement.setInt(6, CycleInfo.getHighestGrade());
        preparedStatement.setInt(7, CycleInfo.getFETlength());
        preparedStatement.setString(8, CycleInfo.getLSEN());
        preparedStatement.setString(9, CycleInfo.getRemedial());
        preparedStatement.setInt(10, CycleInfo.getFETTotal());
        preparedStatement.setInt(11, CycleInfo.getGETDays());
        preparedStatement.setInt(12, CycleInfo.getGETPeriods());
        preparedStatement.setInt(13, CycleInfo.getGETLength());
        preparedStatement.setInt(14, CycleInfo.getGETTotal());
        preparedStatement.setBoolean(15, CycleInfo.isLSENSchool());
        preparedStatement.setInt(16, CycleInfo.getSNESpec());
        preparedStatement.setString(17, CycleInfo.getSNESpecOther());
        preparedStatement.setInt(18, CycleInfo.getSchoolType());
        preparedStatement.setString(19, CycleInfo.getMultiGrade());
        preparedStatement.setString(20, CycleInfo.getSID());
        preparedStatement.setInt(21, CycleInfo.getSIDLowestYear());
        preparedStatement.setInt(22, CycleInfo.getSIDLowestYear());

        return preparedStatement;
    }

    @Override
    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object) {
        return null;
    }

    @Override
    public PreparedStatement retrieveUpdatePreparedStatement(Connection connection, Object object) {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

}
