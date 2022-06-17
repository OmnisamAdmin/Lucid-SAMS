package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.StaffCalendarTermsResource;
import za.co.sfy.lucid.sams.rest.mapper.StaffCalendarTermsMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.StaffCalendarTermsRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.StaffCalendarTermsResponse;
import za.co.sfy.sams.lucid.schema.StaffCalendarTerms;

@Service
public class StaffCalendarTermsService {

    private final StaffCalendarTermsResource staffCalendarTermsResource;
    private final StaffCalendarTermsMapper staffCalendarTermsMapper;

    @Autowired
    public StaffCalendarTermsService(final StaffCalendarTermsResource staffCalendarTermsResource, final StaffCalendarTermsMapper staffCalendarTermsMapper) {
        this.staffCalendarTermsResource = staffCalendarTermsResource;
        this.staffCalendarTermsMapper = staffCalendarTermsMapper;
    }

    public StaffCalendarTermsResponse saveStaffCalendarTerms(StaffCalendarTermsRequest staffCalendarTermsRequest)
            throws LucidSamsExecutionException {

        StaffCalendarTerms staffCalendarTerms = staffCalendarTermsMapper.StaffCalendarTermsRequestToStaffCalendarTerms(staffCalendarTermsRequest);

        Long generatedKey = staffCalendarTermsResource.save(staffCalendarTerms, staffCalendarTermsResource);
        staffCalendarTerms.setId(Math.toIntExact(generatedKey));

        StaffCalendarTermsResponse staffCalendarTermsResponse = new StaffCalendarTermsResponse();
        staffCalendarTermsResponse.setStaffCalendarTerms(staffCalendarTerms);
        staffCalendarTermsResponse.setResponseMessage("Successfully retrieved 'StaffCalendarTerms' data");
        staffCalendarTermsResponse.setResponseStatus(ServiceStatus.ERROR.value());

        return staffCalendarTermsResponse;

    }

}
