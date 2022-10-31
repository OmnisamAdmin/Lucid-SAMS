package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.sams.vo.SubjectSetRequest;
import za.co.sfy.sams.lucid.schema.SubjectSets;


/**
 * @author ahussain
 */
@Component
public class SubjectSetMapper {

    public SubjectSets subjectSetRequestToSubjectSets(SubjectSetRequest subjectsetRequest) {

        SubjectSets subjectsets = new SubjectSets();

        Short description = subjectsetRequest.getDescription();
        if (null != description) {
            subjectsets.setDescription(String.valueOf(description));
        }

        Integer subjectID = subjectsetRequest.getSubjectID();
        if (null != subjectID) {
            subjectsets.setSubjectID(subjectID);
        }
        Integer subjectSetID = subjectsetRequest.getSubjectSetID();
        if (null != subjectSetID) {
            subjectsets.setSubjectID(subjectSetID);
        }
        Integer subjectSetGrade = subjectsetRequest.getSubjectSetGrade();
        if (null != subjectSetGrade) {
            subjectsets.setSubjectSetGrade(subjectSetGrade);
        }

        return subjectsets;
    }
}