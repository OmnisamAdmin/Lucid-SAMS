package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.ExtraMuralsTeams;

public class ExtraMuralsTeamsResponse extends ApiResponse {

    private static final long serialVersionUID = -4368550010949899216L;

    private ExtraMuralsTeams extraMuralsTeams;

    public ExtraMuralsTeams getExtraMuralsTeams() {
        return extraMuralsTeams;
    }

    public void setExtraMuralsTeams(ExtraMuralsTeams extraMuralsTeams) {
        this.extraMuralsTeams = extraMuralsTeams;
    }
}
