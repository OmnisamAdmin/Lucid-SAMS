package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.TotalUsedIngredientsResource;
import za.co.sfy.lucid.sams.rest.mapper.TotalUsedIngredientsMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.TotalUsedIngredientsRequest;
import za.co.sfy.sams.vo.TotalUsedIngredientsResponse;
import za.co.sfy.sams.lucid.schema.TotalUsedIngredients;

@Service
public class TotalUsedIngredientsService {

    private final TotalUsedIngredientsResource totalUsedIngredientsResource;
    private final TotalUsedIngredientsMapper totalUsedIngredientsMapper;

    @Autowired
    public TotalUsedIngredientsService(final TotalUsedIngredientsResource totalUsedIngredientsResource,
                                       final TotalUsedIngredientsMapper totalUsedIngredientsMapper) {
        this.totalUsedIngredientsResource = totalUsedIngredientsResource;
        this.totalUsedIngredientsMapper = totalUsedIngredientsMapper;
    }

    public TotalUsedIngredientsResponse saveTotalUsedIngredients(TotalUsedIngredientsRequest totalUsedIngredientsRequest) throws LucidSamsExecutionException {

        //TODO: Validation needs to be done against table Menu_Plan and the feeding_day field needs to be checked if its within Calendar Term

        TotalUsedIngredients totalUsedIngredients = totalUsedIngredientsMapper
                .totalUsedIngredientsRequestToTotalUsedIngredients(totalUsedIngredientsRequest);

        Long generatedKey = totalUsedIngredientsResource.save(totalUsedIngredients, totalUsedIngredientsResource);
        totalUsedIngredients.setID(Math.toIntExact(generatedKey));

        TotalUsedIngredientsResponse totalUsedIngredientsResponse = new TotalUsedIngredientsResponse();
        totalUsedIngredientsResponse.setTotalUsedIngredients(totalUsedIngredients);
        totalUsedIngredientsResponse.setResponseMessage("Successfully saved 'Total_Used_Ingredients' data");
        totalUsedIngredientsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return totalUsedIngredientsResponse;
    }
}