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
import za.co.sfy.lucid.sams.rest.service.MenuPlanService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.MenuPlanRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.MenuPlanResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("menu-plans")
public class MenuPlanController {

    private static final Logger logger = LoggerFactory.getLogger(MenuPlanController.class);
    private MenuPlanService menuPlanService;

    @Autowired
    public MenuPlanController(final MenuPlanService menuPlanService) {
        this.menuPlanService = menuPlanService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MenuPlanResponse> saveMenuPlan(@Valid @RequestBody MenuPlanRequest menuPlanRequest) {

        MenuPlanResponse menuPlanResponse = new MenuPlanResponse();

        try {
            menuPlanResponse = menuPlanService.saveMenuPlan(menuPlanRequest);

        } catch (LucidSamsExecutionException exception) {
            logger.error("Failure occurred: " + exception.getMessage(), exception);
            menuPlanResponse.setResponseMessage(exception.getMessage());
            menuPlanResponse.setResponseStatus(ServiceStatus.ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(menuPlanResponse);
        }
        return ResponseEntity.ok(menuPlanResponse);
    }

}
