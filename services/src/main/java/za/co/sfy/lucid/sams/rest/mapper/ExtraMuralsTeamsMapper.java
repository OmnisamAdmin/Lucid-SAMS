package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsTeamsRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTeams;

@Component
public class ExtraMuralsTeamsMapper {

	public ExtraMuralsTeams extraMuralsTeamsRequestToExtraMuralsTeams(ExtraMuralsTeamsRequest extraMuralsTeamsRequest) {

		ExtraMuralsTeams extraMuralsTeams = new ExtraMuralsTeams();

		Integer exID = extraMuralsTeamsRequest.getExID();
		if (null != exID) {
			extraMuralsTeams.setExID(exID);
		}

		extraMuralsTeams.setRecLocked(extraMuralsTeamsRequest.isRecLocked());

		extraMuralsTeams.setRecSelected(extraMuralsTeamsRequest.isRecSelected());

		String teamAfrName = extraMuralsTeamsRequest.getTeamAfrName();
		if (null != teamAfrName) {
			extraMuralsTeams.setTeamAfrName(extraMuralsTeamsRequest.getTeamAfrName());
		}

		Short teamAgeFrom = extraMuralsTeamsRequest.getTeamAgeFrom();
		if (null != teamAgeFrom) {
			extraMuralsTeams.setTeamAgeFrom(teamAgeFrom);
		} else {
			extraMuralsTeams.setTeamAgeFrom(Short.valueOf("0"));
		}

		Short teamAgeTo = extraMuralsTeamsRequest.getTeamAgeTo();
		if (null != teamAgeTo) {
			extraMuralsTeams.setTeamAgeTo(teamAgeTo);
		} else {
			extraMuralsTeams.setTeamAgeTo(Short.valueOf("0"));
		}

		Integer teamDepEdID = extraMuralsTeamsRequest.getTeamDepEdID();
		if (null != teamDepEdID) {
			extraMuralsTeams.setTeamDepEdID(teamDepEdID);
		} else {
			extraMuralsTeams.setTeamDepEdID(0);

		}

		Integer teamEdID = extraMuralsTeamsRequest.getTeamEdID();
		if (null != teamEdID) {
			extraMuralsTeams.setTeamEdID(teamEdID);
		} else {
			extraMuralsTeams.setTeamEdID(0);

		}

		Integer teamID = extraMuralsTeamsRequest.getTeamID();
		if (null != teamID) {
			extraMuralsTeams.setTeamID(teamID);
		}

		String teamName = extraMuralsTeamsRequest.getTeamName();
		if (null != teamName) {
			extraMuralsTeams.setTeamName(extraMuralsTeamsRequest.getTeamName());
		}

		Integer teamOfficialID = extraMuralsTeamsRequest.getTeamOfficialID();
		if (null != teamOfficialID) {
			extraMuralsTeams.setTeamOfficialID(teamOfficialID);
		} else {
			extraMuralsTeams.setTeamOfficialID(0);
		}

		byte[] teamPicture = extraMuralsTeamsRequest.getTeamPicture();
		if (null != teamPicture) {
			extraMuralsTeams.setTeamPicture(extraMuralsTeamsRequest.getTeamPicture());
		}

		return extraMuralsTeams;
	}
}
