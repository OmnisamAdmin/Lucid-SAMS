package za.co.sfy.lucid.sams.rest.mapper;

import java.sql.Date;
import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectCriteriaRequest;
import za.co.sfy.sams.lucid.schema.SubjectCriteria;

/**
 * @author Azeem
 */
@Component
public class SubjectCriteriaMapper {

    public SubjectCriteria SubjectCriteriaRequestToSubjectCriteria(SubjectCriteriaRequest subjectcriteriaRequest) {

        SubjectCriteria subjectcriteria = new SubjectCriteria();

     

        Integer subjectID = subjectcriteriaRequest.getSubjectID();
        if (null != subjectID) {
            subjectcriteria.setSubjectID(subjectcriteriaRequest.getSubjectID());
        }

        Integer criterionID  = subjectcriteriaRequest.getCriterionID();
        if (null != criterionID) {
            subjectcriteria.setCriterionID(subjectcriteriaRequest.getCriterionID());
        }

        Short description = subjectcriteriaRequest.getDescription();
        if (null != description) {
               subjectcriteria.setDescription(subjectcriteriaRequest.getDescription());
        }

         Integer grade = subjectcriteriaRequest.getGrade();  
        if (null != grade) {
               subjectcriteria.setGrade(subjectcriteriaRequest.getGrade());
        }

        Integer weighting = subjectcriteriaRequest.getWeighting();  
        if (null != weighting) {
               subjectcriteria.setGrade(subjectcriteriaRequest.getWeighting());
        }

          Short subjectlevel = subjectcriteriaRequest.getSubjectLevel();
        if (null != subjectlevel) {
               subjectcriteria.setSubjectLevel(subjectcriteriaRequest.getSubjectLevel());
        }


           Integer criterionscore = subjectcriteriaRequest.getCriterionScore();
        if (null != criterionscore) {
            subjectcriteria.setCriterionScore(subjectcriteriaRequest.getCriterionScore());
        }

         Short datayear = subjectcriteriaRequest.getDataYear();
        if (null != datayear) {
               subjectcriteria.setSubjectLevel(subjectcriteriaRequest.getDataYear());
        }
   
        Short subheading = subjectcriteriaRequest.getSubHeading();
        if (null != subheading) {
               subjectcriteria.setSubjectLevel(subjectcriteriaRequest.getSubHeading());
        }

         Date dateadded = subjectcriteriaRequest.getDateAdded();
        if (null != dateadded) {
            subjectcriteria.setDateAdded((subjectcriteriaRequest.getDateAdded()));
        }

        Short type = subjectcriteriaRequest.getType();
        if (null != type) {
               subjectcriteria.setType(subjectcriteriaRequest.getType());
        }

        Long outcomes = subjectcriteriaRequest.getOutcomes();
        if (null != outcomes) {
               subjectcriteria.setOutcomes(subjectcriteriaRequest.getOutcomes());
        }


        Long activities = subjectcriteriaRequest.getActivities();
        if (null != activities) {
               subjectcriteria.setActivities(subjectcriteriaRequest.getActivities());
        }

        Long assessments = subjectcriteriaRequest.getAssessments();
        if (null != assessments) {
               subjectcriteria.setAssessments(subjectcriteriaRequest.getAssessments());
        }

        Integer sectionID = subjectcriteriaRequest.getSectionID();
        if (null != sectionID) {
            subjectcriteria.setCriterionScore(subjectcriteriaRequest.getSectionID());
         }
 
       Boolean useactivities = subjectcriteriaRequest.getUseActivities();
        if (null != useactivities) {
               subjectcriteria.setUseActivities((subjectcriteriaRequest.getUseActivities()));
        }

       Boolean includeFFL = subjectcriteriaRequest.getIncludeFFL();
        if (null != includeFFL) {
               subjectcriteria.setIncludeFFL((subjectcriteriaRequest.getUseActivities()));
        }
        
        Boolean includeExam = subjectcriteriaRequest.getIncludeExam();
        if (null != includeExam) {
               subjectcriteria.setIncludeExam((subjectcriteriaRequest.getIncludeExam()));
        }
   
        Short updated = subjectcriteriaRequest.getUpdated();
        if (null != updated) {
               subjectcriteria.setUpdated(subjectcriteriaRequest.getUpdated());
        }

        Boolean quaterlytest = subjectcriteriaRequest.getQuaterlyTest();
        if (null != quaterlytest) {
               subjectcriteria.setQuaterlyTest(subjectcriteriaRequest.getQuaterlyTest());
        }

        Boolean fetcommontest = subjectcriteriaRequest.getFETCommonTest();
        if (null != fetcommontest) {
               subjectcriteria.setFETCommonTest((subjectcriteriaRequest.getFETCommonTest()));
        }

       Short descriptionafr = subjectcriteriaRequest.getDescriptionAFR();
        if (null != descriptionafr) {
               subjectcriteria.setDescriptionAFR(subjectcriteriaRequest.getDescriptionAFR());
        }

        Short descriptionvern = subjectcriteriaRequest.getDescriptionVern();
        if (null != descriptionvern) {
               subjectcriteria.setDescriptionVern(subjectcriteriaRequest.getDescriptionVern());
        }

       
        Integer tasktype = subjectcriteriaRequest.getTaskType();
        if (null != tasktype) {
            subjectcriteria.setTaskType(subjectcriteriaRequest.getTaskType());
         }

        Boolean sbatask = subjectcriteriaRequest.getSBATask();
        if (null != sbatask) {
               subjectcriteria.setSBATask((subjectcriteriaRequest.getSBATask()));
        }

        Integer sbaweight = subjectcriteriaRequest.getSBAWeight();
        if (null != sbaweight) {
            subjectcriteria.setSBAWeight(subjectcriteriaRequest.getSBAWeight());
         }

         Integer fixedcriterionscore = subjectcriteriaRequest.getFixedCriterionScore();
        if (null != fixedcriterionscore) {
            subjectcriteria.setFixedCriterionScore(subjectcriteriaRequest.getFixedCriterionScore());
         }

        Integer fixedweight = subjectcriteriaRequest.getFixedWeight();
        if (null != fixedweight) {
            subjectcriteria.setFixedWeight(subjectcriteriaRequest.getFixedWeight());
         }

        Integer fixedsbaweight = subjectcriteriaRequest.getFixedSBAWeight();
        if (null != fixedsbaweight) {
            subjectcriteria.setFixedSBAWeight(subjectcriteriaRequest.getFixedSBAWeight());
         }

        Integer subjsplitno = subjectcriteriaRequest.getSubjSplitNo();
        if (null != subjsplitno) {
            subjectcriteria.setSubjSplitNo(subjectcriteriaRequest.getSubjSplitNo());
         }
 
        Integer offsubjectid = subjectcriteriaRequest.getOFFSubjectID();
        if (null != offsubjectid) {
            subjectcriteria.setOFFSubjectID(subjectcriteriaRequest.getOFFSubjectID());
         }

        Integer offcriterionid = subjectcriteriaRequest.getOFFCriterionID();
        if (null != offcriterionid) {
            subjectcriteria.setOFFCriterionID(subjectcriteriaRequest.getOFFCriterionID());
         }

        Boolean reclocked = subjectcriteriaRequest.getRecLocked();
        if (null != reclocked) {
               subjectcriteria.setRecLocked((subjectcriteriaRequest.getRecLocked()));
        }

         Integer status = subjectcriteriaRequest.getStatus();
        if (null != status) {
            subjectcriteria.setStatus(subjectcriteriaRequest.getStatus());
         }

        Boolean fixed0weight = subjectcriteriaRequest.getFixed0Weight();
        if (null != fixed0weight) {
               subjectcriteria.setFixed0Weight((subjectcriteriaRequest.getFixed0Weight()));
        }

        return subjectcriteria;
    }

}

