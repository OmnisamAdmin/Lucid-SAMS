package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ExtraMuralsHousesResource;
import za.co.sfy.lucid.sams.rest.mapper.ExtraMuralsHousesMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsHousesRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsHousesResponse;
import za.co.sfy.sams.lucid.schema.ExtraMuralsHouses;

@Service
public class ExtraMuralsHousesService {

    private final ExtraMuralsHousesResource extraMuralsHousesResource;
    private final ExtraMuralsHousesMapper extraMuralsHousesMapper;

    @Autowired
    public ExtraMuralsHousesService(final ExtraMuralsHousesResource extraMuralsHousesResource, final ExtraMuralsHousesMapper extraMuralsHousesMapper) {
        this.extraMuralsHousesMapper = extraMuralsHousesMapper;
        this.extraMuralsHousesResource = extraMuralsHousesResource;
    }

    public ExtraMuralsHousesResponse saveExtraMuralsHouse(ExtraMuralsHousesRequest extraMuralsHousesRequest) throws LucidSamsExecutionException {

        ExtraMuralsHouses extraMuralsHouses = extraMuralsHousesMapper.extraMuralsHousesRequestToExtraMuralsHouses(extraMuralsHousesRequest);

        Long generatedKey = extraMuralsHousesResource.save(extraMuralsHouses, extraMuralsHousesResource);
        extraMuralsHouses.setHseID(Math.toIntExact(generatedKey));

        ExtraMuralsHousesResponse extraMuralsHousesResponse = new ExtraMuralsHousesResponse();
        extraMuralsHousesResponse.setExtraMuralsHouses(extraMuralsHouses);
        extraMuralsHousesResponse.setResponseMessage("Successfully saved 'ExtraMuralsHouses' data");
        extraMuralsHousesResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return extraMuralsHousesResponse;
    }
}
