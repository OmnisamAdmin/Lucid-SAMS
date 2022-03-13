package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.GeneralInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.GeneralInfoMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.GeneralInfoRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.GeneralInfoResponse;
import za.co.sfy.sams.GeneralInfo;

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
        generalInfoResource.save(generalInfo);

        GeneralInfoResponse generalInfoResponse = new GeneralInfoResponse();
        //TODO: this request should return the data that has been persisted.
        generalInfoResponse.setResponseMessage("Successfully saved 'General_Info' data.");
        generalInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return generalInfoResponse;
    }
}