package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ExtraMuralsCompEventsResource;
import za.co.sfy.lucid.sams.resource.ExtraMuralsCompetitionsResource;
import za.co.sfy.lucid.sams.rest.mapper.ExtraMuralsCompEventsMapper;
import za.co.sfy.sams.vo.ExtraMuralsCompEventsRequest;
import za.co.sfy.sams.vo.ExtraMuralsCompEventsResponse;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompEvents;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Service
public class ExtraMuralsCompEventsService {

    private final ExtraMuralsCompEventsMapper extraMuralsCompEventsMapper;
    private final ExtraMuralsCompEventsResource extraMuralsCompEventsResource;
    private final ExtraMuralsCompetitionsResource extraMuralsCompetitionsResource;

    @Autowired
    public ExtraMuralsCompEventsService(final ExtraMuralsCompEventsMapper extraMuralsCompEventsMapper,
                                        final ExtraMuralsCompEventsResource extraMuralsCompEventsResource,
                                        final ExtraMuralsCompetitionsResource extraMuralsCompetitionsResource) {
        this.extraMuralsCompEventsMapper = extraMuralsCompEventsMapper;
        this.extraMuralsCompEventsResource = extraMuralsCompEventsResource;
        this.extraMuralsCompetitionsResource = extraMuralsCompetitionsResource;
    }

    public ExtraMuralsCompEventsResponse saveExtraMuralsCompEvents(ExtraMuralsCompEventsRequest extraMuralsCompEventsRequest)
            throws LucidSamsExecutionException {

        ExtraMuralsCompEvents extraMuralsCompEvents = extraMuralsCompEventsMapper
                .extraMuralsCompEventsRequestToExtraMuralsCompEvents(extraMuralsCompEventsRequest);

        Integer compID = extraMuralsCompEvents.getCompID();

        ResultSet retrievedExtraMuralsCompetitions = extraMuralsCompetitionsResource.retrieveExtraMuralsCompetitionsByID(compID);
        try {
            if (!retrievedExtraMuralsCompetitions.next()) {
                throw new LucidSamsExecutionException("The given 'compID' - " + compID + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failure in the retrieved Extra Murals Competitions ", exception);
        }

        Long generatedKey = extraMuralsCompEventsResource.save(extraMuralsCompEvents, extraMuralsCompEventsResource);
        extraMuralsCompEvents.setEventID(Math.toIntExact(generatedKey));

        ExtraMuralsCompEventsResponse extraMuralsCompEventsResponse = new ExtraMuralsCompEventsResponse();
        extraMuralsCompEventsResponse.setExtraMuralsCompEvents(extraMuralsCompEvents);
        extraMuralsCompEventsResponse.setResponseMessage("Successfully saved 'ExtraMuralsCompEvents' data");
        extraMuralsCompEventsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return extraMuralsCompEventsResponse;
    }

}