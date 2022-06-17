package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.StaffCalendarTerms;

public class StaffCalendarTermsResponse extends ApiResponse {

    private static final long serialVersionUID = -2772836212928177326L;

    private StaffCalendarTerms staffCalendarTerms;

    public StaffCalendarTerms getStaffCalendarTerms() {
        return staffCalendarTerms;
    }

    public void setStaffCalendarTerms(StaffCalendarTerms staffCalendarTerms) {
        this.staffCalendarTerms = staffCalendarTerms;
    }
}
