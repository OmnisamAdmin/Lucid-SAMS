package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ExtraMuralsResource;
import za.co.sfy.lucid.sams.rest.mapper.ExtraMuralsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsResponse;
import za.co.sfy.sams.lucid.schema.ExtraMurals;

@Service
public class ExtraMuralsService {

    private final ExtraMuralsMapper extraMuralsMapper;
    private final ExtraMuralsResource extraMuralsResource;

    @Autowired
    public ExtraMuralsService(final ExtraMuralsMapper extraMuralsMapper, final ExtraMuralsResource extraMuralsResource) {
        this.extraMuralsMapper = extraMuralsMapper;
        this.extraMuralsResource = extraMuralsResource;
    }

    public ExtraMuralsResponse saveExtraMurals(ExtraMuralsRequest extraMuralsRequest) throws LucidSamsExecutionException {

        ExtraMurals extraMurals = extraMuralsMapper.extraMuralsRequestToExtraMurals(extraMuralsRequest);

        Long generatedKey = extraMuralsResource.save(extraMurals, extraMuralsResource);
        extraMurals.setExID(Math.toIntExact(generatedKey));

        ExtraMuralsResponse extraMuralsResponse = new ExtraMuralsResponse();
        extraMuralsResponse.setExtraMurals(extraMurals);
        extraMuralsResponse.setResponseMessage("Successfully saved 'ExtraMurals' data");
        extraMuralsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return extraMuralsResponse;
    }
}
