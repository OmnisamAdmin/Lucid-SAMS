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
			extraMuralsTeams.setExID(Integer.valueOf(exID));
		} else {
			extraMuralsTeams.setExID(Integer.valueOf(0));
		}

		extraMuralsTeams.setRecLocked(extraMuralsTeamsRequest.isRecLocked());

		extraMuralsTeams.setRecSelected(extraMuralsTeamsRequest.isRecSelected());

		String teamAfrName = extraMuralsTeamsRequest.getTeamAfrName();
		if (null != teamAfrName) {
			extraMuralsTeams.setTeamAfrName(extraMuralsTeamsRequest.getTeamAfrName());
		}

		Short teamAgeFrom = extraMuralsTeamsRequest.getTeamAgeFrom();
		if (null != teamAgeFrom) {
			extraMuralsTeams.setTeamAgeFrom(Short.valueOf(teamAgeFrom));
		} else {
			extraMuralsTeams.setTeamAgeFrom(Short.valueOf("0"));
		}

		Short teamAgeTo = extraMuralsTeamsRequest.getTeamAgeTo();
		if (null != teamAgeTo) {
			extraMuralsTeams.setTeamAgeTo(Short.valueOf(teamAgeTo));
		} else {
			extraMuralsTeams.setTeamAgeTo(Short.valueOf("0"));
		}

		Integer teamDepEdID = extraMuralsTeamsRequest.getTeamDepEdID();
		if (null != teamDepEdID) {
			extraMuralsTeams.setTeamDepEdID(Integer.valueOf(teamDepEdID));
		} else {
			extraMuralsTeams.setTeamDepEdID(Integer.valueOf(0));

		}

		Integer teamEdID = extraMuralsTeamsRequest.getTeamEdID();
		if (null != teamEdID) {
			extraMuralsTeams.setTeamEdID(Integer.valueOf(teamEdID));
		} else {
			extraMuralsTeams.setTeamEdID(Integer.valueOf(0));

		}

		// TODO This is problem
		Integer teamID = extraMuralsTeamsRequest.getTeamID();
		if (null != teamID) {
			extraMuralsTeams.setTeamID(Integer.valueOf(teamID));
		} else {
			extraMuralsTeams.setTeamID(Integer.valueOf(0));
		}

		String teamName = extraMuralsTeamsRequest.getTeamName();
		if (null != teamName) {
			extraMuralsTeams.setTeamName(extraMuralsTeamsRequest.getTeamName());
		}

		Integer teamOfficialID = extraMuralsTeamsRequest.getTeamOfficialID();
		if (null != teamOfficialID) {
			extraMuralsTeams.setTeamOfficialID(Integer.valueOf(teamOfficialID));
		} else {
			extraMuralsTeams.setTeamOfficialID(Integer.valueOf(0));
		}

		byte[] teamPicture = extraMuralsTeamsRequest.getTeamPicture();
		if (null != teamPicture) {
			extraMuralsTeams.setTeamPicture(extraMuralsTeamsRequest.getTeamPicture());
		}

		return extraMuralsTeams;
	}
}
