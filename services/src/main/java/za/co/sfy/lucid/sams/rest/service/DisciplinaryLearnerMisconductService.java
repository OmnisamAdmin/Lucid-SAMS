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
                throw new LucidSamsExecutionException("Failure in retrieved levels", exception);
            }
        }

        if (Boolean.FALSE.equals(validLevel)) {
            throw new LucidSamsExecutionException("The entered 'level' value is invalid, it does not exist in the database");
        }

        String code = disciplinaryLearnerMisconductRequest.getCode();

        if (null == code) {
            throw new LucidSamsExecutionException("'code' field is empty");
        } else if (!code.contains("-")) {
            throw new LucidSamsExecutionException("Invalid 'code' arguments, " +
                    "please follow the following format: '[level]-[subsequent_id]' e.g.'5-06'");
        }

        String[] codeArrayString = code.split("-", 2);

        String codePrefix = codeArrayString[0];
        if (codePrefix.isEmpty()) {
            throw new LucidSamsExecutionException("Invalid 'code', the prefix(level) is empty");
        } else if (level != Integer.parseInt(codePrefix)) {
            throw new LucidSamsExecutionException("Invalid 'code', " +
                    "the first character/prefix must match with the 'level' field value");
        }

        ResultSet retrievedCodes = disciplinaryLearnerMisconductResource.retrieveCodes();

        String codeSuffix = codeArrayString[1];
        if (codeSuffix.isEmpty()) {
            throw new LucidSamsExecutionException("Invalid 'code', the suffix(subsequent id) is empty");
        }

        Integer newCodeID;
        try {
            newCodeID = Integer.parseInt(codeSuffix);
        } catch (NumberFormatException exception) {
            throw new LucidSamsExecutionException("Invalid code, the suffix is not a numerical value");
        }

        Integer maxID = 0;

        while (true) {
            try {
                if (!retrievedCodes.next()) break;

                String retrievedCode = retrievedCodes.getString(1);
                if (retrievedCode.equalsIgnoreCase(code)) {
                    throw new LucidSamsExecutionException("The code '" + code + "' already exists");
                }

                String[] retrievedCodeArrayString = retrievedCode.split("-", 2);
                Integer retrievedCodePrefix = Integer.parseInt(retrievedCodeArrayString[0]);
                Integer retrievedCodeSuffix = Integer.parseInt(retrievedCodeArrayString[1]);
                if (retrievedCodePrefix.equals(level) && maxID < retrievedCodeSuffix) {
                    maxID = retrievedCodeSuffix;
                }

            } catch (SQLException exception) {
                throw new LucidSamsExecutionException("Failure in retrieved codes", exception);
            }
        }

        maxID++;

        if (!maxID.equals(newCodeID)) {
            throw new LucidSamsExecutionException("The given code suffix a.k.a subsequent id '" + codeSuffix + "' is invalid." +
                    "The next slot is " +maxID);
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
