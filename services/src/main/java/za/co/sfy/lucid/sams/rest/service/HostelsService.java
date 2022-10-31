package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.HostelsResource;
import za.co.sfy.lucid.sams.rest.mapper.HostelsMapper;
import za.co.sfy.sams.vo.HostelsRequest;
import za.co.sfy.sams.vo.HostelsResponse;
import za.co.sfy.sams.lucid.schema.Hostels;

@Service
public class HostelsService {

    private final HostelsResource hostelsResource;
    private final HostelsMapper hostelsMapper;

    @Autowired
    public HostelsService(final HostelsResource hostelsResource, final HostelsMapper hostelsMapper) {
        this.hostelsResource = hostelsResource;
        this.hostelsMapper = hostelsMapper;
    }

    public HostelsResponse saveHostels(HostelsRequest hostelsRequest) throws LucidSamsExecutionException {

        Hostels hostels = hostelsMapper.hostelsRequestToHostels(hostelsRequest);

        Long generatedKey = hostelsResource.save(hostels, hostelsResource);
        hostels.setID(Math.toIntExact(generatedKey));

        HostelsResponse hostelsResponse = new HostelsResponse();
        hostelsResponse.setHostels(hostels);
        hostelsResponse.setResponseMessage("Successfully saved 'Hostels' data");
        hostelsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return hostelsResponse;
    }
}