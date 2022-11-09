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
import za.co.sfy.lucid.sams.rest.service.StoreQuantiesService;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.StoreQuantiesRequest;
import za.co.sfy.sams.vo.StoreQuantiesResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("store-quanties")
public class StoreQuantiesController {

    private static final Logger logger = LoggerFactory.getLogger(StoreQuantiesController.class);
    private StoreQuantiesService storeQuantiesService;

    @Autowired
    public StoreQuantiesController(final StoreQuantiesService storeQuantiesService) {
        this.storeQuantiesService = storeQuantiesService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StoreQuantiesResponse> saveStoreQuanties(@Valid @RequestBody StoreQuantiesRequest storeQuantiesRequest) {

        StoreQuantiesResponse storeQuantiesResponse = new StoreQuantiesResponse();

        try {
            storeQuantiesResponse = storeQuantiesService.saveStoreQuanties(storeQuantiesRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            storeQuantiesResponse.setResponseMessage(exception.getMessage());
            storeQuantiesResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(storeQuantiesResponse);
        }

        return ResponseEntity.ok(storeQuantiesResponse);
    }
}