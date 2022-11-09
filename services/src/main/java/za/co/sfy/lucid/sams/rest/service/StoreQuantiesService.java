package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.StoreQuantiesResource;
import za.co.sfy.lucid.sams.rest.mapper.StoreQuantiesMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.StoreQuantiesRequest;
import za.co.sfy.sams.vo.StoreQuantiesResponse;
import za.co.sfy.sams.lucid.schema.StoreQuanties;

@Service
public class StoreQuantiesService {

    private final StoreQuantiesResource storeQuantiesResource;
    private final StoreQuantiesMapper storeQuantiesMapper;

    @Autowired
    public StoreQuantiesService(final StoreQuantiesResource storeQuantiesResource, final StoreQuantiesMapper storeQuantiesMapper) {
        this.storeQuantiesResource = storeQuantiesResource;
        this.storeQuantiesMapper = storeQuantiesMapper;
    }

    public StoreQuantiesResponse saveStoreQuanties(StoreQuantiesRequest storeQuantiesRequest) throws LucidSamsExecutionException {

        StoreQuanties storeQuanties = storeQuantiesMapper.storeQuantiesRequestToStoreRequest(storeQuantiesRequest);

        Long generatedKey = storeQuantiesResource.save(storeQuanties, storeQuantiesResource);
        storeQuanties.setID(Math.toIntExact(generatedKey));

        StoreQuantiesResponse storeQuantiesResponse = new StoreQuantiesResponse();
        storeQuantiesResponse.setStoreQuanties(storeQuanties);
        storeQuantiesResponse.setResponseMessage("Successfully saved 'StoreQuanties' data");
        storeQuantiesResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return storeQuantiesResponse;
    }

}