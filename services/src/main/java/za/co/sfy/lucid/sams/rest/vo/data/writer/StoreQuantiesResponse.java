package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.StoreQuanties;

public class StoreQuantiesResponse extends ApiResponse {

    private static final long serialVersionUID = 764060765571973537L;

    private StoreQuanties storeQuanties;

    public StoreQuanties getStoreQuanties() {
        return storeQuanties;
    }

    public void setStoreQuanties(StoreQuanties storeQuanties) {
        this.storeQuanties = storeQuanties;
    }
}
