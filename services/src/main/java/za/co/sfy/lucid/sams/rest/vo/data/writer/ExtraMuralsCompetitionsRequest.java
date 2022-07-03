package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ExtraMuralsCompetitionsRequest implements Serializable {

    private static final long serialVersionUID = 9032223193554668116L;

    private Integer compID;
    @NotNull
    private Integer exID;
    @NotBlank
    private String compName;
    private String compAfrName;
    private byte[] compPicture;
    private Integer compOfficialID;
    @NotNull
    private Boolean recSelected;
    @NotNull
    private Boolean recLocked;

    public Integer getCompID() {
        return compID;
    }

    public void setCompID(Integer compID) {
        this.compID = compID;
    }

    public Integer getExID() {
        return exID;
    }

    public void setExID(Integer exID) {
        this.exID = exID;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompAfrName() {
        return compAfrName;
    }

    public void setCompAfrName(String compAfrName) {
        this.compAfrName = compAfrName;
    }

    public byte[] getCompPicture() {
        return compPicture;
    }

    public void setCompPicture(byte[] compPicture) {
        this.compPicture = compPicture;
    }

    public Integer getCompOfficialID() {
        return compOfficialID;
    }

    public void setCompOfficialID(Integer compOfficialID) {
        this.compOfficialID = compOfficialID;
    }

    public Boolean isRecSelected() {
        return recSelected;
    }

    public void setRecSelected(Boolean recSelected) {
        this.recSelected = recSelected;
    }

    public Boolean isRecLocked() {
        return recLocked;
    }

    public void setRecLocked(Boolean recLocked) {
        this.recLocked = recLocked;
    }
}
