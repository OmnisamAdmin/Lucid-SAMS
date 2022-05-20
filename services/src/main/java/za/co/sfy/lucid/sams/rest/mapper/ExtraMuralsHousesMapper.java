package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsHousesRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsHouses;

/**
 * @author muzim
 */
@Component
public class ExtraMuralsHousesMapper {

    public ExtraMuralsHouses extraMuralsHousesRequestToExtraMuralsHouses(ExtraMuralsHousesRequest extraMuralsHousesRequest) {

        ExtraMuralsHouses extraMuralsHouses = new ExtraMuralsHouses();

        extraMuralsHouses.setHseAfrColour(extraMuralsHousesRequest.getHseAfrColour());
        extraMuralsHouses.setHseAfrName(extraMuralsHousesRequest.getHseAfrName());
        extraMuralsHouses.setHseColour(extraMuralsHousesRequest.getHseColour());
        extraMuralsHouses.setHseID(extraMuralsHousesRequest.getHseID());
        extraMuralsHouses.setHseName(extraMuralsHousesRequest.getHseName());
        extraMuralsHouses.setHsePicture(extraMuralsHousesRequest.getHsePicture());
        extraMuralsHouses.setRecSelected(extraMuralsHousesRequest.isRecSelected());

        return extraMuralsHouses;
    }
}
