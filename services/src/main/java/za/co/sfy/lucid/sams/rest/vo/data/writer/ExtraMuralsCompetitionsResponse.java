package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompetitions;

public class ExtraMuralsCompetitionsResponse extends ApiResponse {

    private static final long serialVersionUID = -9050048970662895083L;

    private ExtraMuralsCompetitions extraMuralsCompetitions;

    public ExtraMuralsCompetitions getExtraMuralsCompetitions() {
        return extraMuralsCompetitions;
    }

    public void setExtraMuralsCompetitions(ExtraMuralsCompetitions extraMuralsCompetitions) {
        this.extraMuralsCompetitions = extraMuralsCompetitions;
    }
}
