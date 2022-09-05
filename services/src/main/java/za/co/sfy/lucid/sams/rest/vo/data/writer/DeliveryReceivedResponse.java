package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.DeliveryRecieved;

public class DeliveryReceivedResponse extends ApiResponse {

    private static final long serialVersionUID = -8968264510551738269L;

    private DeliveryRecieved deliveryRecieved;

    public DeliveryRecieved getDeliveryRecieved() {
        return deliveryRecieved;
    }

    public void setDeliveryRecieved(DeliveryRecieved deliveryRecieved) {
        this.deliveryRecieved = deliveryRecieved;
    }
}
