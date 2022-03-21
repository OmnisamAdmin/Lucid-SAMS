package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ParentChildRepository;
import za.co.sfy.lucid.sams.rest.mapper.ParentChildMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ParentChildRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ParentChildResponse;
import za.co.sfy.sams.lucid.schema.ParentChild;

@Service
public class ParentChildService {

    private final ParentChildRepository parentChildRepository;
    private final ParentChildMapper parentChildMapper;

    @Autowired
    public ParentChildService(final ParentChildRepository parentChildRepository, final ParentChildMapper parentChildMapper) {
        this.parentChildRepository = parentChildRepository;
        this.parentChildMapper = parentChildMapper;
    }

    public ParentChildResponse saveParentChild(ParentChildRequest parentChildRequest) throws LucidSamsExecutionException {

        ParentChild parentChild = parentChildMapper.ParentChildRequestToParentChild(parentChildRequest);

        parentChildRepository.saveObjectWithoutGeneratedKey(parentChild, parentChildRepository);

        ParentChildResponse parentInfoResponse = new ParentChildResponse();
        parentInfoResponse.setParentChild(parentChild);
        parentInfoResponse.setResponseMessage("Successfully saved 'Parent_Child' data.");
        parentInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return parentInfoResponse;

    }
}
