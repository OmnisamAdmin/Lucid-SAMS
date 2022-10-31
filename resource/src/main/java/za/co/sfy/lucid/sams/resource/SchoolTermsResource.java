package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateUtil;
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
    private final DateUtil dateUtil = new DateUtil();

    public SchoolTermsResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        SchoolTerms schoolTerms = (SchoolTerms) object;

        String sql = "INSERT INTO " + TABLE_NAME + "(Quater,StartDate,EndDate,CurrentYear,Term) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, schoolTerms.getQuater());
            java.sql.Date startDate = dateUtil.toSQLDate(schoolTerms.getStartDate());
            java.sql.Date endDate = dateUtil.toSQLDate(schoolTerms.getEndDate());
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, endDate);
            preparedStatement.setString(4, schoolTerms.getCurrentYear());
            preparedStatement.setInt(5, schoolTerms.getTerm());
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