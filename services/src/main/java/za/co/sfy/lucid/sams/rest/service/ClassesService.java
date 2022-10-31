package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ClassesResource;
import za.co.sfy.lucid.sams.resource.CycleInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.ClassesMapper;
import za.co.sfy.sams.vo.ClassesRequest;
import za.co.sfy.sams.vo.ClassesResponse;
import za.co.sfy.sams.lucid.schema.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Service
public class ClassesService {

    private final ClassesResource classesResource;
    private final ClassesMapper classesMapper;
    private final CycleInfoResource cycleInfoResource;

    @Autowired
    public ClassesService(final ClassesResource classesResource, final ClassesMapper classesMapper
            , final CycleInfoResource cycleInfoResource) {
        this.classesResource = classesResource;
        this.classesMapper = classesMapper;
        this.cycleInfoResource = cycleInfoResource;
    }

    public ClassesResponse saveClasses(ClassesRequest classesRequest) throws LucidSamsExecutionException {

        Classes classes = classesMapper.classesRequestToClasses(classesRequest);

        Integer grade = classesRequest.getGrade();

        ResultSet retrievedGrades = cycleInfoResource.retrieveGrades();
        try {
            if (!retrievedGrades.next()) {
                throw new LucidSamsExecutionException("Retrieved grades is empty. Please verify there is 'CycleInfo' data");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve grades ", exception);
        }

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

        Long generatedKey = classesResource.save(classes, classesResource);
        classes.setClassId(Math.toIntExact(generatedKey));

        ClassesResponse classesResponse = new ClassesResponse();
        classesResponse.setClasses(classes);
        classesResponse.setResponseMessage("Successfully saved 'Classes' data.");
        classesResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return classesResponse;
    }
}