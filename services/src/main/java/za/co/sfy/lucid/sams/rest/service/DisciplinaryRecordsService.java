package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.DisciplinaryLearnerMisconductResource;
import za.co.sfy.lucid.sams.resource.DisciplinaryRecordsResource;
import za.co.sfy.lucid.sams.resource.EducatorsResource;
import za.co.sfy.lucid.sams.resource.LearnerInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.DisciplinaryRecordsMapper;
import za.co.sfy.sams.vo.DisciplinaryRecordsRequest;
import za.co.sfy.sams.vo.DisciplinaryRecordsResponse;
import za.co.sfy.sams.lucid.schema.DisciplinaryRecords;

import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Component
public class DisciplinaryRecordsService {

    private final DisciplinaryRecordsResource disciplinaryRecordsResource;
    private final DisciplinaryRecordsMapper disciplinaryRecordsMapper;
    private final DisciplinaryLearnerMisconductResource disciplinaryLearnerMisconductResource;
    private final EducatorsResource educatorsResource;
    private final LearnerInfoResource learnerInfoResource;
    private static final String DEMERIT = "Demerit";
    private static final String MERIT = "Merit";

    @Autowired
    public DisciplinaryRecordsService(final DisciplinaryRecordsResource disciplinaryRecordsResource
            , final DisciplinaryRecordsMapper disciplinaryRecordsMapper
            , final LearnerInfoResource learnerInfoResource
            , final DisciplinaryLearnerMisconductResource disciplinaryLearnerMisconductResource
            , final EducatorsResource educatorsResource) {
        this.disciplinaryRecordsResource = disciplinaryRecordsResource;
        this.disciplinaryRecordsMapper = disciplinaryRecordsMapper;
        this.disciplinaryLearnerMisconductResource = disciplinaryLearnerMisconductResource;
        this.educatorsResource = educatorsResource;
        this.learnerInfoResource = learnerInfoResource;
    }

    public DisciplinaryRecordsResponse saveDisciplinaryRecords(DisciplinaryRecordsRequest disciplinaryRecordsRequest) throws LucidSamsExecutionException {

        DisciplinaryRecords disciplinaryRecords = disciplinaryRecordsMapper.disciplinaryRecordsRequestToDisciplinaryRecords(disciplinaryRecordsRequest);

        Integer learnerID = disciplinaryRecords.getLearnerid();
        ResultSet retrievedLearner = learnerInfoResource.retrieveLearnerInfoByID(Long.valueOf(learnerID));
        try {
            if (!retrievedLearner.next()) {
                throw new LucidSamsExecutionException("The given 'LearnerID' - " + learnerID + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        String misconductCode = disciplinaryRecords.getMisconductCode();
        ResultSet retrievedDisciplinaryLearnerMisconduct = disciplinaryLearnerMisconductResource.retrieveByCode(misconductCode);
        try {
            if (!retrievedDisciplinaryLearnerMisconduct.next()) {
                throw new LucidSamsExecutionException("The given 'misconductCode' - " + misconductCode + " does not exist in the system");
            }

            Integer point = retrievedDisciplinaryLearnerMisconduct.getInt("Point");

            String type = retrievedDisciplinaryLearnerMisconduct.getString("Type");
            if ("D".equalsIgnoreCase(type)) {
                disciplinaryRecords.setType(DEMERIT);
                disciplinaryRecords.setDemerit(point);
            } else if ("M".equalsIgnoreCase(type)) {
                disciplinaryRecords.setType(MERIT);
                disciplinaryRecords.setMerit(point);
            }

            String description = retrievedDisciplinaryLearnerMisconduct.getString("Description");
            disciplinaryRecords.setMisconductDescription(description);

            String level = retrievedDisciplinaryLearnerMisconduct.getString("Level");
            disciplinaryRecords.setLevelMisconduct("Level " + level);

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        XMLGregorianCalendar date = disciplinaryRecords.getDate();
        disciplinaryRecords.setDate(date);

        String month = String.valueOf(date.getMonth());
        disciplinaryRecords.setMonth(month);

        String dataYear = String.valueOf(date.getYear());
        disciplinaryRecords.setDatayear(dataYear);

        String authorisedBy = disciplinaryRecords.getAuthorisedBy();
        String[] splitAuthorisedBy = authorisedBy.split(" ");
        if (splitAuthorisedBy.length != 3) {
            throw new LucidSamsExecutionException("Please enter authorisedBy in the following format " +
                    "[title] [initials] [surname] e.g. Mr NM Mogodi");
        }

        String title = splitAuthorisedBy[0];
        String initials = splitAuthorisedBy[1];
        String surname = splitAuthorisedBy[2];

        ResultSet retrievedEducators = educatorsResource.retrieveEducatorsByCredentials(title, initials, surname);
        try {
            if (!retrievedEducators.next()) {
                throw new LucidSamsExecutionException("The given 'authorised by' - " + authorisedBy + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Long generatedKey = disciplinaryRecordsResource.save(disciplinaryRecords, disciplinaryRecordsResource);
        disciplinaryRecords.setId(Math.toIntExact(generatedKey));

        DisciplinaryRecordsResponse disciplinaryRecordsResponse = new DisciplinaryRecordsResponse();
        disciplinaryRecordsResponse.setDisciplinaryRecords(disciplinaryRecords);
        disciplinaryRecordsResponse.setResponseMessage("Successfully saved 'Disciplinary Records' data");
        disciplinaryRecordsResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return disciplinaryRecordsResponse;
    }
}