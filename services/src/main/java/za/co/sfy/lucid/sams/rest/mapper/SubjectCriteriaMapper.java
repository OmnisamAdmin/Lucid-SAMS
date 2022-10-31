package za.co.sfy.lucid.sams.rest.mapper;

import java.sql.Date;
import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectCriteriaRequest;
import za.co.sfy.sams.lucid.schema.SubjectCriteria;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author Azeem
 */
@Component
public class SubjectCriteriaMapper {

    public SubjectCriteria SubjectCriteriaRequestToSubjectCriteria(SubjectCriteriaRequest subjectcriteriaRequest) {

        SubjectCriteria subjectcriteria = new SubjectCriteria();

     

        Integer subjectID = subjectcriteriaRequest.getSubjectID();
        if (null != subjectID) {
            subjectcriteria.setSubjectid(subjectID);
        }

        Integer criterionID  = subjectcriteriaRequest.getCriterionID();
        if (null != criterionID) {
            subjectcriteria.setCriterionId(criterionID);
        }

        String description = subjectcriteriaRequest.getDescription();
        if (null != description) {
               subjectcriteria.setDescription(description);
        }

         Integer grade = subjectcriteriaRequest.getGrade();  
        if (null != grade) {
               subjectcriteria.setGrade(grade);
        }

        Integer weighting = subjectcriteriaRequest.getWeighting();  
        if (null != weighting) {
               subjectcriteria.setGrade(weighting);
        }

        String subjectlevel = subjectcriteriaRequest.getSubjectLevel();
        if (null != subjectlevel) {
               subjectcriteria.setSubjectLevel(subjectlevel);
        }


           Integer criterionScore = subjectcriteriaRequest.getCriterionScore();
        if (null != criterionScore) {
            subjectcriteria.setCriterionScore(criterionScore);
        }

         String dataYear = subjectcriteriaRequest.getDataYear();
        if (null != dataYear) {
               subjectcriteria.setSubjectLevel(dataYear);
        }
   
        String subHeading = subjectcriteriaRequest.getSubHeading();
        if (null != subHeading) {
               subjectcriteria.setSubjectLevel(subHeading);
        }

         XMLGregorianCalendar dateAdded = subjectcriteriaRequest.getDateAdded();
        if (null != dateAdded) {
            subjectcriteria.setDateAdded(dateAdded);
        }

        String type = subjectcriteriaRequest.getType();
        if (null != type) {
               subjectcriteria.setType(type);
        }

        String outcomes = subjectcriteriaRequest.getOutcomes();
        if (null != outcomes) {
               subjectcriteria.setOutcomes(outcomes);
        }


        String activities = subjectcriteriaRequest.getActivities();
        if (null != activities) {
               subjectcriteria.setActivities(activities);
        }

        String assessments = subjectcriteriaRequest.getAssessments();
        if (null != assessments) {
               subjectcriteria.setAssessments(assessments);
        }

        Integer sectionID = subjectcriteriaRequest.getSectionID();
        if (null != sectionID) {
            subjectcriteria.setCriterionScore(sectionID);
         }
 
       Boolean useActivities = subjectcriteriaRequest.getUseActivities();
        if (null != useActivities) {
               subjectcriteria.setUseActivities(useActivities);
        }

       Boolean includeFFL = subjectcriteriaRequest.getIncludeFFL();
        if (null != includeFFL) {
               subjectcriteria.setIncludeFFL(includeFFL);
        }
        
        Boolean includeExam = subjectcriteriaRequest.getIncludeExam();
        if (null != includeExam) {
               subjectcriteria.setIncludeExam(includeExam);
        }
   
        String updated = subjectcriteriaRequest.getUpdated();
        if (null != updated) {
               subjectcriteria.setUpdated(updated);
        }

        Boolean quarterlyTest = subjectcriteriaRequest.getQuarterlyTest();
        if (null != quarterlyTest) {
               subjectcriteria.setQuarterlyTest(quarterlyTest);
        }

        Boolean fetCommonTest = subjectcriteriaRequest.getFETCommonTest();
        if (null != fetCommonTest) {
               subjectcriteria.setFETCommonTest(fetCommonTest);
        }

       String descriptionAfr = subjectcriteriaRequest.getDescriptionAFR();
        if (null != descriptionAfr) {
               subjectcriteria.setDescriptionAfr(descriptionAfr);
        }

        String descriptionVern = subjectcriteriaRequest.getDescriptionVern();
        if (null != descriptionVern) {
               subjectcriteria.setDescriptionVern(descriptionVern);
        }

       
        Integer taskType = subjectcriteriaRequest.getTaskType();
        if (null != taskType) {
            subjectcriteria.setTaskType(taskType);
         }

        Boolean sbaTask = subjectcriteriaRequest.getSBATask();
        if (null != sbaTask) {
               subjectcriteria.setSBATask(sbaTask);
        }

        Double sbaWeight = subjectcriteriaRequest.getSBAWeight();
        if (null != sbaWeight) {
            subjectcriteria.setSBAWeight(sbaWeight);
         }

         Integer fixedCriterionScore = subjectcriteriaRequest.getFixedCriterionScore();
        if (null != fixedCriterionScore) {
            subjectcriteria.setFixedCriterionScore(fixedCriterionScore);
         }

        Double fixedWeight = subjectcriteriaRequest.getFixedWeight();
        if (null != fixedWeight) {
            subjectcriteria.setFixedWeight(fixedWeight);
         }

        Double fixedSbaWeight = subjectcriteriaRequest.getFixedSBAWeight();
        if (null != fixedSbaWeight) {
            subjectcriteria.setFixedSBAWeight(fixedSbaWeight);
         }

        Integer subjSplitNo = subjectcriteriaRequest.getSubjSplitNo();
        if (null != subjSplitNo) {
            subjectcriteria.setSubjSplitNo(subjSplitNo);
         }
 
        Integer offSubjectId = subjectcriteriaRequest.getOFFSubjectID();
        if (null != offSubjectId) {
            subjectcriteria.setOffSubjectID(offSubjectId);
         }

        Integer offCriterionId = subjectcriteriaRequest.getOFFCriterionID();
        if (null != offCriterionId) {
            subjectcriteria.setOffCriterionId(offCriterionId);
         }

        Boolean reClocked = subjectcriteriaRequest.getRecLocked();
        if (null != reClocked) {
               subjectcriteria.setRecLocked(reClocked);
        }

         Short status = subjectcriteriaRequest.getStatus();
        if (null != status) {
            subjectcriteria.setStatus(status);
         }

        Boolean fixed0Weight = subjectcriteriaRequest.getFixed0Weight();
        if (null != fixed0Weight) {
               subjectcriteria.setFixed0Weight(fixed0Weight);
        }

        return subjectcriteria;
    }

}