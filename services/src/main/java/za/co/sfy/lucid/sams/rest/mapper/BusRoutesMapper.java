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

		busRoutes.setBusName(busRoutesRequest.getBusName());
		busRoutes.setBusRouteId(busRoutesRequest.getBusRouteId());
		busRoutes.setDepartureTime(busRoutesRequest.getDepartureTime());
		busRoutes.setResponsible(busRoutesRequest.getResponsible());
		busRoutes.setRoute(busRoutesRequest.getRoute());
		busRoutes.setRouteDescription(busRoutesRequest.getRouteDescription());

		return busRoutes;
	}

}