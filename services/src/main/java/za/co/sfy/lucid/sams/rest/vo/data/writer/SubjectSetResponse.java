package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;


import java.io.Serializable;
import za.co.sfy.sams.lucid.schema.SubjectSets;
import za.co.sfy.sams.lucid.schema.Topics;

public class SubjectSetResponse extends ApiResponse implements Serializable {

    private static final long serialVersionUID = 3444883558635545805L;

    private SubjectSets SubjectSets;

    public SubjectSets getSubjectSets() {
        return SubjectSets;
    }

    public void setSubjectSets(SubjectSets subjectsets) {
        this.SubjectSets = subjectsets;
    }
}
