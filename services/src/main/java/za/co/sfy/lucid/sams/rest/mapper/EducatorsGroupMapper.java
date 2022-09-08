package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorsGroupRequest;
import za.co.sfy.sams.lucid.schema.Educatorgroups;

/**
 * @author muzim
 */
@Component
public class EducatorsGroupMapper {

    public Educatorgroups EducatorsGroupRequestToEducatorgroups(EducatorsGroupRequest educatorsgroupRequest) {

        Educatorgroups educatorsgroup = new Educatorgroups();

     

        Integer grade = educatorsgroupRequest.getGrade();
        if (null != grade) {
         educatorsgroup.setGrade(educatorsgroupRequest.getGrade());
        }

        
           Integer educatorid = educatorsgroupRequest.getEducatorID();
        if (null != educatorid) {
            educatorsgroup.setEducatorID(educatorsgroupRequest.getEducatorID());
        }



         Integer subjectid = educatorsgroupRequest.getSubjectID();
        if (null != subjectid) {
            educatorsgroup.setSubjectID(educatorsgroupRequest.getSubjectID());
        }
       
        return educatorsgroup;
    }

}

