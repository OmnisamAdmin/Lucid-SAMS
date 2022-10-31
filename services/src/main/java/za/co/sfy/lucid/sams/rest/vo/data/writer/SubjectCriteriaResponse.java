package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;


import java.io.Serializable;
import za.co.sfy.sams.lucid.schema.Educatorgroups;
import za.co.sfy.sams.lucid.schema.SubjectCriteria;

public class SubjectCriteriaResponse extends ApiResponse implements Serializable {

    private static final long serialVersionUID = 3444883558635545805L;

    private SubjectCriteria subjectcriteria;

    public SubjectCriteria geSubjectCriteria() {
        return subjectcriteria;
    }

    public void setSubjectCriteria(SubjectCriteria subjectcriteria) {
        this.subjectcriteria = subjectcriteria;
    }
}
