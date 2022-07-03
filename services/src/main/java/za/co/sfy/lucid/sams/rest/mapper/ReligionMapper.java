package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ReligionRequest;
import za.co.sfy.sams.lucid.schema.Religion;

@Component
public class ReligionMapper {

    public Religion religionRequestToReligion(ReligionRequest religionRequest) {

        Religion religion = new Religion();

        String description = religionRequest.getDescription();
        if (null != description) {
        religion.setDescription(religionRequest.getDescription());
        }
        
        Integer id = religionRequest.getId();
        if (null != id) {
        religion.setID(id);
        } else {
        	religionRequest.setId(0);
        }
        
        return religion;
    }

}
