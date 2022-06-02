package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.CycleInfoResource;
import za.co.sfy.lucid.sams.resource.GeneralInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.CycleInfoMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.CycleInfoRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.CycleInfoResponse;
import za.co.sfy.sams.lucid.schema.CycleInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Service
public class CycleInfoService {

    private final CycleInfoResource cycleInfoResource;
    private final CycleInfoMapper cycleInfoMapper;
    private final GeneralInfoResource generalInfoResource;

    @Autowired
    public CycleInfoService(final CycleInfoResource cycleInfoResource, final CycleInfoMapper cycleInfoMapper,
                            final GeneralInfoResource generalInfoResource) {
        this.cycleInfoResource = cycleInfoResource;
        this.cycleInfoMapper = cycleInfoMapper;
        this.generalInfoResource = generalInfoResource;
    }

    public CycleInfoResponse saveCycleInfo(CycleInfoRequest cycleInfoRequest) throws LucidSamsExecutionException, SQLException {

        CycleInfo cycleInfo = cycleInfoMapper.cycleInfoRequestToCycleInfo(cycleInfoRequest);

        String schoolName = cycleInfo.getSchoolname();

        ResultSet retrievedGeneralInfo = generalInfoResource.retrieveGeneralInfoBySchoolName(schoolName);
        if (!retrievedGeneralInfo.next()) {
            throw new LucidSamsExecutionException("The given 'SchoolName' - " + schoolName + " does not exist in the system");
        }

        cycleInfoResource.saveObjectWithoutGeneratedKey(cycleInfo, cycleInfoResource);

        CycleInfoResponse cycleInfoResponse = new CycleInfoResponse();
        cycleInfoResponse.setCycleInfo(cycleInfo);
        cycleInfoResponse.setResponseMessage("Successfully saved 'CycleInfo' data.");
        cycleInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return cycleInfoResponse;
    }
}
