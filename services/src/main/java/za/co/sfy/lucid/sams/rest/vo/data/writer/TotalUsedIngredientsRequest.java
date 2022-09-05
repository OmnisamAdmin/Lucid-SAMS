package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TotalUsedIngredientsRequest implements Serializable {

    private static final long serialVersionUID = 2832165122348077079L;

    private Integer id;
    @NotBlank
    private String mealType;
    @NotBlank
    private String totalLearnersPreparingFor;
    @NotNull
    private Integer dataYear;
    @NotBlank
    private String feedingDay;
    @NotBlank
    private String starch;
    @NotBlank
    private String protein;
    @NotBlank
    private String fruitOrVeg;
    @NotBlank
    private String seasoning;
    @NotBlank
    private String starchqm;
    @NotBlank
    private String proteinqm;
    @NotBlank
    private String fruitOrVegqm;
    @NotBlank
    private String seasoningqm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getTotalLearnersPreparingFor() {
        return totalLearnersPreparingFor;
    }

    public void setTotalLearnersPreparingFor(String totalLearnersPreparingFor) {
        this.totalLearnersPreparingFor = totalLearnersPreparingFor;
    }

    public Integer getDataYear() {
        return dataYear;
    }

    public void setDataYear(Integer dataYear) {
        this.dataYear = dataYear;
    }

    public String getFeedingDay() {
        return feedingDay;
    }

    public void setFeedingDay(String feedingDay) {
        this.feedingDay = feedingDay;
    }

    public String getStarch() {
        return starch;
    }

    public void setStarch(String starch) {
        this.starch = starch;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFruitOrVeg() {
        return fruitOrVeg;
    }

    public void setFruitOrVeg(String fruitOrVeg) {
        this.fruitOrVeg = fruitOrVeg;
    }

    public String getSeasoning() {
        return seasoning;
    }

    public void setSeasoning(String seasoning) {
        this.seasoning = seasoning;
    }

    public String getStarchqm() {
        return starchqm;
    }

    public void setStarchqm(String starchqm) {
        this.starchqm = starchqm;
    }

    public String getProteinqm() {
        return proteinqm;
    }

    public void setProteinqm(String proteinqm) {
        this.proteinqm = proteinqm;
    }

    public String getFruitOrVegqm() {
        return fruitOrVegqm;
    }

    public void setFruitOrVegqm(String fruitOrVegqm) {
        this.fruitOrVegqm = fruitOrVegqm;
    }

    public String getSeasoningqm() {
        return seasoningqm;
    }

    public void setSeasoningqm(String seasoningqm) {
        this.seasoningqm = seasoningqm;
    }
}
