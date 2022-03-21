package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.ParentInfo;

import java.io.Serializable;

/**
 * @author muzim
 */
public class ParentInfoResponse extends ApiResponse implements Serializable {

    private static final long serialVersionUID = 4352828393181036222L;

    private ParentInfo parentInfo;

    public ParentInfo getParentInfo() {
        return parentInfo;
    }

    public void setParentInfo(ParentInfo parentInfo) {
        this.parentInfo = parentInfo;
    }
}
