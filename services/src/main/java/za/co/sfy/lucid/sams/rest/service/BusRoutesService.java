package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.BusRoutesResource;
import za.co.sfy.lucid.sams.rest.mapper.BusRoutesMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.BusRoutesRequest;
import za.co.sfy.sams.vo.BusRoutesResponse;
import za.co.sfy.sams.lucid.schema.BusRoutes;

@Service
public class BusRoutesService {

    private final BusRoutesResource busRoutesResource;
    private final BusRoutesMapper busRoutesMapper;

    @Autowired
    public BusRoutesService(final BusRoutesResource busRoutesResource, final BusRoutesMapper busRoutesMapper) {
        this.busRoutesResource = busRoutesResource;
        this.busRoutesMapper = busRoutesMapper;

    }

    public BusRoutesResponse saveBusRoutes(BusRoutesRequest busRoutesRequest) throws LucidSamsExecutionException {

        BusRoutes busRoutes = busRoutesMapper.busRoutesRequestToBusRoutes(busRoutesRequest);

        Long generatedKey = busRoutesResource.save(busRoutes, busRoutesResource);
        busRoutes.setBusRouteId(Math.toIntExact(generatedKey));

        BusRoutesResponse busRoutesResponse = new BusRoutesResponse();
        busRoutesResponse.setBusRoutes(busRoutes);
        busRoutesResponse.setResponseStatus(ServiceStatus.SUCCESS.value());
        busRoutesResponse.setResponseMessage("Successfully saved 'BusRoutes' data.");
        
        return busRoutesResponse;
    }

}