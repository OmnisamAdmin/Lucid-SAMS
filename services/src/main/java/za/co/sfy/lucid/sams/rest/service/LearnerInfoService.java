package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ClassesResource;
import za.co.sfy.lucid.sams.resource.CycleInfoResource;
import za.co.sfy.lucid.sams.resource.InstructionLanguagesResource;
import za.co.sfy.lucid.sams.resource.LearnerInfoResource;
import za.co.sfy.lucid.sams.resource.ReportLanguagesResource;
import za.co.sfy.lucid.sams.rest.mapper.LearnerInfoMapper;
import za.co.sfy.sams.vo.LearnerInfoRequest;
import za.co.sfy.sams.vo.LearnerInfoResponse;
import za.co.sfy.sams.lucid.schema.LearnerInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Service
public class LearnerInfoService {

    private final LearnerInfoResource learnerInfoResource;
    private final LearnerInfoMapper learnerInfoMapper;
    private final CycleInfoResource cycleInfoResource;
    private final ClassesResource classesResource;
    private final ReportLanguagesResource reportLanguagesResource;
    private final InstructionLanguagesResource instructionLanguagesResource;

    @Autowired
    public LearnerInfoService(final LearnerInfoResource learnerInfoResource, final LearnerInfoMapper learnerInfoMapper,
                              final CycleInfoResource cycleInfoResource, final ClassesResource classesResource,
                              final ReportLanguagesResource reportLanguagesResource, final InstructionLanguagesResource instructionLanguagesResource) {
        this.learnerInfoResource = learnerInfoResource;
        this.learnerInfoMapper = learnerInfoMapper;
        this.cycleInfoResource = cycleInfoResource;
        this.classesResource = classesResource;
        this.reportLanguagesResource = reportLanguagesResource;
        this.instructionLanguagesResource = instructionLanguagesResource;
    }

    public LearnerInfoResponse saveLearnerInfo(LearnerInfoRequest learnerInfoRequest) throws LucidSamsExecutionException {

        LearnerInfo learnerInfo = learnerInfoMapper.learnerInfoRequestToLearnerInfo(learnerInfoRequest);

        ResultSet retrievedGrades = cycleInfoResource.retrieveGrades();
        try {
            if (!retrievedGrades.next()) {
                throw new LucidSamsExecutionException("Retrieved grades is empty. Please verify there is 'CycleInfo' data");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Integer grade = learnerInfo.getGrade();

        while (true) {
            try {
                if (!retrievedGrades.next()) break;
                Integer lowestGrade = retrievedGrades.getInt("LowestGrade");
                Integer highestGrade = retrievedGrades.getInt("HighestGrade");
                if (grade < lowestGrade || grade > highestGrade) {
                    throw new LucidSamsExecutionException(grade + " is not within the existing grade" +
                            " range (" + lowestGrade + "-" + highestGrade + ")");
                }
            } catch (SQLException exception) {
                throw new LucidSamsExecutionException(exception.getMessage(), exception);
            }

        }

        Integer classId = learnerInfo.getClazz();
        ResultSet retrievedClasses = classesResource.retrieveClassesByID(Long.valueOf(classId));
        try {
            if (!retrievedClasses.next()) {
                throw new LucidSamsExecutionException("Could not find class with id '" + classId + "'");
            }
            if (!grade.equals(retrievedClasses.getInt("Grade"))) {
                throw new LucidSamsExecutionException("The given classId '" + classId + "' does not exist" +
                        " for the given grade '" + grade + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Integer homeLanguage = learnerInfo.getHomeLanguage();
        ResultSet retrievedLanguages = instructionLanguagesResource
                .retrieveInstructionLanguagesByID(Long.valueOf(homeLanguage));
        try {
            if (!retrievedLanguages.next()) {
                throw new LucidSamsExecutionException("Could not find homeLanguage with id '" + homeLanguage + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Integer instructionLanguage = learnerInfo.getInstructionLanguage();
        retrievedLanguages = instructionLanguagesResource
                .retrieveInstructionLanguagesByID(Long.valueOf(instructionLanguage));
        try {
            if (!retrievedLanguages.next()) {
                throw new LucidSamsExecutionException("Could not find instructionLanguage with id '" + instructionLanguage + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Integer preferredLanguage = learnerInfo.getPreferredLanguage();
        retrievedLanguages = instructionLanguagesResource
                .retrieveInstructionLanguagesByID(Long.valueOf(preferredLanguage));
        try {
            if (!retrievedLanguages.next()) {
                throw new LucidSamsExecutionException("Could not find preferredLanguage with id '" + preferredLanguage + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        Integer reportLanguage = learnerInfo.getReportLanguage();
        ResultSet retrievedReportLanguages = reportLanguagesResource
                .retrieveReportLanguagesByID(Long.valueOf(reportLanguage));
        try {
            if (!retrievedReportLanguages.next()) {
                throw new LucidSamsExecutionException("Could not find reportLanguage with id '" + reportLanguage + "'");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failure in the retrieved Report Languages ", exception);
        }

        Long generatedKey = learnerInfoResource.save(learnerInfo, learnerInfoResource);
        learnerInfo.setID(Math.toIntExact(generatedKey));

        LearnerInfoResponse learnerInfoResponse = new LearnerInfoResponse();
        learnerInfoResponse.setLearnerInfo(learnerInfo);
        learnerInfoResponse.setResponseMessage("Successfully saved 'LearnerInfo' data.");
        learnerInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return learnerInfoResponse;
    }
}