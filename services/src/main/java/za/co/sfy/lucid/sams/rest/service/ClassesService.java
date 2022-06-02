package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ClassesResource;
import za.co.sfy.lucid.sams.resource.CycleInfoResource;
import za.co.sfy.lucid.sams.rest.mapper.ClassesMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ClassesRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ClassesResponse;
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

    public ClassesResponse saveClasses(ClassesRequest classesRequest) throws LucidSamsExecutionException, SQLException {

        Classes classes = classesMapper.classesRequestToClasses(classesRequest);

        Integer grade = classesRequest.getGrade();

        ResultSet retrievedGrades = cycleInfoResource.retrieveGrades();
        if (!retrievedGrades.next()) {
            throw new LucidSamsExecutionException("Retrieved grades is empty. Please verify there is 'CycleInfo' data");
        }

        retrievedGrades.beforeFirst(); //reset index after null check

        while (retrievedGrades.next()) {
            Integer lowestGrade = retrievedGrades.getInt("LowestGrade");
            Integer highestGrade = retrievedGrades.getInt("HighestGrade");
            if (grade < lowestGrade || grade > highestGrade) {
                throw new LucidSamsExecutionException(grade + " is not within the existing grade" +
                        " range (" + lowestGrade + "-" + highestGrade + ")");
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
