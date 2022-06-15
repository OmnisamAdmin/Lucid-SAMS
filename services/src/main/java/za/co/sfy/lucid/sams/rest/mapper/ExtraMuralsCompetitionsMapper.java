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

		// TODO This is problem
		Integer compID = extraMuralsCompetitionsRequest.getCompID();
		if (null != compID) {
			extraMuralsCompetitions.setCompID(Integer.valueOf(compID));
		} else {
			extraMuralsCompetitions.setCompID(Integer.valueOf(0));

		}

		String compName = extraMuralsCompetitionsRequest.getCompName();
		if (null != compName) {
			extraMuralsCompetitions.setCompName(extraMuralsCompetitionsRequest.getCompName());
		}

		Integer compOfficialID = extraMuralsCompetitionsRequest.getCompOfficialID();
		if (null != compOfficialID) {
			extraMuralsCompetitions.setCompOfficialID(Integer.valueOf(compOfficialID));
		} else {
			extraMuralsCompetitions.setCompOfficialID(Integer.valueOf(0));
		}

		byte[] compPicture = extraMuralsCompetitionsRequest.getCompPicture();
		if (null != compPicture) {
			extraMuralsCompetitions.setCompPicture(extraMuralsCompetitionsRequest.getCompPicture());
		}

		Integer exID = extraMuralsCompetitionsRequest.getExID();
		if (null != exID) {
			extraMuralsCompetitions.setExID(Integer.valueOf(exID));
		} else {
			extraMuralsCompetitions.setExID(Integer.valueOf(0));
		}

		extraMuralsCompetitions.setRecLocked(extraMuralsCompetitionsRequest.isRecLocked());
		extraMuralsCompetitions.setRecSelected(extraMuralsCompetitionsRequest.isRecSelected());

		return extraMuralsCompetitions;

	}
}
