package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;


import java.io.Serializable;
import za.co.sfy.sams.lucid.schema.Topics;

public class TopicsResponse extends ApiResponse implements Serializable {

    private static final long serialVersionUID = 3444883558635545805L;

    private Topics Topics;

    public Topics getTopics() {
        return Topics;
    }

    public void setTopics(Topics topics) {
        this.Topics = topics;
    }
}
