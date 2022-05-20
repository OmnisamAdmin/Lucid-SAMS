package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.resource.connection.DatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateConverter;
import za.co.sfy.sams.lucid.schema.SchoolTerms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class SchoolTermsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "SchoolTerms";
    private final DateConverter dateConverter = new DateConverter();

    public SchoolTermsResource(DatabaseConnectionManager databaseConnectionManager) {
        super(databaseConnectionManager);
    }

    @Override
    public PreparedStatement retrieveSavePreparedStatement(Connection connection, Object object) throws SQLException {

        SchoolTerms schoolTerms = (SchoolTerms) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Quater,StartDate,EndDate,CurrentYear,Term) VALUES(?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, schoolTerms.getQuater());
        java.sql.Date startDate = dateConverter.getSQLDate(schoolTerms.getStartDate());
        java.sql.Date endDate = dateConverter.getSQLDate(schoolTerms.getEndDate());
        preparedStatement.setDate(2, startDate);
        preparedStatement.setDate(3, endDate);
        preparedStatement.setString(4, schoolTerms.getCurrentYear());
        preparedStatement.setInt(5, schoolTerms.getTerm());

        return preparedStatement;
    }

    @Override
    public PreparedStatement retrieveRetrievePreparedStatement(Connection connection, Object object) {
        return null;
    }

    @Override
    public PreparedStatement retrieveUpdatePreparedStatement(Connection connection, Object object) throws SQLException {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
