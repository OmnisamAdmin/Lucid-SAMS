package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.Deworming;

public class DewormingResponse extends ApiResponse {

    private static final long serialVersionUID = -2868990501285980996L;
    private Deworming deworming;

    public Deworming getDeworming() {
        return deworming;
    }

    public void setDeworming(Deworming deworming) {
        this.deworming = deworming;
    }
}
