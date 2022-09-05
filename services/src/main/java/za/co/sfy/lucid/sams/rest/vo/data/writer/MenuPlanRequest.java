package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MenuPlanRequest implements Serializable {

    private static final long serialVersionUID = 4664209398192364346L;

    private Integer mealCD;
    @NotBlank
    private String mealType;
    @NotBlank
    private String ingredients;
    @NotNull
    private Integer dataYear;
    @NotBlank
    private String schoolLevel;
    @NotBlank
    private String menuName;
    @NotBlank
    private String feedingDay;

    public Integer getMealCD() {
        return mealCD;
    }

    public void setMealCD(Integer mealCD) {
        this.mealCD = mealCD;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getDataYear() {
        return dataYear;
    }

    public void setDataYear(Integer dataYear) {
        this.dataYear = dataYear;
    }

    public String getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(String schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getFeedingDay() {
        return feedingDay;
    }

    public void setFeedingDay(String feedingDay) {
        this.feedingDay = feedingDay;
    }
}
