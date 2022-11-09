package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.StaffCalendarTermsResource;
import za.co.sfy.lucid.sams.rest.mapper.StaffCalendarTermsMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.StaffCalendarTermsRequest;
import za.co.sfy.sams.vo.StaffCalendarTermsResponse;
import za.co.sfy.sams.lucid.schema.StaffCalendarTerms;

/**
 * @author muzim
 */
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

        Integer term = staffCalendarTerms.getTerm();
        if (term > 4 || term < 1) {
            throw new LucidSamsExecutionException("The given term is not valid, the range is 1-4");
        }

        Long generatedKey = staffCalendarTermsResource.save(staffCalendarTerms, staffCalendarTermsResource);
        staffCalendarTerms.setId(Math.toIntExact(generatedKey));

        StaffCalendarTermsResponse staffCalendarTermsResponse = new StaffCalendarTermsResponse();
        staffCalendarTermsResponse.setStaffCalendarTerms(staffCalendarTerms);
        staffCalendarTermsResponse.setResponseMessage("Successfully saved 'StaffCalendarTerms' data");
        staffCalendarTermsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return staffCalendarTermsResponse;

    }

}