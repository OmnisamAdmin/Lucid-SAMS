package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.SupplierResource;
import za.co.sfy.lucid.sams.rest.mapper.SupplierMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.SupplierRequest;
import za.co.sfy.sams.vo.SupplierResponse;
import za.co.sfy.sams.lucid.schema.Supplier;

@Service
public class SupplierService {

    private final SupplierResource supplierResource;
    private final SupplierMapper supplierMapper;

    @Autowired
    public SupplierService(final SupplierResource supplierResource, final SupplierMapper supplierMapper) {
        this.supplierResource = supplierResource;
        this.supplierMapper = supplierMapper;
    }

    public SupplierResponse saveSupplier(SupplierRequest supplierRequest) throws LucidSamsExecutionException {

        Supplier supplier = supplierMapper.supplierRequestToSupplier(supplierRequest);

        Long generatedKey = supplierResource.save(supplier, supplierResource);
        supplier.setId(Math.toIntExact(generatedKey));

        SupplierResponse supplierResponse = new SupplierResponse();
        supplierResponse.setSupplier(supplier);
        supplierResponse.setResponseMessage("Successfully saved 'Supplier' data");
        supplierResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return supplierResponse;
    }

}