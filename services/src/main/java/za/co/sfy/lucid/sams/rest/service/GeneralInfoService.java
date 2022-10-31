package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.GeneralInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.GeneralInfoMapper;
import za.co.sfy.sams.vo.GeneralInfoRequest;
import za.co.sfy.sams.vo.GeneralInfoResponse;
import za.co.sfy.sams.lucid.schema.GeneralInfo;

/**
 * @author muzim
 */
@Service
public class GeneralInfoService {

    private final GeneralInfoMapper generalInfoMapper;
    private final GeneralInfoResource generalInfoResource;

    @Autowired
    public GeneralInfoService(final GeneralInfoMapper generalInfoMapper, final GeneralInfoResource generalInfoResource) {
        this.generalInfoMapper = generalInfoMapper;
        this.generalInfoResource = generalInfoResource;
    }

    public GeneralInfoResponse saveGeneralInfo(GeneralInfoRequest generalInfoRequest) throws LucidSamsExecutionException {

        GeneralInfo generalInfo = generalInfoMapper.generalInfoRequestToGeneralInfo(generalInfoRequest);

        Long generatedKey = generalInfoResource.save(generalInfo, generalInfoResource);
        generalInfo.setSchoolID(Math.toIntExact(generatedKey));

        GeneralInfoResponse generalInfoResponse = new GeneralInfoResponse();
        generalInfoResponse.setGeneralInfo(generalInfo);
        generalInfoResponse.setResponseMessage("Successfully saved 'General_Info' data.");
        generalInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return generalInfoResponse;
    }
}