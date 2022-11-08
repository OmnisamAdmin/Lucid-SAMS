package za.co.sfy.lucid.sams.rest.mapper;
import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearningBarriersRequest;
import za.co.sfy.sams.lucid.schema.LearningBarriers;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class LearningBarriersMapper {
    private final SharedMapper sharedMapper;

    public LearningBarriersMapper(SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public LearningBarriers learningBarriersRequestToLearningBarriers(LearningBarriersRequest learningBarriersRequest) throws LucidSamsExecutionException {
        LearningBarriers learningBarriers = new LearningBarriers();
        Integer id = learningBarriersRequest.getId();
        if (id != null) {
            learningBarriers.setId(id);
        }
        String date = learningBarriersRequest.getDate();
        if (null != date) {
            XMLGregorianCalendar convertedDate = sharedMapper.dateToXMLGregorianCalendar(date);
            learningBarriers.setDate(convertedDate);
        }
        learningBarriers.setLearnerid(learningBarriersRequest.getLearnerId());
        learningBarriers.setComment(learningBarriersRequest.getComment());
        learningBarriers.setBarriercode(learningBarriersRequest.getBarrierCode());
        learningBarriers.setActionCode(learningBarriersRequest.getActionCode());
        return learningBarriers;
    }
}
