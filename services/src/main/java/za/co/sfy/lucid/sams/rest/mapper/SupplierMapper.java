package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.sams.vo.SupplierRequest;
import za.co.sfy.sams.lucid.schema.Supplier;

@Component
public class SupplierMapper {

    public Supplier supplierRequestToSupplier(SupplierRequest supplierRequest) {

        Supplier supplier = new Supplier();

        Integer id = supplierRequest.getId();
        if (id != null) {
            supplier.setId(id);
        }
        supplier.setName(supplierRequest.getName());
        supplier.setDataYear(supplierRequest.getDataYear());

        return supplier;
    }
}