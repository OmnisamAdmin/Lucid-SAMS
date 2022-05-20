package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ExtraMuralsTypesRequest implements Serializable {

    private static final long serialVersionUID = -4006021326140192834L;

    private int exTypeID;
    @NotNull
    private String exTypeName;
    private String exTypeAfrName;
    private String exTypeShortName;
    private String exTypeShortAfrName;
    private String exTypePicKey;
    private byte[] exTypePicture;
    @NotNull
    private Integer exTypeOfficialID;
    @NotNull
    private boolean recSelected;
    @NotNull
    private boolean recLocked;

    public int getExTypeID() {
        return exTypeID;
    }

    public void setExTypeID(int exTypeID) {
        this.exTypeID = exTypeID;
    }

    public String getExTypeName() {
        return exTypeName;
    }

    public void setExTypeName(String exTypeName) {
        this.exTypeName = exTypeName;
    }

    public String getExTypeAfrName() {
        return exTypeAfrName;
    }

    public void setExTypeAfrName(String exTypeAfrName) {
        this.exTypeAfrName = exTypeAfrName;
    }

    public String getExTypeShortName() {
        return exTypeShortName;
    }

    public void setExTypeShortName(String exTypeShortName) {
        this.exTypeShortName = exTypeShortName;
    }

    public String getExTypeShortAfrName() {
        return exTypeShortAfrName;
    }

    public void setExTypeShortAfrName(String exTypeShortAfrName) {
        this.exTypeShortAfrName = exTypeShortAfrName;
    }

    public String getExTypePicKey() {
        return exTypePicKey;
    }

    public void setExTypePicKey(String exTypePicKey) {
        this.exTypePicKey = exTypePicKey;
    }

    public byte[] getExTypePicture() {
        return exTypePicture;
    }

    public void setExTypePicture(byte[] exTypePicture) {
        this.exTypePicture = exTypePicture;
    }

    public Integer getExTypeOfficialID() {
        return exTypeOfficialID;
    }

    public void setExTypeOfficialID(Integer exTypeOfficialID) {
        this.exTypeOfficialID = exTypeOfficialID;
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
