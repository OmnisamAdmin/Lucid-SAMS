package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateConverter;
import za.co.sfy.sams.lucid.schema.DisciplinaryRecords;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

@Component
public class DisciplinaryRecordsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "DisciplinaryRecords";
    private final DateConverter dateConverter = new DateConverter();

    public DisciplinaryRecordsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        String sql = "INSERT INTO " + TABLE_NAME + "(Learnerid,Date,Comment,LevelMisconduct,MisconductCode" +
                ",MisconductDescription,ActionLevel,ActionCode,ActionDescription,DisciplinedBy,AuthorisedBy,Agency" +
                ",Suspension,Option,ExpulsionDate,Month,RecommendedExpulsion,Datayear,Demerit,Merit,Type) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        DisciplinaryRecords disciplinaryRecords = (DisciplinaryRecords) object;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Integer learnerID = disciplinaryRecords.getLearnerid();
            preparedStatement.setInt(1, learnerID);

            java.sql.Date date = dateConverter.getSQLDate(disciplinaryRecords.getDate());
            preparedStatement.setDate(2, date);

            String comment = disciplinaryRecords.getComment();
            preparedStatement.setString(3, comment);

            String levelMisconduct = disciplinaryRecords.getLevelMisconduct();
            preparedStatement.setString(4, levelMisconduct);

            String misconductCode = disciplinaryRecords.getMisconductCode();
            preparedStatement.setString(5, misconductCode);

            String misconductDescription = disciplinaryRecords.getMisconductDescription();
            preparedStatement.setString(6, misconductDescription);

            String actionLevel = disciplinaryRecords.getActionLevel();
            preparedStatement.setString(7, actionLevel);

            String actionCode = disciplinaryRecords.getActionCode();
            preparedStatement.setString(8, actionCode);

            String actionDescription = disciplinaryRecords.getActionDescription();
            preparedStatement.setString(9, actionDescription);

            String disciplinedBy = disciplinaryRecords.getDisciplinedBy();
            preparedStatement.setString(10, disciplinedBy);

            String authorisedBy = disciplinaryRecords.getAuthorisedBy();
            preparedStatement.setString(11, authorisedBy);

            String agency = disciplinaryRecords.getAgency();
            preparedStatement.setString(12, agency);

            Integer suspension = disciplinaryRecords.getSuspension();
            preparedStatement.setInt(13, suspension);

            String option = disciplinaryRecords.getOption();
            preparedStatement.setString(14, option);

            String expulsionDate = disciplinaryRecords.getExpulsionDate();
            preparedStatement.setString(15, expulsionDate);

            String month = disciplinaryRecords.getMonth();
            preparedStatement.setString(16, month);

            String recommendedExpulsion = disciplinaryRecords.getRecommendedExpulsion();
            preparedStatement.setString(17, recommendedExpulsion);

            String dataYear = disciplinaryRecords.getDatayear();
            preparedStatement.setString(18, dataYear);

            Integer demerit = disciplinaryRecords.getDemerit();
            if (null == demerit) {
                preparedStatement.setNull(19, Types.INTEGER);
            } else {
                preparedStatement.setInt(19, demerit);
            }

            Integer merit = disciplinaryRecords.getMerit();
            if (null == merit) {
                preparedStatement.setNull(20, Types.INTEGER);
            } else {
                preparedStatement.setInt(20, merit);
            }

            String type = disciplinaryRecords.getType();
            preparedStatement.setString(21, type);

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
