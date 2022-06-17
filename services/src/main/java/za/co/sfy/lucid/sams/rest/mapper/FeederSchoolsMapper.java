package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.FeederSchoolsRequest;
import za.co.sfy.sams.lucid.schema.FeederSchools;

@Component
public class FeederSchoolsMapper {

	public FeederSchools feederSchoolsRequestToFeederSchools(FeederSchoolsRequest feederSchoolsRequest) {

		FeederSchools feederSchools = new FeederSchools();

		String address = feederSchoolsRequest.getAddress();
		if (null != address) {
			feederSchools.setAddress(feederSchoolsRequest.getAddress());
		}

		Integer id = feederSchoolsRequest.getId();
		if (null != id) {
			feederSchools.setId(id);
		}

		String name = feederSchoolsRequest.getName();
		if (null != name) {
			feederSchools.setName(feederSchoolsRequest.getName());
		}

		String principal = feederSchoolsRequest.getPrincipal();
		if (null != principal) {
			feederSchools.setPrincipal(feederSchoolsRequest.getPrincipal());
		}

		String tel = feederSchoolsRequest.getTel();
		if (null != tel) {
			feederSchools.setTel(feederSchoolsRequest.getTel());
		}

		return feederSchools;
	}
}
