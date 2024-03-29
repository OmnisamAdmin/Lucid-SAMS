package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateUtil;
import za.co.sfy.sams.lucid.schema.StaffLeave;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class StaffLeaveResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "StaffLeave";
    private final DateUtil dateUtil = new DateUtil();

    public StaffLeaveResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        StaffLeave staffLeave = (StaffLeave) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(LinkId,DateStart,DateEnd,Type,Days,Comment,PersonnelCategory,Year" +
                ",Replaced,Paid,Documentation,LeaveDocRequired,WeekID,TmpField) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, staffLeave.getLinkId());
            preparedStatement.setDate(2, dateUtil.toSQLDate(staffLeave.getDateStart()));
            preparedStatement.setDate(3, dateUtil.toSQLDate(staffLeave.getDateEnd()));
            preparedStatement.setString(4, staffLeave.getType());
            preparedStatement.setInt(5, staffLeave.getDays());
            preparedStatement.setString(6, staffLeave.getComment());
            preparedStatement.setString(7, staffLeave.getPersonnelCategory());
            preparedStatement.setString(8, staffLeave.getYear());
            preparedStatement.setString(9, staffLeave.getReplaced());
            preparedStatement.setString(10, staffLeave.getPaid());
            preparedStatement.setString(11, staffLeave.getDocumentation());
            preparedStatement.setBoolean(12, staffLeave.isLeaveDocRequired());
            preparedStatement.setDate(13, dateUtil.toSQLDate(staffLeave.getWeekID()));
            preparedStatement.setString(14, staffLeave.getTmpField());

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