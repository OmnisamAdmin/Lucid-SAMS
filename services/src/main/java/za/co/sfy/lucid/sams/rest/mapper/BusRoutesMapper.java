package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.BusRoutesRequest;
import za.co.sfy.sams.lucid.schema.BusRoutes;

/**
 * @author muzim
 */
@Component
public class BusRoutesMapper {

	public BusRoutes busRoutesRequestToBusRoutes(BusRoutesRequest busRoutesRequest) {

		BusRoutes busRoutes = new BusRoutes();

		String busName = busRoutesRequest.getBusName();
		if (null != busName) {
		busRoutes.setBusName(busRoutesRequest.getBusName());
		}
		
		Integer busRouteId = busRoutesRequest.getBusRouteId();
		if (null != busRouteId) {
		busRoutes.setBusRouteId(busRouteId);
		}
		
		String departureTime = busRoutesRequest.getDepartureTime();
		if (null != departureTime) {
		busRoutes.setDepartureTime(busRoutesRequest.getDepartureTime());
		}
		
		String responsible = busRoutesRequest.getResponsible();
		if (null != responsible) {
		busRoutes.setResponsible(busRoutesRequest.getResponsible());
		}
		
		String route = busRoutesRequest.getRoute();
		if (null != route) {
		busRoutes.setRoute(busRoutesRequest.getRoute());
		}
		
		String routeDescription = busRoutesRequest.getRouteDescription();
		if (null != routeDescription) {
		busRoutes.setRouteDescription(busRoutesRequest.getRouteDescription());
		}

		return busRoutes;
	}

}
