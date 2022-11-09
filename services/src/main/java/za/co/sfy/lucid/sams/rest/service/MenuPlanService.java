package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.LstSchoolLevelResource;
import za.co.sfy.lucid.sams.resource.MenuPlanResource;
import za.co.sfy.lucid.sams.rest.mapper.MenuPlanMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.MenuPlanRequest;
import za.co.sfy.sams.vo.MenuPlanResponse;
import za.co.sfy.sams.lucid.schema.MenuPlan;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MenuPlanService {

    private final MenuPlanResource menuPlanResource;
    private final MenuPlanMapper menuPlanMapper;
    private final LstSchoolLevelResource lstSchoolLevelResource;

    @Autowired
    public MenuPlanService(final MenuPlanResource menuPlanResource, final MenuPlanMapper menuPlanMapper
            , final LstSchoolLevelResource lstSchoolLevelResource) {
        this.menuPlanResource = menuPlanResource;
        this.menuPlanMapper = menuPlanMapper;
        this.lstSchoolLevelResource = lstSchoolLevelResource;
    }

    public MenuPlanResponse saveMenuPlan(MenuPlanRequest menuPlanRequest) throws LucidSamsExecutionException {

        MenuPlan menuPlan = menuPlanMapper.menuPlanRequestToMenuPlan(menuPlanRequest);

        String schoolLevel = menuPlan.getSchoolLevel();
        ResultSet retrievedLstSchoolLevel = lstSchoolLevelResource.retrieveLstSchoolLevelByDescription(schoolLevel);
        try {
            if (!retrievedLstSchoolLevel.next()) {
                throw new LucidSamsExecutionException("Could not find Lst_School_Level with description '" + schoolLevel + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Long generatedKey = menuPlanResource.save(menuPlan, menuPlanResource);
        menuPlan.setMealCD(Math.toIntExact(generatedKey));

        MenuPlanResponse menuPlanResponse = new MenuPlanResponse();
        menuPlanResponse.setMenuPlan(menuPlan);
        menuPlanResponse.setResponseMessage("Successfully saved 'Menu_Plan' data");
        menuPlanResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return menuPlanResponse;
    }

}