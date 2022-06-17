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

        String afrName = subjectsRequest.getAfrname();
        if (null != afrName) {
        subjects.setAfrname(subjectsRequest.getAfrname());
        }
        
        String code = subjectsRequest.getCode();
        if (null != code) {
        subjects.setCode(subjectsRequest.getCode());
        }
        
        Integer ctaWeight = subjectsRequest.getCTAWeight();
        if (null != ctaWeight) {
        subjects.setCTAWeight(ctaWeight);
        } else {
        	subjectsRequest.setCTAWeight(0);
        }
        
        Integer excludeSchedule = subjectsRequest.getExcludeSchedule();
        if (null != excludeSchedule) {
        subjects.setExcludeSchedule(excludeSchedule);
        } else {
        	subjectsRequest.setExcludeSchedule(0);
        }
        
        String group = subjectsRequest.getGroup();
        if (null != group) {
        subjects.setGroup(subjectsRequest.getGroup());
        }
        
        Integer id = subjectsRequest.getId();
        if (null != id) {
        subjects.setId(id);
        } else {
        	subjectsRequest.setId(0);
        }
        
        String key = subjectsRequest.getKey();
        if (null != key) {
        subjects.setKey(subjectsRequest.getKey());
        }
        
        String luritsCode = subjectsRequest.getLuritsCode();
        if (null != luritsCode) {
        subjects.setLuritsCode(subjectsRequest.getLuritsCode());
        }
        
        String name = subjectsRequest.getName();
        if (null != name) {
        subjects.setName(subjectsRequest.getName());
        }
        
        Integer officialSubjectID = subjectsRequest.getOfficialSubjectID();
        if (null != officialSubjectID) {
        subjects.setOfficialSubjectID(officialSubjectID);
        } else {
        	subjectsRequest.setOfficialSubjectID(0);
        }
        
        Integer phase = subjectsRequest.getPhase();
        if (null != phase) {
        subjects.setPhase(phase);
        } else {
        	subjectsRequest.setPhase(0);
        }
        
        Integer printOrder = subjectsRequest.getPrintOrder();
        if (null != printOrder) {
        subjects.setPrintOrder(printOrder);
        } else {
        	subjectsRequest.setPrintOrder(0);
        }
        
        Integer selected = subjectsRequest.getSelected();
        if (null != selected) {
        subjects.setSelected(selected);
        } else {
        	subjectsRequest.setSelected(0);
        }
        
        Integer subjectGrade = subjectsRequest.getSubjectGrade();
        if (null != subjectGrade) {
        subjects.setSubjectGrade(subjectGrade);
        } else {
        	subjectsRequest.setSubjectGrade(0);
        }
        
        Short subjectStatus = subjectsRequest.getSubjectStatus();
        if (null != subjectStatus) {
        subjects.setSubjectStatus(subjectStatus);
        } else {
        	subjectsRequest.setSubjectStatus(Short.valueOf("0"));
        }

        return subjects;
    }

}