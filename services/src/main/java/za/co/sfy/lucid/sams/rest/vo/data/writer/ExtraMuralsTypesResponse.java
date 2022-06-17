package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTypes;

public class ExtraMuralsTypesResponse extends ApiResponse {

    private static final long serialVersionUID = 7616239412636725666L;

    private ExtraMuralsTypes extraMuralsTypes;

    public ExtraMuralsTypes getExtraMuralsTypes() {
        return extraMuralsTypes;
    }

    public void setExtraMuralsTypes(ExtraMuralsTypes extraMuralsTypes) {
        this.extraMuralsTypes = extraMuralsTypes;
    }
}
