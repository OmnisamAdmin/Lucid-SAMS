package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class StoreQuantiesRequest implements Serializable {

    private static final long serialVersionUID = -8176569659095036586L;

    private Integer id;
    @NotBlank
    private String productName;
    @NotNull
    private Integer quantity;
    @NotNull
    private Integer dataYear;
    @NotBlank
    private String dateStocktaking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDataYear() {
        return dataYear;
    }

    public void setDataYear(Integer dataYear) {
        this.dataYear = dataYear;
    }

    public String getDateStocktaking() {
        return dateStocktaking;
    }

    public void setDateStocktaking(String dateStocktaking) {
        this.dateStocktaking = dateStocktaking;
    }
}
