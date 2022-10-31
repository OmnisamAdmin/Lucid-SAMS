package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.DeliveryReceivedResource;
import za.co.sfy.lucid.sams.resource.LstFoodGroupResource;
import za.co.sfy.lucid.sams.resource.LstProductsResource;
import za.co.sfy.lucid.sams.resource.SupplierResource;
import za.co.sfy.lucid.sams.rest.mapper.DeliveryReceivedMapper;
import za.co.sfy.sams.vo.DeliveryReceivedRequest;
import za.co.sfy.sams.vo.DeliveryReceivedResponse;
import za.co.sfy.sams.lucid.schema.DeliveryRecieved;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DeliveryReceivedService {

    private final DeliveryReceivedResource deliveryReceivedResource;
    private final DeliveryReceivedMapper deliveryReceivedMapper;
    private final SupplierResource supplierResource;
    private final LstFoodGroupResource lstFoodGroupResource;
    private final LstProductsResource lstProductsResource;

    @Autowired
    public DeliveryReceivedService(final DeliveryReceivedResource deliveryReceivedResource, final DeliveryReceivedMapper deliveryReceivedMapper
            , final SupplierResource supplierResource, final LstFoodGroupResource lstFoodGroupResource
            , final LstProductsResource lstProductsResource) {
        this.deliveryReceivedResource = deliveryReceivedResource;
        this.deliveryReceivedMapper = deliveryReceivedMapper;
        this.supplierResource = supplierResource;
        this.lstFoodGroupResource = lstFoodGroupResource;
        this.lstProductsResource = lstProductsResource;
    }

    public DeliveryReceivedResponse saveDeliveryReceived(DeliveryReceivedRequest deliveryReceivedRequest) throws LucidSamsExecutionException {
        DeliveryRecieved deliveryRecieved = deliveryReceivedMapper.deliveryReceivedRequestToDeliveryReceived(deliveryReceivedRequest);

        String supplier = deliveryRecieved.getSupplier();
        ResultSet retrievedSupplier = supplierResource.retrieveSupplierByName(supplier);
        try {
            if (!retrievedSupplier.next()) {
                throw new LucidSamsExecutionException("The given 'supplier' - " + supplier + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Integer foodGroup = deliveryRecieved.getFoodGroup();
        ResultSet retrievedLstFoodGroup = lstFoodGroupResource.retrieveLstFoodGroupByProductCD(Long.valueOf(foodGroup));
        try {
            if (!retrievedLstFoodGroup.next()) {
                throw new LucidSamsExecutionException("The given 'lst_Food_Group' - " + foodGroup + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        String productName = deliveryRecieved.getProductName();
        ResultSet retrievedLstProducts = lstProductsResource.retrieveLstProductsByDescription(productName);
        try {
            if (!retrievedLstProducts.next()) {
                throw new LucidSamsExecutionException("The given 'lst_Products' - " + productName + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Long generatedKey = deliveryReceivedResource.save(deliveryRecieved, deliveryReceivedResource);
        deliveryRecieved.setID(Math.toIntExact(generatedKey));

        DeliveryReceivedResponse deliveryReceivedResponse = new DeliveryReceivedResponse();
        deliveryReceivedResponse.setDeliveryRecieved(deliveryRecieved);
        deliveryReceivedResponse.setResponseMessage("Successfully saved 'Delivery_Received' data");
        deliveryReceivedResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return deliveryReceivedResponse;
    }

}