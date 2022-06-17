package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsRequest;
import za.co.sfy.sams.lucid.schema.ExtraMurals;

/**
 * @author muzim
 */
@Component
public class ExtraMuralsMapper {

	public ExtraMurals extraMuralsRequestToExtraMurals(ExtraMuralsRequest extraMuralsRequest) {

		ExtraMurals extraMurals = new ExtraMurals();

		extraMurals.setExAfrName(extraMuralsRequest.getExAfrName());

		Integer exID = extraMuralsRequest.getExID();
		if (null != exID) {
			extraMurals.setExID(Integer.valueOf(exID));
		} else {
			extraMurals.setExID(Integer.valueOf(0));
		}

		String exName = extraMuralsRequest.getExName();
		if (null != exName) {
			extraMurals.setExName(extraMuralsRequest.getExName());

		}

		Integer exOfficialID = extraMuralsRequest.getExOfficialID();
		if (null != exOfficialID) {
			extraMurals.setExOfficialID(Integer.valueOf(exOfficialID));
		} else {
			extraMurals.setExOfficialID(Integer.valueOf(0));
		}

		String exPicKey = extraMuralsRequest.getExPicKey();
		if (null != exPicKey) {
			extraMurals.setExPicKey(extraMuralsRequest.getExPicKey());
		}

		byte[] exPicture = extraMuralsRequest.getExPicture();
		if (null != exPicture) {
			extraMurals.setExPicture(extraMuralsRequest.getExPicture());
		}

		Integer exTypeID = extraMuralsRequest.getExTypeID();
		if (null != exTypeID) {
			extraMurals.setExTypeID(Integer.valueOf(exTypeID));
		} else {
			extraMurals.setExTypeID(Integer.valueOf(0));
		}

		extraMurals.setRecLocked(extraMuralsRequest.isRecLocked());
		extraMurals.setRecSelected(extraMuralsRequest.isRecSelected());

		return extraMurals;

	}

}