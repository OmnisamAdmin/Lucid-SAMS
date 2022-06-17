package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsTypesRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTypes;

/**
 * @author muzim
 */
@Component
public class ExtraMuralsTypesMapper {

	public ExtraMuralsTypes extraMuralsTypesRequestToExtraMuralsTypes(ExtraMuralsTypesRequest extraMuralsTypesRequest) {

		ExtraMuralsTypes extraMuralsTypes = new ExtraMuralsTypes();

		String exTypeAfrName = extraMuralsTypesRequest.getExTypeAfrName();
		if (null != exTypeAfrName) {
			extraMuralsTypes.setExTypeAfrName(extraMuralsTypesRequest.getExTypeAfrName());

		}

		// TODO This is problem
		Integer exTypeID = extraMuralsTypesRequest.getExTypeID();
		if (null != exTypeID) {
			extraMuralsTypes.setExTypeID(Integer.valueOf(exTypeID));
		} else {
			extraMuralsTypes.setExTypeID(Integer.valueOf(0));
		}

		String exTypeName = extraMuralsTypesRequest.getExTypeName();
		if (null != exTypeName) {
			extraMuralsTypes.setExTypeName(extraMuralsTypesRequest.getExTypeName());

		}

		Integer exTypeOfficialID = extraMuralsTypesRequest.getExTypeOfficialID();
		if (null != exTypeOfficialID) {
			extraMuralsTypes.setExTypeOfficialID(Integer.valueOf(exTypeOfficialID));
		} else {
			extraMuralsTypes.setExTypeOfficialID(Integer.valueOf(0));

		}

		String exTypePicKey = extraMuralsTypesRequest.getExTypePicKey();
		if (null != exTypePicKey) {
			extraMuralsTypes.setExTypePicKey(extraMuralsTypesRequest.getExTypePicKey());
		}

		byte[] exTypePicture = extraMuralsTypesRequest.getExTypePicture();
		if (null != exTypePicture) {
			extraMuralsTypes.setExTypePicture(extraMuralsTypesRequest.getExTypePicture());
		}

		String exTypeShortAfrName = extraMuralsTypesRequest.getExTypeShortAfrName();
		if (null != exTypeShortAfrName) {
			extraMuralsTypes.setExTypeShortAfrName(extraMuralsTypesRequest.getExTypeShortAfrName());
		}

		String exTypeShortName = extraMuralsTypesRequest.getExTypeShortName();
		if (null != exTypeShortName) {
			extraMuralsTypes.setExTypeShortName(extraMuralsTypesRequest.getExTypeShortName());
		}

		extraMuralsTypes.setRecLocked(extraMuralsTypesRequest.isRecLocked());
		extraMuralsTypes.setRecSelected(extraMuralsTypesRequest.isRecSelected());

		return extraMuralsTypes;
	}
}
