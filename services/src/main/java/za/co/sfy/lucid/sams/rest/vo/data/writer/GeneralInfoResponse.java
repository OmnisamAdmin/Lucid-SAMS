package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.GeneralInfo;

import java.io.Serializable;


public class GeneralInfoResponse extends ApiResponse implements Serializable {

    private static final long serialVersionUID = -6453363986103920661L;

    private GeneralInfo generalInfo;

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

}
