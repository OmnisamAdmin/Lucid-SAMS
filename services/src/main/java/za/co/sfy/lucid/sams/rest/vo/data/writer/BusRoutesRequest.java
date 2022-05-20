package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BusRoutesRequest implements Serializable {

    private static final long serialVersionUID = 7722486277220081460L;

    private int busRouteId;
    @NotNull
    private String route;
    @NotNull
    private String departureTime;
    @NotNull
    private String routeDescription;
    @NotNull
    private String busName;
    @NotNull
    private String responsible;

    public int getBusRouteId() {
        return busRouteId;
    }

    public void setBusRouteId(int busRouteId) {
        this.busRouteId = busRouteId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getRouteDescription() {
        return routeDescription;
    }

    public void setRouteDescription(String routeDescription) {
        this.routeDescription = routeDescription;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
}
