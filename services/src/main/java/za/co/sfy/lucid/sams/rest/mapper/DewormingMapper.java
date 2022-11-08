package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DewormingRequest;
import za.co.sfy.sams.lucid.schema.Deworming;

@Component
public class DewormingMapper {
    public Deworming dewormingRequestToDeworming(DewormingRequest dewormingRequest) {
        Deworming deworming = new Deworming();
        Integer id = dewormingRequest.getId();
        if (id != null) {
            deworming.setID(id);
        }
        deworming.setDatayear(dewormingRequest.getDatayear());
        deworming.setGender(dewormingRequest.getGender());
        deworming.setTotalDewormed(dewormingRequest.getTotalDewormed());
        deworming.setGrade(dewormingRequest.getGrade());
        deworming.setTotalEducatorsOrientated(dewormingRequest.getTotalEducatorsOrientated());
        deworming.setTotalWithSideEffects(dewormingRequest.getTotalWithSideEffects());
        return deworming;
    }
}
