package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ExtraMuralsCompetitionsResource;
import za.co.sfy.lucid.sams.resource.ExtraMuralsResource;
import za.co.sfy.lucid.sams.rest.mapper.ExtraMuralsCompetitionsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompetitionsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompetitionsResponse;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompetitions;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ExtraMuralsCompetitionsService {

    private final ExtraMuralsCompetitionsResource extraMuralsCompetitionsResource;
    private final ExtraMuralsCompetitionsMapper extraMuralsCompetitionsMapper;
    private final ExtraMuralsResource extraMuralsResource;

    @Autowired
    public ExtraMuralsCompetitionsService(final ExtraMuralsCompetitionsResource extraMuralsCompetitionsResource,
                                          final ExtraMuralsCompetitionsMapper extraMuralsCompetitionsMapper,
                                          final ExtraMuralsResource extraMuralsResource) {
        this.extraMuralsCompetitionsResource = extraMuralsCompetitionsResource;
        this.extraMuralsCompetitionsMapper = extraMuralsCompetitionsMapper;
        this.extraMuralsResource = extraMuralsResource;
    }


    public ExtraMuralsCompetitionsResponse saveExtraMuralsCompetitions(ExtraMuralsCompetitionsRequest extraMuralsCompetitionsRequest)
            throws LucidSamsExecutionException {

        ExtraMuralsCompetitions extraMuralsCompetitions = extraMuralsCompetitionsMapper
                .extraMuralsCompetitionsRequestToExtraMuralsCompetitions(extraMuralsCompetitionsRequest);

        Integer exID = extraMuralsCompetitions.getExID();

        ResultSet retrievedExtraMurals = extraMuralsResource.retrieveExtraMuralsByID(exID);
        try {
            if (!retrievedExtraMurals.next()) {
                throw new LucidSamsExecutionException("The given 'ExID' - " + exID + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Long generatedKey = extraMuralsCompetitionsResource.save(extraMuralsCompetitions, extraMuralsCompetitionsResource);
        extraMuralsCompetitions.setCompID(Math.toIntExact(generatedKey));

        ExtraMuralsCompetitionsResponse extraMuralsCompetitionsResponse = new ExtraMuralsCompetitionsResponse();
        extraMuralsCompetitionsResponse.setExtraMuralsCompetitions(extraMuralsCompetitions);
        extraMuralsCompetitionsResponse.setResponseMessage("Successfully saved 'ExtraMuralsCompetitions' data");
        extraMuralsCompetitionsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return extraMuralsCompetitionsResponse;
    }

}
