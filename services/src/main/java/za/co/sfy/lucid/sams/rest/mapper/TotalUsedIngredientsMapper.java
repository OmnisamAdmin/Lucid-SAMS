package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.TotalUsedIngredientsRequest;
import za.co.sfy.sams.lucid.schema.TotalUsedIngredients;

@Component
public class TotalUsedIngredientsMapper {

    public TotalUsedIngredients totalUsedIngredientsRequestToTotalUsedIngredients(TotalUsedIngredientsRequest totalUsedIngredientsRequest) {

        TotalUsedIngredients totalUsedIngredients = new TotalUsedIngredients();

        Integer id = totalUsedIngredientsRequest.getId();
        if (id != null) {
            totalUsedIngredients.setID(id);
        }
        totalUsedIngredients.setMealType(totalUsedIngredientsRequest.getMealType());
        totalUsedIngredients.setTotalLearnersPreparingFor(totalUsedIngredientsRequest.getTotalLearnersPreparingFor());
        totalUsedIngredients.setDataYear(totalUsedIngredientsRequest.getDataYear());
        totalUsedIngredients.setFeedingDay(totalUsedIngredientsRequest.getFeedingDay());
        totalUsedIngredients.setStarch(totalUsedIngredientsRequest.getStarch());
        totalUsedIngredients.setProtein(totalUsedIngredientsRequest.getProtein());
        totalUsedIngredients.setFruitOrVeg(totalUsedIngredientsRequest.getFruitOrVeg());
        totalUsedIngredients.setSeasoning(totalUsedIngredientsRequest.getSeasoning());
        totalUsedIngredients.setStarchqm(totalUsedIngredientsRequest.getStarchqm());
        totalUsedIngredients.setProteinqm(totalUsedIngredientsRequest.getProteinqm());
        totalUsedIngredients.setFruitOrVegqm(totalUsedIngredientsRequest.getFruitOrVegqm());
        totalUsedIngredients.setSeasoningqm(totalUsedIngredientsRequest.getSeasoningqm());

        return totalUsedIngredients;
    }
}
