package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectsRequest;
import za.co.sfy.sams.lucid.schema.Subjects;

/**
 * @author muzim
 */
@Component
public class SubjectsMapper {

    public Subjects subjectsRequestToSubjects(SubjectsRequest subjectsRequest) {

        Subjects subjects = new Subjects();

        subjects.setAfrname(subjectsRequest.getAfrname());
        subjects.setCode(subjectsRequest.getCode());
        subjects.setCTAWeight(subjectsRequest.getCTAWeight());
        subjects.setExcludeSchedule(subjectsRequest.getExcludeSchedule());
        subjects.setGroup(subjectsRequest.getGroup());
        subjects.setId(subjectsRequest.getId());
        subjects.setKey(subjectsRequest.getKey());
        subjects.setLuritsCode(subjectsRequest.getLuritsCode());
        subjects.setName(subjectsRequest.getName());
        subjects.setOfficialSubjectID(subjectsRequest.getOfficialSubjectID());
        subjects.setPhase(subjectsRequest.getPhase());
        subjects.setPrintOrder(subjectsRequest.getPrintOrder());
        subjects.setSelected(subjectsRequest.getSelected());
        subjects.setSubjectGrade(subjectsRequest.getSubjectGrade());
        subjects.setSubjectStatus(subjectsRequest.getSubjectStatus());

        return subjects;
    }

}
