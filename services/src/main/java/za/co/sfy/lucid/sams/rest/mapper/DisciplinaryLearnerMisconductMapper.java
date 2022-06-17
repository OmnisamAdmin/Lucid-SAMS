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
        
        String afrDesc = disciplinaryLearnerMisconductRequest.getAfrDesc();
        if(null != afrDesc) {
        disciplinaryLearnerMisconduct.setAfrDesc(disciplinaryLearnerMisconductRequest.getAfrDesc());
        }
        
        String code = disciplinaryLearnerMisconductRequest.getCode();
        if(null != code) {
        disciplinaryLearnerMisconduct.setCode(disciplinaryLearnerMisconductRequest.getCode());
        }
        
        String description = disciplinaryLearnerMisconductRequest.getDescription();
        if(null != description) {
        disciplinaryLearnerMisconduct.setDescription(disciplinaryLearnerMisconductRequest.getDescription());
        }
        
        String editStatus = disciplinaryLearnerMisconductRequest.getEditStatus();
        if(null != editStatus) {
        disciplinaryLearnerMisconduct.setEditStatus(disciplinaryLearnerMisconductRequest.getEditStatus());
        }
        
        int id = disciplinaryLearnerMisconductRequest.getId();
        if(null != id) {
        disciplinaryLearnerMisconduct.setId(Integer.valueOf(id));
        } else {
        	disciplinaryLearnerMisconductRequest.setId(Integer.valueOf(0));
        }
        
        Integer level = disciplinaryLearnerMisconductRequest.getLevel();
        if(null != level) {
        disciplinaryLearnerMisconduct.setLevel(Integer.valueOf(level));
        } else {
        	disciplinaryLearnerMisconductRequest.setLevel(Integer.valueOf(0));
        }
        
        Integer point = disciplinaryLearnerMisconductRequest.getPoint();
        if(null != point) {
        disciplinaryLearnerMisconduct.setPoint(Integer.valueOf(point));
        } else {
        	disciplinaryLearnerMisconductRequest.getPoint(Integer.valueOf(0));
        }
        
        String type = disciplinaryLearnerMisconductRequest.getType();
        if(null != type) {
        disciplinaryLearnerMisconduct.setType(disciplinaryLearnerMisconductRequest.getType());
        }
        
        return disciplinaryLearnerMisconduct;
    }
}
