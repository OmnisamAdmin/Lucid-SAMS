package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.FeederSchoolsResource;
import za.co.sfy.lucid.sams.rest.mapper.FeederSchoolsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.FeederSchoolsResponse;
import za.co.sfy.lucid.sams.rest.vo.data.writer.FeederSchoolsRequest;
import za.co.sfy.sams.lucid.schema.FeederSchools;

@Service
public class FeederSchoolsService {

    private final FeederSchoolsMapper feederSchoolsMapper;
    private final FeederSchoolsResource feederSchoolsResource;

    @Autowired
    public FeederSchoolsService(final FeederSchoolsMapper feederSchoolsMapper, final FeederSchoolsResource feederSchoolsResource) {
        this.feederSchoolsMapper = feederSchoolsMapper;
        this.feederSchoolsResource = feederSchoolsResource;
    }

    public FeederSchoolsResponse saveFeederSchools(FeederSchoolsRequest feederSchoolsRequest) throws LucidSamsExecutionException {

        FeederSchools feederSchools = feederSchoolsMapper.feederSchoolsRequestToFeederSchools(feederSchoolsRequest);

        Long generatedKey = feederSchoolsResource.save(feederSchools, feederSchoolsResource);
        feederSchools.setId(Math.toIntExact(generatedKey));

        FeederSchoolsResponse feederSchoolResponse = new FeederSchoolsResponse();
        feederSchoolResponse.setFeederSchools(feederSchools);
        feederSchoolResponse.setResponseMessage("Successfully saved 'FeederSchools' data");
        feederSchoolResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return feederSchoolResponse;
    }
}
