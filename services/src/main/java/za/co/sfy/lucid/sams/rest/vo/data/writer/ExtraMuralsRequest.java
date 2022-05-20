package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ExtraMuralsRequest implements Serializable {

    private static final long serialVersionUID = 4818545469405095677L;

    private int exID;
    @NotNull
    private Integer exTypeID;
    @NotNull
    private String exName;
    private String exAfrName;
    private String exPicKey;
    private byte[] exPicture;
    @NotNull
    private Integer exOfficialID;
    @NotNull
    private boolean recSelected;
    @NotNull
    private boolean recLocked;

    public int getExID() {
        return exID;
    }

    public void setExID(int exID) {
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

    public byte[] getExPicture() {
        return exPicture;
    }

    public void setExPicture(byte[] exPicture) {
        this.exPicture = exPicture;
    }

    public Integer getExOfficialID() {
        return exOfficialID;
    }

    public void setExOfficialID(Integer exOfficialID) {
        this.exOfficialID = exOfficialID;
    }

    public boolean isRecSelected() {
        return recSelected;
    }

    public void setRecSelected(boolean recSelected) {
        this.recSelected = recSelected;
    }

    public boolean isRecLocked() {
        return recLocked;
    }

    public void setRecLocked(boolean recLocked) {
        this.recLocked = recLocked;
    }
}
