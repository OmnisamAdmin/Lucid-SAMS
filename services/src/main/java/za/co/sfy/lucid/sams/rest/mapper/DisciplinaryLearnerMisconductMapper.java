package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.sams.vo.DisciplinaryLearnerMisconductRequest;
import za.co.sfy.sams.lucid.schema.DisciplinaryLearnerMisconduct;

/**
 * @author muzim
 */
@Component
public class DisciplinaryLearnerMisconductMapper {

    public DisciplinaryLearnerMisconduct DisciplinaryLearnerMisconductRequestToDisciplinaryLearnerMisconduct
            (DisciplinaryLearnerMisconductRequest disciplinaryLearnerMisconductRequest) {

        DisciplinaryLearnerMisconduct disciplinaryLearnerMisconduct = new DisciplinaryLearnerMisconduct();
        
        String afrDesc = disciplinaryLearnerMisconductRequest.getAfrDesc();
        if (null != afrDesc) {
        disciplinaryLearnerMisconduct.setAfrDesc(disciplinaryLearnerMisconductRequest.getAfrDesc());
        }
        
        String code = disciplinaryLearnerMisconductRequest.getCode();
        if (null != code) {
        disciplinaryLearnerMisconduct.setCode(disciplinaryLearnerMisconductRequest.getCode());
        }
        
        String description = disciplinaryLearnerMisconductRequest.getDescription();
        if (null != description) {
        disciplinaryLearnerMisconduct.setDescription(disciplinaryLearnerMisconductRequest.getDescription());
        }
        
        String editStatus = disciplinaryLearnerMisconductRequest.getEditStatus();
        if (null != editStatus) {
        disciplinaryLearnerMisconduct.setEditStatus(disciplinaryLearnerMisconductRequest.getEditStatus());
        }

        Integer id = disciplinaryLearnerMisconductRequest.getId();
        if (null != id) {
            disciplinaryLearnerMisconduct.setId(id);
        }
        
        Integer level = disciplinaryLearnerMisconductRequest.getLevel();
        if (null != level) {
        disciplinaryLearnerMisconduct.setLevel(level);
        }

        Integer point = disciplinaryLearnerMisconductRequest.getPoint();
        if (null != point) {
            disciplinaryLearnerMisconduct.setPoint(point);
        }
        
        String type = disciplinaryLearnerMisconductRequest.getType();
        if (null != type) {
        disciplinaryLearnerMisconduct.setType(disciplinaryLearnerMisconductRequest.getType());
        }
        
        return disciplinaryLearnerMisconduct;
    }
}