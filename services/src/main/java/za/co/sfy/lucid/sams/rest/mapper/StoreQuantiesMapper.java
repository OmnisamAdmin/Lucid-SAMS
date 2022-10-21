package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.StoreQuantiesRequest;
import za.co.sfy.sams.lucid.schema.StoreQuanties;


@Component
public class StoreQuantiesMapper {

    public StoreQuanties storeQuantiesRequestToStoreRequest(StoreQuantiesRequest storeQuantiesRequest) {

        StoreQuanties storeQuanties = new StoreQuanties();

        Integer id = storeQuantiesRequest.getId();
        if (id != null) {
            storeQuanties.setID(id);
        }
        storeQuanties.setProductName(storeQuantiesRequest.getProductName());
        storeQuanties.setQuantity(storeQuantiesRequest.getQuantity());
        storeQuanties.setDataYear(storeQuantiesRequest.getDataYear());
        storeQuanties.setDateStocktaking(storeQuantiesRequest.getDateStocktaking());

        return storeQuanties;
    }
}
