package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ExtraMuralsHousesRequest implements Serializable {

    private static final long serialVersionUID = 3543995406192192945L;

    private int hseID;
    @NotNull
    private String hseName;
    private String hseAfrName;
    @NotNull
    private String hseColour;
    private String hseAfrColour;
    private byte[] hsePicture;
    @NotNull
    private boolean recSelected;

    public int getHseID() {
        return hseID;
    }

    public void setHseID(int hseID) {
        this.hseID = hseID;
    }

    public String getHseName() {
        return hseName;
    }

    public void setHseName(String hseName) {
        this.hseName = hseName;
    }

    public String getHseAfrName() {
        return hseAfrName;
    }

    public void setHseAfrName(String hseAfrName) {
        this.hseAfrName = hseAfrName;
    }

    public String getHseColour() {
        return hseColour;
    }

    public void setHseColour(String hseColour) {
        this.hseColour = hseColour;
    }

    public String getHseAfrColour() {
        return hseAfrColour;
    }

    public void setHseAfrColour(String hseAfrColour) {
        this.hseAfrColour = hseAfrColour;
    }

    public byte[] getHsePicture() {
        return hsePicture;
    }

    public void setHsePicture(byte[] hsePicture) {
        this.hsePicture = hsePicture;
    }

    public boolean isRecSelected() {
        return recSelected;
    }

    public void setRecSelected(boolean recSelected) {
        this.recSelected = recSelected;
    }
}
