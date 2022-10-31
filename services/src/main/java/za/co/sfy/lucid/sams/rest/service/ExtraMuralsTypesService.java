package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ExtraMuralsTypesResource;
import za.co.sfy.lucid.sams.rest.mapper.ExtraMuralsTypesMapper;
import za.co.sfy.sams.vo.ExtraMuralsTypesRequest;
import za.co.sfy.sams.vo.ExtraMuralsTypesResponse;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTypes;

@Service
public class ExtraMuralsTypesService {

    private final ExtraMuralsTypesMapper extraMuralsTypesMapper;
    private final ExtraMuralsTypesResource extraMuralsTypesResource;

    @Autowired
    public ExtraMuralsTypesService(final ExtraMuralsTypesMapper extraMuralsTypesMapper, final ExtraMuralsTypesResource
            extraMuralsTypesResource) {
        this.extraMuralsTypesMapper = extraMuralsTypesMapper;
        this.extraMuralsTypesResource = extraMuralsTypesResource;
    }

    public ExtraMuralsTypesResponse saveExtraMuralsTypes(ExtraMuralsTypesRequest extraMuralsTypesRequest) throws LucidSamsExecutionException {

        ExtraMuralsTypes extraMuralsTypes = extraMuralsTypesMapper.extraMuralsTypesRequestToExtraMuralsTypes(extraMuralsTypesRequest);

        Long generatedKey = extraMuralsTypesResource.save(extraMuralsTypes, extraMuralsTypesResource);
        extraMuralsTypes.setExTypeID(Math.toIntExact(generatedKey));

        ExtraMuralsTypesResponse extraMuralsTypesResponse = new ExtraMuralsTypesResponse();
        extraMuralsTypesResponse.setExtraMuralsTypes(extraMuralsTypes);
        extraMuralsTypesResponse.setResponseMessage("Successfully saved 'ExtraMuralsTypes' data");
        extraMuralsTypesResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return extraMuralsTypesResponse;

    }
}