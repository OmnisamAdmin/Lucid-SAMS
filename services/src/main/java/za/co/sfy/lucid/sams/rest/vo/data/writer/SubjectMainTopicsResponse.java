package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.SubjectMainTopics;

import java.io.Serializable;

public class SubjectMainTopicsResponse extends ApiResponse implements Serializable {

    private static final long serialVersionUID = 3444883558635545805L;

    private SubjectMainTopics topics;

    public SubjectMainTopics getTopics() {
        return topics;
    }

    public void setTopics(SubjectMainTopics topics) {
        this.topics = topics;
    }
}