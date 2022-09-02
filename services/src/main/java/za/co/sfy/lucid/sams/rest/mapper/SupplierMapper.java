package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SupplierRequest;
import za.co.sfy.sams.lucid.schema.Supplier;

@Component
public class SupplierMapper {

    public Supplier supplierRequestToSupplier(SupplierRequest supplierRequest) {

        Supplier supplier = new Supplier();

        supplier.setId(supplierRequest.getId());
        supplier.setName(supplierRequest.getName());
        supplier.setDataYear(supplierRequest.getDataYear());

        return supplier;
    }
}
