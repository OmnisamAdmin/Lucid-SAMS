package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;


import java.io.Serializable;
import za.co.sfy.sams.lucid.schema.Educatorgroups;

public class EducatorsGroupResponse extends ApiResponse implements Serializable {

    private static final long serialVersionUID = 3444883558635545805L;

    private Educatorgroups educatorgroups;

    public Educatorgroups getEducatorgroups() {
        return educatorgroups;
    }

    public void setEducatorgroups(Educatorgroups educatorgroups) {
        this.educatorgroups = educatorgroups;
    }
}
