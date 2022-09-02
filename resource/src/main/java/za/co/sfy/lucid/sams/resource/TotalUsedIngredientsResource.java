package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.NSNPDatabaseConnectionManager;
import za.co.sfy.sams.lucid.schema.TotalUsedIngredients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class TotalUsedIngredientsResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {

    private final String TABLE_NAME = "Total_Used_Ingredients";

    public TotalUsedIngredientsResource(NSNPDatabaseConnectionManager nsnpDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(nsnpDatabaseConnectionManager);
    }

    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {

        TotalUsedIngredients totalUsedIngredients = (TotalUsedIngredients) object;
        String sql = "INSERT INTO " + TABLE_NAME + "(Meal_type,Total_learners_Preparing_For,Data_Year" +
                ",Feeding_Day,Starch,Protein,FruitOrVeg,Seasoning,Starchqm,Proteinqm,FruitOrVegqm,Seasoningqm) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, totalUsedIngredients.getMealType());
            preparedStatement.setString(2, totalUsedIngredients.getTotalLearnersPreparingFor());
            preparedStatement.setInt(3, totalUsedIngredients.getDataYear());
            preparedStatement.setString(4, totalUsedIngredients.getFeedingDay());
            preparedStatement.setString(5, totalUsedIngredients.getStarch());
            preparedStatement.setString(6, totalUsedIngredients.getProtein());
            preparedStatement.setString(7, totalUsedIngredients.getFruitOrVeg());
            preparedStatement.setString(8,totalUsedIngredients.getSeasoning());
            preparedStatement.setString(9,totalUsedIngredients.getStarchqm());
            preparedStatement.setString(10,totalUsedIngredients.getProteinqm());
            preparedStatement.setString(11,totalUsedIngredients.getFruitOrVegqm());
            preparedStatement.setString(12,totalUsedIngredients.getSeasoningqm());

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
