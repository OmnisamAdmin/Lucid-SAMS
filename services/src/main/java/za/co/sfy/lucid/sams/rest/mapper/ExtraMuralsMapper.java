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
        extraMurals.setExID(extraMuralsRequest.getExID());
        extraMurals.setExName(extraMuralsRequest.getExName());
        extraMurals.setExOfficialID(extraMuralsRequest.getExOfficialID());
        extraMurals.setExPicKey(extraMuralsRequest.getExPicKey());
        extraMurals.setExPicture(extraMuralsRequest.getExPicture());
        extraMurals.setExTypeID(extraMuralsRequest.getExTypeID());
        extraMurals.setRecLocked(extraMuralsRequest.isRecLocked());
        extraMurals.setRecSelected(extraMuralsRequest.isRecSelected());

        return extraMurals;

    }

}
