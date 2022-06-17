package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.EducatorCalendarTerms;

public class EducatorCalendarTermsResponse extends ApiResponse {

    private static final long serialVersionUID = 3352568741885559244L;

    private EducatorCalendarTerms educatorCalendarTerms;

    public EducatorCalendarTerms getEducatorCalendarTerms() {
        return educatorCalendarTerms;
    }

    public void setEducatorCalendarTerms(EducatorCalendarTerms educatorCalendarTerms) {
        this.educatorCalendarTerms = educatorCalendarTerms;
    }
}
