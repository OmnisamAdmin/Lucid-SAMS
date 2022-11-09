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
import za.co.sfy.lucid.sams.rest.service.TotalUsedIngredientsService;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.TotalUsedIngredientsRequest;
import za.co.sfy.sams.vo.TotalUsedIngredientsResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("total-used-ingredients")
public class TotalUsedIngredientsController {

    private static final Logger logger = LoggerFactory.getLogger(TotalUsedIngredientsController.class);
    private TotalUsedIngredientsService totalUsedIngredientsService;

    @Autowired
    public TotalUsedIngredientsController(final TotalUsedIngredientsService totalUsedIngredientsService) {
        this.totalUsedIngredientsService = totalUsedIngredientsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TotalUsedIngredientsResponse> saveTotalUsedIngredients(@Valid @RequestBody TotalUsedIngredientsRequest totalUsedIngredientsRequest) {

        TotalUsedIngredientsResponse totalUsedIngredientsResponse = new TotalUsedIngredientsResponse();

        try {
            totalUsedIngredientsResponse = totalUsedIngredientsService.saveTotalUsedIngredients(totalUsedIngredientsRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            totalUsedIngredientsResponse.setResponseMessage(exception.getMessage());
            totalUsedIngredientsResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(totalUsedIngredientsResponse);
        }

        return ResponseEntity.ok(totalUsedIngredientsResponse);
    }
}