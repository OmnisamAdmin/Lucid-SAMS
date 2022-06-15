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

        String afrname = subjectsRequest.getAfrname();
        if(null != afrname) {
        subjects.setAfrname(subjectsRequest.getAfrname());
        }
        
        String code = subjectsRequest.getCode();
        if(null != code) {
        subjects.setCode(subjectsRequest.getCode());
        }
        
        Integer ctaWeight = subjectsRequest.getCTAWeight();
        if(null != ctaWeight) {
        subjects.setCTAWeight(Integer.valueOf(ctaWeight));
        } else {
        	subjectsRequest.setCTAWeight(Integer.valueOf(0));
        }
        
        Integer excludeSchedule = subjectsRequest.getExcludeSchedule();
        if(null != excludeSchedule) {
        subjects.setExcludeSchedule(Integer.valueOf(excludeSchedule));
        } else {
        	subjectsRequest.setExcludeSchedule(Integer.valueOf(0));
        }
        
        String group = subjectsRequest.getGroup();
        if(null != group) {
        subjects.setGroup(subjectsRequest.getGroup());
        }
        
        int id = subjectsRequest.getId();
        if(null != id) {
        subjects.setId(Integer.valueOf(id));
        } else {
        	subjectsRequest.setId(Integer.valueOf(0));
        }
        
        String key = subjectsRequest.getKey();
        if(null != key) {
        subjects.setKey(subjectsRequest.getKey());
        }
        
        String luritsCode = subjectsRequest.getLuritsCode();
        if(null != luritsCode) {
        subjects.setLuritsCode(subjectsRequest.getLuritsCode());
        }
        
        String name = subjectsRequest.getName();
        if(null != name) {
        subjects.setName(subjectsRequest.getName());
        }
        
        Integer officialSubjectID = subjectsRequest.getOfficialSubjectID();
        if(null != officialSubjectID) {
        subjects.setOfficialSubjectID(Integer.valueOf(officialSubjectID));
        } else {
        	subjectsRequest.setOfficialSubjectID(Integer.valueOf(0));
        }
        
        Integer phase = subjectsRequest.getPhase();
        if(null != phase) {
        subjects.setPhase(Integer.valueOf(phase));
        } else {
        	subjectsRequest.setPhase(Integer.valueOf(0));
        }
        
        Integer printOrder = subjectsRequest.getPrintOrder();
        if(null != printOrder) {
        subjects.setPrintOrder(Integer.valueOf(printOrder));
        } else {
        	subjectsRequest.setPrintOrder(Integer.valueOf(printOrder));
        }
        
        Integer selected = subjectsRequest.getSelected();
        if(null != selected) {
        subjects.setSelected(Integer.valueOf(selected));
        } else {
        	subjectsRequest.setSelected(Integer.valueOf(0));
        }
        
        Integer subjectGrade = subjectsRequest.getSubjectGrade();
        if(null != subjectGrade) {
        subjects.setSubjectGrade(Integer.valueOf(subjectGrade));
        } else {
        	subjectsRequest.setSubjectGrade(Integer.valueOf(0));
        }
        
        Short subjectStatus = subjectsRequest.getSubjectStatus();
        if(null != subjectStatus) {
        subjects.setSubjectStatus(Short.valueOf(subjectGrade));
        } else {
        	subjectsRequest.setSubjectStatus(Short.valueOf("0"));
        }

        return subjects;
    }

}
