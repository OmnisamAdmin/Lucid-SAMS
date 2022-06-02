package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompetitionsRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompetitions;

@Component
public class ExtraMuralsCompetitionsMapper {

    public ExtraMuralsCompetitions extraMuralsCompetitionsRequestToExtraMuralsCompetitions(ExtraMuralsCompetitionsRequest extraMuralsCompetitionsRequest) {

        ExtraMuralsCompetitions extraMuralsCompetitions = new ExtraMuralsCompetitions();

        extraMuralsCompetitions.setCompAfrName(extraMuralsCompetitionsRequest.getCompAfrName());
        extraMuralsCompetitions.setCompID(extraMuralsCompetitionsRequest.getCompID());
        extraMuralsCompetitions.setCompName(extraMuralsCompetitionsRequest.getCompName());
        extraMuralsCompetitions.setCompOfficialID(extraMuralsCompetitionsRequest.getCompOfficialID());
        extraMuralsCompetitions.setCompPicture(extraMuralsCompetitionsRequest.getCompPicture());
        extraMuralsCompetitions.setExID(extraMuralsCompetitionsRequest.getExID());
        extraMuralsCompetitions.setRecLocked(extraMuralsCompetitionsRequest.isRecLocked());
        extraMuralsCompetitions.setRecSelected(extraMuralsCompetitionsRequest.isRecSelected());

        return extraMuralsCompetitions;

    }
}
