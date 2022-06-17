package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.DisciplinaryLearnerMisconductResource;
import za.co.sfy.lucid.sams.rest.mapper.DisciplinaryLearnerMisconductMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DisciplinaryLearnerMisconductRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DisciplinaryLearnerMisconductResponse;
import za.co.sfy.sams.lucid.schema.DisciplinaryLearnerMisconduct;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DisciplinaryLearnerMisconductService {

    private final DisciplinaryLearnerMisconductResource disciplinaryLearnerMisconductResource;
    private final DisciplinaryLearnerMisconductMapper disciplinaryLearnerMisconductMapper;

    @Autowired
    public DisciplinaryLearnerMisconductService(final DisciplinaryLearnerMisconductResource disciplinaryLearnerMisconductResource
            , final DisciplinaryLearnerMisconductMapper disciplinaryLearnerMisconductMapper) {

        this.disciplinaryLearnerMisconductResource = disciplinaryLearnerMisconductResource;
        this.disciplinaryLearnerMisconductMapper = disciplinaryLearnerMisconductMapper;
    }

    public DisciplinaryLearnerMisconductResponse saveDisciplinaryLearnerMisconduct
            (DisciplinaryLearnerMisconductRequest disciplinaryLearnerMisconductRequest) throws LucidSamsExecutionException {

        DisciplinaryLearnerMisconduct disciplinaryLearnerMisconduct = disciplinaryLearnerMisconductMapper
                .DisciplinaryLearnerMisconductRequestToDisciplinaryLearnerMisconduct(disciplinaryLearnerMisconductRequest);

        Integer level = disciplinaryLearnerMisconductRequest.getLevel();
        if (null == level) {
            throw new LucidSamsExecutionException("'level' field is empty");
        }

        Boolean validLevel = Boolean.FALSE;

        ResultSet retrievedLevels = disciplinaryLearnerMisconductResource.retrieveLevels();
        while (true) {
            try {
                if (!retrievedLevels.next()) break;
                Integer retrievedLevel = retrievedLevels.getInt(1);
                if (level.equals(retrievedLevel)) {
                    validLevel = Boolean.TRUE;
                    break;
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        if (Boolean.FALSE.equals(validLevel)) {
            throw new LucidSamsExecutionException("The entered 'level' value is invalid, it does not exist in the database");
        }

        String code = disciplinaryLearnerMisconductRequest.getCode();
        if (null == code) {
            throw new LucidSamsExecutionException("'code' field is empty");
        } else if (level != Integer.parseInt(String.valueOf(code.charAt(0)))) {
            throw new LucidSamsExecutionException("invalid 'code', the first character must match with the 'level' field value");
        }

        ResultSet retrievedCodes = disciplinaryLearnerMisconductResource.retrieveCodes();

        while (true) {
            try {
                if (!retrievedCodes.next()) break;
                String retrievedCode = retrievedLevels.getString(1);
                if (retrievedCode.equalsIgnoreCase(code)) {
                    throw new LucidSamsExecutionException("Code '" + code + "' already exists");
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        Long generatedKey = disciplinaryLearnerMisconductResource.save(disciplinaryLearnerMisconduct, disciplinaryLearnerMisconductResource);
        disciplinaryLearnerMisconduct.setId(Math.toIntExact(generatedKey));

        DisciplinaryLearnerMisconductResponse disciplinaryLearnerMisconductResponse = new DisciplinaryLearnerMisconductResponse();
        disciplinaryLearnerMisconductResponse.setDisciplinaryLearnerMisconduct(disciplinaryLearnerMisconduct);
        disciplinaryLearnerMisconductResponse.setResponseStatus(ServiceStatus.SUCCESS.value());
        disciplinaryLearnerMisconductResponse.setResponseMessage("Successfully saved 'DisciplinaryLearnerMisconduct' data");

        return disciplinaryLearnerMisconductResponse;
    }
}
