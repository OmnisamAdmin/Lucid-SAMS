package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.DeliveryReceivedResource;
import za.co.sfy.lucid.sams.rest.mapper.DeliveryReceivedMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DeliveryReceivedRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DeliveryReceivedResponse;
import za.co.sfy.sams.lucid.schema.DeliveryRecieved;

@Service
public class DeliveryReceivedService {

    private final DeliveryReceivedResource deliveryReceivedResource;
    private final DeliveryReceivedMapper deliveryReceivedMapper;

    @Autowired
    public DeliveryReceivedService(final DeliveryReceivedResource deliveryReceivedResource, final DeliveryReceivedMapper deliveryReceivedMapper) {
        this.deliveryReceivedResource = deliveryReceivedResource;
        this.deliveryReceivedMapper = deliveryReceivedMapper;
    }

    public DeliveryReceivedResponse saveDeliveryReceived(DeliveryReceivedRequest deliveryReceivedRequest) throws LucidSamsExecutionException {
        DeliveryRecieved deliveryRecieved = deliveryReceivedMapper.deliveryReceivedRequestToDeliveryReceived(deliveryReceivedRequest);

        //TODO: Validate data against supplier table
        Long generatedKey = deliveryReceivedResource.save(deliveryRecieved, deliveryReceivedResource);
        deliveryRecieved.setID(Math.toIntExact(generatedKey));

        DeliveryReceivedResponse deliveryReceivedResponse = new DeliveryReceivedResponse();
        deliveryReceivedResponse.setDeliveryRecieved(deliveryRecieved);
        deliveryReceivedResponse.setResponseMessage("Successfully saved 'Delivery_Received' data");
        deliveryReceivedResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return deliveryReceivedResponse;
    }

}
