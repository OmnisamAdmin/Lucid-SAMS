package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ReligionRequest;
import za.co.sfy.sams.lucid.schema.Religion;

@Component
public class ReligionMapper {

    public Religion religionRequestToReligion(ReligionRequest religionRequest) {

        Religion religion = new Religion();

        religion.setDescription(religionRequest.getDescription());
        religion.setID(religionRequest.getId());

        return religion;
    }

}
