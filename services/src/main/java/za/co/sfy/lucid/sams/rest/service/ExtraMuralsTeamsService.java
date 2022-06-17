package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ExtraMuralsResource;
import za.co.sfy.lucid.sams.resource.ExtraMuralsTeamsResource;
import za.co.sfy.lucid.sams.rest.mapper.ExtraMuralsTeamsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsTeamsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsTeamsResponse;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTeams;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ExtraMuralsTeamsService {

    private final ExtraMuralsTeamsMapper extraMuralsTeamsMapper;
    private final ExtraMuralsTeamsResource extraMuralsTeamsResource;
    private final ExtraMuralsResource extraMuralsResource;

    @Autowired
    public ExtraMuralsTeamsService(final ExtraMuralsTeamsMapper extraMuralsTeamsMapper,
                                   final ExtraMuralsTeamsResource extraMuralsTeamsResource,
                                   final ExtraMuralsResource extraMuralsResource) {
        this.extraMuralsTeamsMapper = extraMuralsTeamsMapper;
        this.extraMuralsTeamsResource = extraMuralsTeamsResource;
        this.extraMuralsResource = extraMuralsResource;
    }

    public ExtraMuralsTeamsResponse saveExtraMuralsTeams(ExtraMuralsTeamsRequest extraMuralsTeamsRequest) throws LucidSamsExecutionException {

        ExtraMuralsTeams extraMuralsTeams = extraMuralsTeamsMapper.extraMuralsTeamsRequestToExtraMuralsTeams(extraMuralsTeamsRequest);

        Integer exID = extraMuralsTeamsRequest.getExID();

        ResultSet retrievedExtraMuralsID = extraMuralsResource.retrieveExtraMuralsByID(exID);
        try {
            if (!retrievedExtraMuralsID.next()) {
                throw new LucidSamsExecutionException("The given 'ExID' - " + exID + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Long generatedKey = extraMuralsTeamsResource.save(extraMuralsTeams, extraMuralsTeamsResource);
        extraMuralsTeams.setTeamID(Math.toIntExact(generatedKey));

        ExtraMuralsTeamsResponse extraMuralsTeamsResponse = new ExtraMuralsTeamsResponse();
        extraMuralsTeamsResponse.setExtraMuralsTeams(extraMuralsTeams);
        extraMuralsTeamsResponse.setResponseMessage("Successfully saved 'ExtraMuralsTeams' data");
        extraMuralsTeamsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return extraMuralsTeamsResponse;
    }

}
