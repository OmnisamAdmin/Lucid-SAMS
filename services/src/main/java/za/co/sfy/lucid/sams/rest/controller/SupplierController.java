package za.co.sfy.lucid.sams.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.SupplierService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SupplierRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SupplierResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("suppliers")
public class SupplierController {

    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);
    private SupplierService supplierService;

    @Autowired
    public SupplierController(final SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SupplierResponse> saveSupplier(@Valid @RequestBody SupplierRequest supplierRequest) {

        SupplierResponse supplierResponse = new SupplierResponse();

        try {
            supplierResponse = supplierService.saveSupplier(supplierRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            supplierResponse.setResponseStatus(exception.getMessage());
            supplierResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(supplierResponse);
        }

        return ResponseEntity.ok(supplierResponse);
    }

}
