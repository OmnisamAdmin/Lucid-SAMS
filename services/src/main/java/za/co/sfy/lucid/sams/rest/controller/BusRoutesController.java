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
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.BusRoutesService;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.BusRoutesRequest;
import za.co.sfy.sams.vo.BusRoutesResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("bus-routes")
public class BusRoutesController {

    private BusRoutesService busRoutesService;
    private static final Logger logger = LoggerFactory.getLogger(BusRoutesController.class);

    @Autowired
    public BusRoutesController(final BusRoutesService busRoutesService) {
        this.busRoutesService = busRoutesService;
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BusRoutesResponse> saveBusRoutes(@Valid @RequestBody BusRoutesRequest busRoutesRequest) {

        BusRoutesResponse busRoutesResponse = new BusRoutesResponse();

        try {
            busRoutesResponse = busRoutesService.saveBusRoutes(busRoutesRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            busRoutesResponse.setResponseStatus(ServiceStatus.ERROR.value());
            busRoutesResponse.setResponseMessage(exception.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(busRoutesResponse);
        }

        return ResponseEntity.ok(busRoutesResponse);
    }
}