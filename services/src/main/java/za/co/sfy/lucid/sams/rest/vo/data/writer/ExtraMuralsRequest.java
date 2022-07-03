package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ExtraMuralsRequest implements Serializable {

    private static final long serialVersionUID = -614292038721393562L;

    private Integer exID;
    @NotNull
    private Integer exTypeID;
    @NotBlank
    private String exName;
    private String exAfrName;
    private String exPicKey;
    private String exPicture;
    private Integer exOfficialID;
    @NotNull
    private Boolean recSelected;
    @NotNull
    private Boolean recLocked;

    public Integer getExID() {
        return exID;
    }

    public void setExID(Integer exID) {
        this.exID = exID;
    }

    public Integer getExTypeID() {
        return exTypeID;
    }

    public void setExTypeID(Integer exTypeID) {
        this.exTypeID = exTypeID;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getExAfrName() {
        return exAfrName;
    }

    public void setExAfrName(String exAfrName) {
        this.exAfrName = exAfrName;
    }

    public String getExPicKey() {
        return exPicKey;
    }

    public void setExPicKey(String exPicKey) {
        this.exPicKey = exPicKey;
    }

    public String getExPicture() {
        return exPicture;
    }

    public void setExPicture(String exPicture) {
        this.exPicture = exPicture;
    }

    public Integer getExOfficialID() {
        return exOfficialID;
    }

    public void setExOfficialID(Integer exOfficialID) {
        this.exOfficialID = exOfficialID;
    }

    public Boolean getRecSelected() {
        return recSelected;
    }

    public void setRecSelected(Boolean recSelected) {
        this.recSelected = recSelected;
    }

    public Boolean getRecLocked() {
        return recLocked;
    }

    public void setRecLocked(Boolean recLocked) {
        this.recLocked = recLocked;
    }
}
