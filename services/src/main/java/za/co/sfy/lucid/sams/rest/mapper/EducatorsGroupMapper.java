package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.sams.vo.EducatorsGroupRequest;
import za.co.sfy.sams.lucid.schema.Educatorgroups;

/**
 * @author ahussain
 */
@Component
public class EducatorsGroupMapper {

    public Educatorgroups EducatorsGroupRequestToEducatorGroups(EducatorsGroupRequest educatorsgroupRequest) {

        Educatorgroups educatorsGroup = new Educatorgroups();

        Integer grade = educatorsgroupRequest.getGrade();
        if (null != grade) {
         educatorsGroup.setGrade(grade);
        }
           Integer educatorID = educatorsgroupRequest.getEducatorID();
        if (null != educatorID) {
            educatorsGroup.setEducatorGroupID(educatorID);
        }

         Integer subjectID = educatorsgroupRequest.getSubjectID();
        if (null != subjectID) {
            educatorsGroup.setSubjectId(subjectID);
        }
       
        return educatorsGroup;
    }
}