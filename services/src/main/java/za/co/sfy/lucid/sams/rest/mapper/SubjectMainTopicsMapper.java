package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.SubjectMainTopicsRequest;
import za.co.sfy.sams.lucid.schema.SubjectMainTopics;

/**
 * @author ahussain
 */
@Component
public class SubjectMainTopicsMapper {

    public SubjectMainTopics topicsRequestsToTopics(SubjectMainTopicsRequest subjectMainTopicsRequest) {

        SubjectMainTopics topics = new SubjectMainTopics();

        Integer mainPosition = subjectMainTopicsRequest.getMainPosition();
        if (null != mainPosition) {
            topics.setMainPosition(mainPosition);
        }

        Integer mainTopicID = subjectMainTopicsRequest.getMainTopicID();
        if (null != mainTopicID) {
            topics.setMainTopicID(mainTopicID);
        }

        Short description = subjectMainTopicsRequest.getDescription();
        if (null != description) {
            topics.setDescription(String.valueOf(description));
        }

        Short afrDescription = subjectMainTopicsRequest.getAfrDescription();
        if (null != afrDescription) {
            topics.setAfrDescription(String.valueOf(afrDescription));
        }

        Short vernDescription = subjectMainTopicsRequest.getVernDescription();
        if (null != vernDescription) {
            topics.setAfrDescription(String.valueOf(vernDescription));
        }


        Integer subjectID = subjectMainTopicsRequest.getSubjectID();
        if (null != subjectID) {
            topics.setMainPosition(subjectID);
        }

        Integer officialSubjectID = subjectMainTopicsRequest.getOfficialSubjectID();
        if (null != officialSubjectID) {
            topics.setMainPosition(officialSubjectID);
        }
        String recLocked = subjectMainTopicsRequest.getRecLocked();
        if (null != recLocked) {
            topics.setRecLocked(Boolean.parseBoolean(recLocked));
        }

        Short patchVer = subjectMainTopicsRequest.getPatchVer();
        if (null != patchVer) {
            topics.setPatchVer(String.valueOf(patchVer));
        }

        Integer groupNo = subjectMainTopicsRequest.getGroupNo();
        if (null != groupNo) {
            topics.setGroupNo(groupNo);
        }

        return topics;
    }

}