package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.NSNPDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.MenuPlan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class MenuPlanResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Menu_Plan";

    public MenuPlanResource(NSNPDatabaseConnectionManager nsnpDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(nsnpDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        MenuPlan menuPlan = (MenuPlan) object;
        String sql = "INSERT INTO " + TABLE_NAME + "(MealType,Ingredients,DataYear,SchoolLevel,MenuName,FeedingDay) " +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, menuPlan.getMealType());
            preparedStatement.setString(2, menuPlan.getIngredients());
            preparedStatement.setInt(3, menuPlan.getDataYear());
            preparedStatement.setString(4, menuPlan.getSchoolLevel());
            preparedStatement.setString(5, menuPlan.getMenuName());
            preparedStatement.setString(6, menuPlan.getFeedingDay());

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
