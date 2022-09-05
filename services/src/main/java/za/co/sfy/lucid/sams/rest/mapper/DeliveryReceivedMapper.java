package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DeliveryReceivedRequest;
import za.co.sfy.sams.lucid.schema.DeliveryRecieved;


@Component
public class DeliveryReceivedMapper {

    public DeliveryRecieved deliveryReceivedRequestToDeliveryReceived(DeliveryReceivedRequest deliveryReceivedRequest) {
        DeliveryRecieved deliveryRecieved = new DeliveryRecieved();

        deliveryRecieved.setSupplier(deliveryReceivedRequest.getSupplier());
        deliveryRecieved.setDateRecieved(deliveryReceivedRequest.getDateRecieved());
        deliveryRecieved.setProductName(deliveryReceivedRequest.getProductName());
        deliveryRecieved.setAprovedQuantity(deliveryReceivedRequest.getAprovedQuantity());
        deliveryRecieved.setQuantityOrdered(deliveryReceivedRequest.getQuantityOrdered());
        deliveryRecieved.setQuantity(deliveryReceivedRequest.getQuantity());
        deliveryRecieved.setFoodGroup(deliveryReceivedRequest.getFoodGroup());
        deliveryRecieved.setDataYear(deliveryReceivedRequest.getDataYear());
        deliveryRecieved.setLeftQuantity(deliveryReceivedRequest.getLeftQuantity());
        deliveryRecieved.setInstore(deliveryReceivedRequest.getInstore());

        return deliveryRecieved;

    }
}
