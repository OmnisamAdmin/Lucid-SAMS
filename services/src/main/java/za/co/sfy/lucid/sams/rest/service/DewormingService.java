package za.co.sfy.lucid.sams.rest.service;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.DewormingResource;
import za.co.sfy.lucid.sams.rest.mapper.DewormingMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DewormingRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DewormingResponse;
import za.co.sfy.sams.lucid.schema.Deworming;

@Component
public class DewormingService {
    private final DewormingResource dewormingResource;
    private final DewormingMapper dewormingMapper;

    public DewormingService(DewormingResource dewormingResource, DewormingMapper dewormingMapper) {
        this.dewormingResource = dewormingResource;
        this.dewormingMapper = dewormingMapper;
    }

    public DewormingResponse saveDeworming(DewormingRequest dewormingRequest) throws LucidSamsExecutionException {
        Deworming deworming = dewormingMapper.dewormingRequestToDeworming(dewormingRequest);

        Long generatedKey = dewormingResource.save(deworming, dewormingResource);
        deworming.setID(Math.toIntExact(generatedKey));
        DewormingResponse dewormingResponse = new DewormingResponse();
        dewormingResponse.setDeworming(deworming);
        dewormingResponse.setResponseMessage("Successfully saved 'Deworming' data");
        dewormingResponse.setResponseStatus(ServiceStatus.SUCCESS.value());
        return dewormingResponse;

    }

}
