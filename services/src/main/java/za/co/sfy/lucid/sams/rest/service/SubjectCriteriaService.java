package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.SubjectCriteriaResource;
import za.co.sfy.lucid.sams.rest.mapper.SubjectCriteriaMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.SubjectCriteriaRequest;
import za.co.sfy.sams.vo.SubjectCriteriaResponse;
import za.co.sfy.sams.lucid.schema.SubjectCriteria;


@Service
public class SubjectCriteriaService {

    private final SubjectCriteriaResource SubjectCriteriaResource;
    private final SubjectCriteriaMapper SubjectCriteriaMapper;

    @Autowired
    public SubjectCriteriaService(final SubjectCriteriaResource subjectcriteriaResource, final SubjectCriteriaMapper subjectcriteriaMapper) {
        this.SubjectCriteriaMapper = subjectcriteriaMapper;
        this.SubjectCriteriaResource = subjectcriteriaResource;
    }

    public SubjectCriteriaResponse updateSubjectCriteria(SubjectCriteriaRequest subjectcriteriaRequest) throws LucidSamsExecutionException {

       SubjectCriteria subjectcriteria = SubjectCriteriaMapper.SubjectCriteriaRequestToSubjectCriteria(subjectcriteriaRequest);

        SubjectCriteriaResource.update(subjectcriteria, SubjectCriteriaResource);

        SubjectCriteriaResponse SubjectCriteriaResponse = new SubjectCriteriaResponse();
        SubjectCriteriaResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        SubjectCriteriaResponse.setResponseStatus("Successfully updated 'SubjectCriteria' table");
        SubjectCriteriaResponse.setSubjectCriteria(subjectcriteria);

        return SubjectCriteriaResponse;
    }

    public SubjectCriteriaResponse saveSubjectCriteria(SubjectCriteriaRequest subjectcriteriaRequest) throws LucidSamsExecutionException {

        SubjectCriteria subjectcriteria = SubjectCriteriaMapper.SubjectCriteriaRequestToSubjectCriteria(subjectcriteriaRequest);

        Long id = SubjectCriteriaResource.save(subjectcriteria, SubjectCriteriaResource);
        subjectcriteria.setSubjectid(id.intValue());

        SubjectCriteriaResponse subjectcriteriaResponse = new SubjectCriteriaResponse();
        subjectcriteriaResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        subjectcriteriaResponse.setResponseStatus("Successfully saved 'SubjectCriteria' table");
        subjectcriteriaResponse.setSubjectCriteria(subjectcriteria);

        return subjectcriteriaResponse;
    }

}