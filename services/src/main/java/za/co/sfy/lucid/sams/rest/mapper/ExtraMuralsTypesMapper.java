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

        extraMuralsTypes.setExTypeAfrName(extraMuralsTypesRequest.getExTypeAfrName());
        extraMuralsTypes.setExTypeID(extraMuralsTypesRequest.getExTypeID());
        extraMuralsTypes.setExTypeName(extraMuralsTypesRequest.getExTypeName());
        extraMuralsTypes.setExTypeOfficialID(extraMuralsTypesRequest.getExTypeOfficialID());
        extraMuralsTypes.setExTypePicKey(extraMuralsTypesRequest.getExTypePicKey());
        extraMuralsTypes.setExTypePicture(extraMuralsTypesRequest.getExTypePicture());
        extraMuralsTypes.setExTypeShortAfrName(extraMuralsTypesRequest.getExTypeShortAfrName());
        extraMuralsTypes.setExTypeShortName(extraMuralsTypesRequest.getExTypeShortName());
        extraMuralsTypes.setRecLocked(extraMuralsTypesRequest.isRecLocked());
        extraMuralsTypes.setRecSelected(extraMuralsTypesRequest.isRecSelected());

        return extraMuralsTypes;
    }
}
