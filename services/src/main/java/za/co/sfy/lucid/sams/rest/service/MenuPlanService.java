package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.MenuPlanResource;
import za.co.sfy.lucid.sams.rest.mapper.MenuPlanMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.MenuPlanRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.MenuPlanResponse;
import za.co.sfy.sams.lucid.schema.MenuPlan;

@Service
public class MenuPlanService {

    private final MenuPlanResource menuPlanResource;
    private final MenuPlanMapper menuPlanMapper;

    @Autowired
    public MenuPlanService(final MenuPlanResource menuPlanResource, final MenuPlanMapper menuPlanMapper) {
        this.menuPlanResource = menuPlanResource;
        this.menuPlanMapper = menuPlanMapper;
    }

    public MenuPlanResponse saveMenuPlan(MenuPlanRequest menuPlanRequest) throws LucidSamsExecutionException {

        MenuPlan menuPlan = menuPlanMapper.menuPlanRequestToMenuPlan(menuPlanRequest);

        Long generatedKey = menuPlanResource.save(menuPlan, menuPlanResource);
        menuPlan.setMealCD(Math.toIntExact(generatedKey));

        MenuPlanResponse menuPlanResponse = new MenuPlanResponse();
        menuPlanResponse.setMenuPlan(menuPlan);
        menuPlanResponse.setResponseMessage("Successfully saved 'Menu_Plan' data");
        menuPlanResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return menuPlanResponse;
    }

}
