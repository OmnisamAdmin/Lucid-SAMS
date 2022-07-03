package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsHousesRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsHouses;

/**
 * @author muzim
 */
@Component
public class ExtraMuralsHousesMapper {

	public ExtraMuralsHouses extraMuralsHousesRequestToExtraMuralsHouses(
			ExtraMuralsHousesRequest extraMuralsHousesRequest) {

		ExtraMuralsHouses extraMuralsHouses = new ExtraMuralsHouses();

		String hseAfrColour = extraMuralsHousesRequest.getHseAfrColour();
		if (null != hseAfrColour) {
			extraMuralsHouses.setHseAfrColour(extraMuralsHousesRequest.getHseAfrColour());
		}
		String hseAfrName = extraMuralsHousesRequest.getHseAfrName();
		if (null != hseAfrName) {
			extraMuralsHouses.setHseAfrName(extraMuralsHousesRequest.getHseAfrName());
		}
		String hseColour = extraMuralsHousesRequest.getHseColour();
		if (null != hseColour) {
			extraMuralsHouses.setHseColour(extraMuralsHousesRequest.getHseColour());
		}

		Integer hseID = extraMuralsHousesRequest.getHseID();
		if (null != hseID) {
			extraMuralsHouses.setHseID(hseID);
		}

		String hseName = extraMuralsHousesRequest.getHseName();
		if (null != hseName) {
			extraMuralsHouses.setHseName(extraMuralsHousesRequest.getHseName());
		}

		byte[] hsePicture = extraMuralsHousesRequest.getHsePicture();
		if (null != hsePicture) {
			extraMuralsHouses.setHsePicture(extraMuralsHousesRequest.getHsePicture());
		}

		extraMuralsHouses.setRecSelected(extraMuralsHousesRequest.isRecSelected());

		return extraMuralsHouses;
	}
}
