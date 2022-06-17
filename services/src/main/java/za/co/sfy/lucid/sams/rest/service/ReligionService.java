package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ReligionResource;
import za.co.sfy.lucid.sams.rest.mapper.ReligionMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ReligionRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ReligionResponse;
import za.co.sfy.sams.lucid.schema.Religion;

@Service
public class ReligionService {

    private final ReligionMapper religionMapper;
    private final ReligionResource religionResource;

    @Autowired
    public ReligionService(final ReligionMapper religionMapper, final ReligionResource religionResource) {
        this.religionMapper = religionMapper;
        this.religionResource = religionResource;
    }

    public ReligionResponse saveReligion(ReligionRequest religionRequest) throws LucidSamsExecutionException {

        Religion religion = religionMapper.religionRequestToReligion(religionRequest);

        Long generatedKey = religionResource.save(religion, religionResource);
        religion.setID(Math.toIntExact(generatedKey));

        ReligionResponse religionResponse = new ReligionResponse();
        religionResponse.setReligion(religion);
        religionResponse.setResponseMessage("Successfully saved 'Religion' data");
        religionResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return religionResponse;
    }
}
