package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.sams.vo.ExtraMuralsRequest;
import za.co.sfy.sams.lucid.schema.ExtraMurals;

import java.util.Base64;

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
            extraMurals.setExID(exID);
        }

        String exName = extraMuralsRequest.getExName();
        if (null != exName) {
            extraMurals.setExName(extraMuralsRequest.getExName());

        }

        Integer exOfficialID = extraMuralsRequest.getExOfficialID();
        if (null != exOfficialID) {
            extraMurals.setExOfficialID(exOfficialID);
        }

        String exPicKey = extraMuralsRequest.getExPicKey();
        if (null != exPicKey) {
            extraMurals.setExPicKey(extraMuralsRequest.getExPicKey());
        }

        String exPicture = extraMuralsRequest.getExPicture();
        if (null != exPicture) {
            byte[] exPictureByteArray = Base64.getDecoder().decode(exPicture);
            extraMurals.setExPicture(exPictureByteArray);
        }

        Integer exTypeID = extraMuralsRequest.getExTypeID();
        if (null != exTypeID) {
            extraMurals.setExTypeID(exTypeID);
        }

        extraMurals.setRecLocked(extraMuralsRequest.getRecLocked());
        extraMurals.setRecSelected(extraMuralsRequest.getRecSelected());

        return extraMurals;

    }

}