package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompetitionsRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompetitions;

@Component
public class ExtraMuralsCompetitionsMapper {

	public ExtraMuralsCompetitions extraMuralsCompetitionsRequestToExtraMuralsCompetitions(
			ExtraMuralsCompetitionsRequest extraMuralsCompetitionsRequest) {

		ExtraMuralsCompetitions extraMuralsCompetitions = new ExtraMuralsCompetitions();

		String compAfrName = extraMuralsCompetitionsRequest.getCompAfrName();
		if (null != compAfrName) {
			extraMuralsCompetitions.setCompAfrName(extraMuralsCompetitionsRequest.getCompAfrName());
		}

		Integer compID = extraMuralsCompetitionsRequest.getCompID();
		if (null != compID) {
			extraMuralsCompetitions.setCompID(compID);
		}

		String compName = extraMuralsCompetitionsRequest.getCompName();
		if (null != compName) {
			extraMuralsCompetitions.setCompName(extraMuralsCompetitionsRequest.getCompName());
		}

		Integer compOfficialID = extraMuralsCompetitionsRequest.getCompOfficialID();
		if (null != compOfficialID) {
			extraMuralsCompetitions.setCompOfficialID(compOfficialID);
		} else {
			extraMuralsCompetitions.setCompOfficialID(0);
		}

		byte[] compPicture = extraMuralsCompetitionsRequest.getCompPicture();
		if (null != compPicture) {
			extraMuralsCompetitions.setCompPicture(extraMuralsCompetitionsRequest.getCompPicture());
		}

		Integer exID = extraMuralsCompetitionsRequest.getExID();
		if (null != exID) {
			extraMuralsCompetitions.setExID(exID);
		}

		extraMuralsCompetitions.setRecLocked(extraMuralsCompetitionsRequest.isRecLocked());
		extraMuralsCompetitions.setRecSelected(extraMuralsCompetitionsRequest.isRecSelected());

		return extraMuralsCompetitions;

	}
}
