package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateConverter;
import za.co.sfy.sams.lucid.schema.EducatorCalendarTerms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EducatorCalendarTermsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final DateConverter dateConverter = new DateConverter();
    private final String TABLE_NAME = "Educator_CalendarTerms";

    public EducatorCalendarTermsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        EducatorCalendarTerms educatorCalendarTerms = (EducatorCalendarTerms) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Quater,StartDate,EndDate,CurrentYear,Term) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, educatorCalendarTerms.getQuater());
            preparedStatement.setDate(2, dateConverter.getSQLDate(educatorCalendarTerms.getStartDate()));
            preparedStatement.setDate(3, dateConverter.getSQLDate(educatorCalendarTerms.getEndDate()));
            preparedStatement.setString(4, educatorCalendarTerms.getCurrentYear());
            preparedStatement.setInt(5, educatorCalendarTerms.getTerm());
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

    public ResultSet retrieveEducatorCalendarTermsByYear(String currentYear) throws LucidSamsExecutionException {

        String sql = "SELECT * FROM " + TABLE_NAME + " Where CurrentYear = ?";
        Connection connection = getDatabaseConnectionManager().createDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, currentYear);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve EducatorCalendarTerms for year '" + currentYear + "' :"
                    , exception);
        }
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
