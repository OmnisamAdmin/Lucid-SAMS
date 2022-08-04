package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.Educators;

public class EducatorsResponse extends ApiResponse {

    private static final long serialVersionUID = -3956478974894290362L;

    private Educators educators;

    public Educators getEducators() {
        return educators;
    }

    public void setEducators(Educators educators) {
        this.educators = educators;
    }
}
