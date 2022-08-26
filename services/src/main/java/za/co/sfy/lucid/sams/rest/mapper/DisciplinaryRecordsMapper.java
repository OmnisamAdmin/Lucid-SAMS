package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DisciplinaryRecordsRequest;
import za.co.sfy.sams.lucid.schema.DisciplinaryRecords;

@Component
public class DisciplinaryRecordsMapper {

    private SharedMapper sharedMapper;

    public DisciplinaryRecordsMapper(final SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public DisciplinaryRecords disciplinaryRecordsRequestToDisciplinaryRecords(DisciplinaryRecordsRequest disciplinaryRecordsRequest) throws LucidSamsExecutionException {
        DisciplinaryRecords disciplinaryRecords = new DisciplinaryRecords();

        Integer id = disciplinaryRecordsRequest.getId();
        disciplinaryRecords.setId(id);

        Integer learnerid = disciplinaryRecordsRequest.getLearnerid();
        disciplinaryRecords.setLearnerid(learnerid);

        String date = disciplinaryRecordsRequest.getDate();
        disciplinaryRecords.setDate(sharedMapper.dateToXMLGregorianCalendar(date));

        String comment = disciplinaryRecordsRequest.getComment();
        if (comment != null) {
            disciplinaryRecords.setComment(comment);
        }
        String levelMisconduct = disciplinaryRecordsRequest.getLevelMisconduct();
        disciplinaryRecords.setLevelMisconduct(levelMisconduct);

        String misconductCode = disciplinaryRecordsRequest.getMisconductCode();
        disciplinaryRecords.setMisconductCode(misconductCode);

        String misconductDescription = disciplinaryRecordsRequest.getMisconductDescription();
        disciplinaryRecords.setMisconductDescription(misconductDescription);

        String actionLevel = disciplinaryRecordsRequest.getActionLevel();
        if (actionLevel != null) {
            disciplinaryRecords.setActionLevel(actionLevel);
        }

        String actionCode = disciplinaryRecordsRequest.getActionCode();
        if (actionCode != null) {
            disciplinaryRecords.setActionCode(actionCode);
        }

        String actionDescription = disciplinaryRecordsRequest.getActionDescription();
        if (actionDescription != null) {
            disciplinaryRecords.setActionDescription(actionDescription);
        }

        String disciplinedBy = disciplinaryRecordsRequest.getDisciplinedBy();
        if (disciplinedBy != null) {
            disciplinaryRecords.setDisciplinedBy(disciplinedBy);
        }

        String authorisedBy = disciplinaryRecordsRequest.getAuthorisedBy();
        disciplinaryRecords.setAuthorisedBy(authorisedBy);

        String agency = disciplinaryRecordsRequest.getAgency();
        if (agency != null) {
            disciplinaryRecords.setAgency(agency);
        }

        Integer suspension = disciplinaryRecordsRequest.getSuspension();
        disciplinaryRecords.setSuspension(suspension);

        String option = disciplinaryRecordsRequest.getOption();
        disciplinaryRecords.setOption(option);

        String expulsionDate = disciplinaryRecordsRequest.getExpulsionDate();
        if (expulsionDate != null) {
            disciplinaryRecords.setExpulsionDate(expulsionDate);
        }

        String month = disciplinaryRecordsRequest.getMonth();
        disciplinaryRecords.setMonth(month);

        String recommendedExpulsion = disciplinaryRecordsRequest.getRecommendedExpulsion();
        if (recommendedExpulsion != null) {
            disciplinaryRecords.setRecommendedExpulsion(recommendedExpulsion);
        }

        String datayear = disciplinaryRecordsRequest.getDatayear();
        disciplinaryRecords.setDatayear(datayear);

        Integer demerit = disciplinaryRecordsRequest.getDemerit();
        if (demerit != null) {
            disciplinaryRecords.setDemerit(demerit);
        }

        Integer merit = disciplinaryRecordsRequest.getMerit();
        if (merit != null) {
            disciplinaryRecords.setMerit(merit);
        }

        String type = disciplinaryRecordsRequest.getType();
        disciplinaryRecords.setType(type);


        return disciplinaryRecords;
    }
}
