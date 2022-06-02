package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.FeederSchoolsRequest;
import za.co.sfy.sams.lucid.schema.FeederSchools;

@Component
public class FeederSchoolsMapper {

    public FeederSchools feederSchoolsRequestToFeederSchools(FeederSchoolsRequest feederSchoolsRequest){

        FeederSchools feederSchools = new FeederSchools();

        feederSchools.setAddress(feederSchoolsRequest.getAddress());
        feederSchools.setId(feederSchoolsRequest.getId());
        feederSchools.setName(feederSchoolsRequest.getName());
        feederSchools.setPrincipal(feederSchoolsRequest.getPrincipal());
        feederSchools.setTel(feederSchoolsRequest.getTel());

        return feederSchools;
    }
}
