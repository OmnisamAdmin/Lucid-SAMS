package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.CycleInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.CycleInfoMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.CycleInfoRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.CycleInfoResponse;
import za.co.sfy.sams.lucid.schema.CycleInfo;

/**
 * @author muzim
 */
@Service
public class CycleInfoService {


    private final CycleInfoResource cycleInfoResource;
    private final CycleInfoMapper cycleInfoMapper;

    @Autowired
    public CycleInfoService(final CycleInfoResource cycleInfoResource, final CycleInfoMapper cycleInfoMapper) {
        this.cycleInfoResource = cycleInfoResource;
        this.cycleInfoMapper = cycleInfoMapper;
    }

    public CycleInfoResponse saveCycleInfo(CycleInfoRequest cycleInfoRequest) throws LucidSamsExecutionException {

        CycleInfo cycleInfo = cycleInfoMapper.cycleInfoRequestToCycleInfo(cycleInfoRequest);

        cycleInfoResource.saveObjectWithoutGeneratedKey(cycleInfo, cycleInfoResource);

        CycleInfoResponse cycleInfoResponse = new CycleInfoResponse();
        cycleInfoResponse.setCycleInfo(cycleInfo);
        cycleInfoResponse.setResponseMessage("Successfully saved 'Cycleinfo' data.");
        cycleInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return cycleInfoResponse;
    }
}
