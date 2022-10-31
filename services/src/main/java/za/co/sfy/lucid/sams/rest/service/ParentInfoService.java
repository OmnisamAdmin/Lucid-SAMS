package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ParentInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.ParentInfoMapper;
import za.co.sfy.sams.vo.ParentInfoRequest;
import za.co.sfy.sams.vo.ParentInfoResponse;
import za.co.sfy.sams.lucid.schema.ParentInfo;

@Service
public class ParentInfoService {

    private final ParentInfoResource parentInfoRepository;
    private final ParentInfoMapper parentInfoMapper;

    @Autowired
    public ParentInfoService(final ParentInfoResource parentInfoRepository, final ParentInfoMapper parentInfoMapper) {
        this.parentInfoRepository = parentInfoRepository;
        this.parentInfoMapper = parentInfoMapper;
    }

    public ParentInfoResponse saveParentInfo(ParentInfoRequest parentInfoRequest) throws LucidSamsExecutionException {

        ParentInfo parentInfo = parentInfoMapper.ParentInfoRequestToParentInfo(parentInfoRequest);

        Long generatedKey = parentInfoRepository.save(parentInfo, parentInfoRepository);
        parentInfo.setParentID(Math.toIntExact(generatedKey));

        ParentInfoResponse parentInfoResponse = new ParentInfoResponse();
        parentInfoResponse.setParentInfo(parentInfo);
        parentInfoResponse.setResponseMessage("Successfully saved 'Parent_Info' data.");
        parentInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return parentInfoResponse;

    }
}