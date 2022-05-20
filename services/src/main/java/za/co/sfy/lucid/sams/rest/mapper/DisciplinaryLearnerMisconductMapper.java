package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DisciplinaryLearnerMisconductRequest;
import za.co.sfy.sams.lucid.schema.DisciplinaryLearnerMisconduct;

/**
 * @author muzim
 */
@Component
public class DisciplinaryLearnerMisconductMapper {

    public DisciplinaryLearnerMisconduct DisciplinaryLearnerMisconductRequestToDisciplinaryLearnerMisconduct
            (DisciplinaryLearnerMisconductRequest disciplinaryLearnerMisconductRequest) {

        DisciplinaryLearnerMisconduct disciplinaryLearnerMisconduct = new DisciplinaryLearnerMisconduct();

        disciplinaryLearnerMisconduct.setAfrDesc(disciplinaryLearnerMisconductRequest.getAfrDesc());
        disciplinaryLearnerMisconduct.setCode(disciplinaryLearnerMisconductRequest.getCode());
        disciplinaryLearnerMisconduct.setDescription(disciplinaryLearnerMisconductRequest.getDescription());
        disciplinaryLearnerMisconduct.setEditStatus(disciplinaryLearnerMisconductRequest.getEditStatus());
        disciplinaryLearnerMisconduct.setId(disciplinaryLearnerMisconductRequest.getId());
        disciplinaryLearnerMisconduct.setLevel(disciplinaryLearnerMisconductRequest.getLevel());
        disciplinaryLearnerMisconduct.setPoint(disciplinaryLearnerMisconductRequest.getPoint());
        disciplinaryLearnerMisconduct.setType(disciplinaryLearnerMisconductRequest.getType());

        return disciplinaryLearnerMisconduct;
    }
}
