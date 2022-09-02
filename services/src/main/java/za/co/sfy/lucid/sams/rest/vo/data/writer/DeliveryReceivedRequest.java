package za.co.sfy.lucid.sams.rest.vo.data.writer;

import java.io.Serializable;

public class DeliveryReceivedRequest implements Serializable {

    private static final long serialVersionUID = 6199323699418307058L;

    private Integer id;
    private String supplier;
    private String dateRecieved;
    private String productName;
    private Integer aprovedQuantity;
    private Integer quantityOrdered;
    private Integer quantity;
    private Integer foodGroup;
    private Integer dataYear;
    private Integer leftQuantity;
    private Integer instore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDateRecieved() {
        return dateRecieved;
    }

    public void setDateRecieved(String dateRecieved) {
        this.dateRecieved = dateRecieved;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAprovedQuantity() {
        return aprovedQuantity;
    }

    public void setAprovedQuantity(Integer aprovedQuantity) {
        this.aprovedQuantity = aprovedQuantity;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(Integer foodGroup) {
        this.foodGroup = foodGroup;
    }

    public Integer getDataYear() {
        return dataYear;
    }

    public void setDataYear(Integer dataYear) {
        this.dataYear = dataYear;
    }

    public Integer getLeftQuantity() {
        return leftQuantity;
    }

    public void setLeftQuantity(Integer leftQuantity) {
        this.leftQuantity = leftQuantity;
    }

    public Integer getInstore() {
        return instore;
    }

    public void setInstore(Integer instore) {
        this.instore = instore;
    }
}
