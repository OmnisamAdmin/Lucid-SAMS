package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ExtraMuralsResource;
import za.co.sfy.lucid.sams.resource.ExtraMuralsTypesResource;
import za.co.sfy.lucid.sams.rest.mapper.ExtraMuralsMapper;
import za.co.sfy.sams.vo.ExtraMuralsRequest;
import za.co.sfy.sams.vo.ExtraMuralsResponse;
import za.co.sfy.sams.lucid.schema.ExtraMurals;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Service
public class ExtraMuralsService {

    private final ExtraMuralsMapper extraMuralsMapper;
    private final ExtraMuralsResource extraMuralsResource;
    private final ExtraMuralsTypesResource extraMuralsTypesResource;

    @Autowired
    public ExtraMuralsService(final ExtraMuralsMapper extraMuralsMapper, final ExtraMuralsResource extraMuralsResource,
                              final ExtraMuralsTypesResource extraMuralsTypesResource) {
        this.extraMuralsMapper = extraMuralsMapper;
        this.extraMuralsResource = extraMuralsResource;
        this.extraMuralsTypesResource = extraMuralsTypesResource;
    }

    public ExtraMuralsResponse saveExtraMurals(ExtraMuralsRequest extraMuralsRequest) throws LucidSamsExecutionException {

        ExtraMurals extraMurals = extraMuralsMapper.extraMuralsRequestToExtraMurals(extraMuralsRequest);

        Integer exTypeID = extraMurals.getExTypeID();

        ResultSet retrievedExtraMuralsTypes = extraMuralsTypesResource.retrieveExtraMuralsTypesByID(exTypeID);
        try {
            if (!retrievedExtraMuralsTypes.next()) {
                throw new LucidSamsExecutionException("The given 'ExTypeID' - " + exTypeID + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failure in the retrieved Extra Mural Types", exception);
        }

        Long generatedKey = extraMuralsResource.save(extraMurals, extraMuralsResource);
        extraMurals.setExID(Math.toIntExact(generatedKey));

        ExtraMuralsResponse extraMuralsResponse = new ExtraMuralsResponse();
        extraMuralsResponse.setExtraMurals(extraMurals);
        extraMuralsResponse.setResponseMessage("Successfully saved 'ExtraMurals' data");
        extraMuralsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return extraMuralsResponse;
    }
}