package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.MenuPlanRequest;
import za.co.sfy.sams.lucid.schema.MenuPlan;

/**
 * @author muzim
 */
@Component
public class MenuPlanMapper {

    public MenuPlan menuPlanRequestToMenuPlan(MenuPlanRequest menuPlanRequest) {

        MenuPlan menuPlan = new MenuPlan();

        menuPlan.setMealCD(menuPlanRequest.getMealCD());
        menuPlan.setMealType(menuPlanRequest.getMealType());
        menuPlan.setIngredients(menuPlanRequest.getIngredients());
        menuPlan.setDataYear(menuPlanRequest.getDataYear());
        menuPlan.setSchoolLevel(menuPlanRequest.getSchoolLevel());
        menuPlan.setMenuName(menuPlanRequest.getMenuName());
        menuPlan.setFeedingDay(menuPlanRequest.getFeedingDay());

        return menuPlan;
    }
}
