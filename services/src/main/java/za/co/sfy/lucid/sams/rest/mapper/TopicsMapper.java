package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.TopicsRequests;
import za.co.sfy.sams.lucid.schema.Topics;

/**
 * @author muzim
 */
@Component
public class TopicsMapper {

    public Topics topicsRequestsToTopics(TopicsRequests topicsRequests) {

        Topics topics = new Topics();

        Integer mainposition = topicsRequests.getMainPosition();
        if (null != mainposition) {
            topics.setMainPosition(String.valueOf(topicsRequests.getMainPosition()));
        }

        Integer maintopicid = topicsRequests.getMainTopicID();
        if (null != maintopicid) {
            topics.setMainTopicID(topicsRequests.getMainTopicID());
        }

        Short description = topicsRequests.getDescription();
        if (null != description) {
               topics.setDescription(String.valueOf(topicsRequests.getDescription()));
        }

         Short afrdescription = topicsRequests.getAfrDescription();  
        if (null != afrdescription) {
               topics.setAfrDescription(String.valueOf(topicsRequests.getDescription()));
        }

          Short verndescription = topicsRequests.getVernDescription();
        if (null != verndescription) {
               topics.setAfrDescription(String.valueOf(topicsRequests.getVernDescription()));
        }


           Integer subjectid = topicsRequests.getSubjectID();
        if (null != subjectid) {
            topics.setMainPosition(String.valueOf(topicsRequests.getSubjectID()));
        }

         Integer officialsubjectid = topicsRequests.getOfficialSubjectID();
        if (null != subjectid) {
            topics.setMainPosition(String.valueOf(topicsRequests.getSubjectID()));
        }
        String reclocked = topicsRequests.getRecLocked();
        if (null != reclocked) {
            topics.setRecLocked(topicsRequests.getRecLocked());
        }

        Short patchver = topicsRequests.getPatchVer();
        if (null != patchver) {
            topics.setPatchVer(String.valueOf(topicsRequests.getPatchVer()));
        }

        Integer groupno = topicsRequests.getGroupNo();
        if (null != groupno) {
            topics.setGroupNo(groupno);
        }

        return topics;
    }

}

