package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsTeamsRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTeams;

@Component
public class ExtraMuralsTeamsMapper {

    public ExtraMuralsTeams extraMuralsTeamsRequestToExtraMuralsTeams(ExtraMuralsTeamsRequest extraMuralsTeamsRequest) {

        ExtraMuralsTeams extraMuralsTeams = new ExtraMuralsTeams();

        extraMuralsTeams.setExID(extraMuralsTeamsRequest.getExID());
        extraMuralsTeams.setRecLocked(extraMuralsTeamsRequest.isRecLocked());
        extraMuralsTeams.setRecSelected(extraMuralsTeamsRequest.isRecSelected());
        extraMuralsTeams.setTeamAfrName(extraMuralsTeamsRequest.getTeamAfrName());
        extraMuralsTeams.setTeamAgeFrom(extraMuralsTeamsRequest.getTeamAgeFrom());
        extraMuralsTeams.setTeamAgeTo(extraMuralsTeamsRequest.getTeamAgeTo());
        extraMuralsTeams.setTeamDepEdID(extraMuralsTeamsRequest.getTeamDepEdID());
        extraMuralsTeams.setTeamEdID(extraMuralsTeamsRequest.getTeamEdID());
        extraMuralsTeams.setTeamID(extraMuralsTeamsRequest.getTeamID());
        extraMuralsTeams.setTeamName(extraMuralsTeamsRequest.getTeamName());
        extraMuralsTeams.setTeamOfficialID(extraMuralsTeamsRequest.getTeamOfficialID());
        extraMuralsTeams.setTeamPicture(extraMuralsTeamsRequest.getTeamPicture());

        return extraMuralsTeams;
    }
}
