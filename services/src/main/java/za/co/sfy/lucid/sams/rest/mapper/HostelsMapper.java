package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.HostelsRequest;
import za.co.sfy.sams.lucid.schema.Hostels;

/**
 * @author muzim
 */
@Component
public class HostelsMapper {

	public Hostels hostelsRequestToHostels(HostelsRequest hostelsRequest) {

		Hostels hostels = new Hostels();

		String address = hostelsRequest.getAddress();
		if (null != address) {
			hostels.setAddress(hostelsRequest.getAddress());
		}

		String contactPerson = hostelsRequest.getContactPerson();
		if (null != contactPerson) {
			hostels.setContactPerson(hostelsRequest.getContactPerson());
		}

		Integer id = hostelsRequest.getId();
		if (null != id) {
			hostels.setID(Integer.valueOf(id));
		} else {
			hostels.setID(Integer.valueOf(0));
		}

		String name = hostelsRequest.getName();
		if (null != name) {
			hostels.setName(hostelsRequest.getName());
		}

		String setTel = hostelsRequest.getTel();
		if (null != setTel) {
			hostels.setTel(hostelsRequest.getTel());
		}

		return hostels;
	}
}