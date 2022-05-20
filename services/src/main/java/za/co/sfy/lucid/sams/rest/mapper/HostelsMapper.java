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

        hostels.setAddress(hostelsRequest.getAddress());
        hostels.setContactPerson(hostelsRequest.getContactPerson());
        hostels.setID(hostelsRequest.getId());
        hostels.setName(hostelsRequest.getName());
        hostels.setTel(hostelsRequest.getTel());

        return hostels;
    }
}
