package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class BusRoutesRequest implements Serializable {

    private static final long serialVersionUID = 7722486277220081460L;

    private Integer busRouteId;
    @NotBlank
    private String route;
    @NotBlank
    private String departureTime;
    @NotBlank
    private String routeDescription;
    @NotBlank
    private String busName;
    @NotBlank
    private String responsible;

    public Integer getBusRouteId() {
        return busRouteId;
    }

    public void setBusRouteId(Integer busRouteId) {
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
