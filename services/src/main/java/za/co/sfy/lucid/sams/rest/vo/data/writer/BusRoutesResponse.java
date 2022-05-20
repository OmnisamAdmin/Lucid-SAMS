package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.BusRoutes;

public class BusRoutesResponse extends ApiResponse {

    private static final long serialVersionUID = 2985946569037038459L;

    private BusRoutes busRoutes;

    public BusRoutes getBusRoutes() {
        return busRoutes;
    }

    public void setBusRoutes(BusRoutes busRoutes) {
        this.busRoutes = busRoutes;
    }
}
