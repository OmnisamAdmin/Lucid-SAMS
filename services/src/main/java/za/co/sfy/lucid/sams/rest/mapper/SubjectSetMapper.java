package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectSetRequest;
import za.co.sfy.sams.lucid.schema.SubjectSets;


/**
 * @author muzim
 */
@Component
public class SubjectSetMapper {

    public SubjectSets SubjectSetRequestToSubjectSets(SubjectSetRequest subjectsetRequest) {

         SubjectSets subjectsets = new SubjectSets();

      Short description = subjectsetRequest.getDescription();
        if (null != description) {
            subjectsets.setDescription(subjectsetRequest.getDescription());
        }

     Integer subjectID = subjectsetRequest.getSubjectID();
        if (null != subjectID) {
            subjectsets.setSubjectID(subjectsetRequest.getSubjectID());
        }
     Integer subjectsetID = subjectsetRequest.getSubjectSetID();
        if (null != subjectsetID) {
            subjectsets.setSubjectID(subjectsetRequest.getSubjectSetID());
        }
     Integer subjectsetgrade = subjectsetRequest.getSubjectSetGrade();
        if (null != subjectsetgrade) {
            subjectsets.setSubjectSetGrade(subjectsetRequest.getSubjectSetGrade());
        }
            

        
        return subjectsets;
    }

    public SubjectSets subjectsetRequestTosubjectsets(SubjectSetRequest subjectsetRequest) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

