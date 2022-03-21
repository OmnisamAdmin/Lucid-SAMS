package za.co.sfy.lucid.sams.rest.vo.data.writer;

import java.io.Serializable;

public class ParentChildRequest implements Serializable {

    private static final long serialVersionUID = -6570473013136130185L;

    private Integer parentId;
    private Integer childId;
    private String learnerid;
    private boolean accPayer;
    private String status;
    private String resides;
    private String familyCode;
    private String pastelCustomerAccountDescription;
    private Integer pastelCustomerCategoryCode;
    private String pastelContact;
    private String sgbReg;
    private String relation;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getLearnerid() {
        return learnerid;
    }

    public void setLearnerid(String learnerid) {
        this.learnerid = learnerid;
    }

    public boolean isAccPayer() {
        return accPayer;
    }

    public void setAccPayer(boolean accPayer) {
        this.accPayer = accPayer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResides() {
        return resides;
    }

    public void setResides(String resides) {
        this.resides = resides;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    public String getPastelCustomerAccountDescription() {
        return pastelCustomerAccountDescription;
    }

    public void setPastelCustomerAccountDescription(String pastelCustomerAccountDescription) {
        this.pastelCustomerAccountDescription = pastelCustomerAccountDescription;
    }

    public Integer getPastelCustomerCategoryCode() {
        return pastelCustomerCategoryCode;
    }

    public void setPastelCustomerCategoryCode(Integer pastelCustomerCategoryCode) {
        this.pastelCustomerCategoryCode = pastelCustomerCategoryCode;
    }

    public String getPastelContact() {
        return pastelContact;
    }

    public void setPastelContact(String pastelContact) {
        this.pastelContact = pastelContact;
    }

    public String getSgbReg() {
        return sgbReg;
    }

    public void setSgbReg(String sgbReg) {
        this.sgbReg = sgbReg;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
