package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.ClassesResource;
import za.co.sfy.lucid.sams.rest.mapper.ClassesMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ClassesRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ClassesResponse;
import za.co.sfy.sams.lucid.schema.Classes;

/**
 * @author muzim
 */
@Service
public class ClassesService {


    private final ClassesResource classesResource;
    private final ClassesMapper classesMapper;

    @Autowired
    public ClassesService(final ClassesResource classesResource, final ClassesMapper classesMapper) {
        this.classesResource = classesResource;
        this.classesMapper = classesMapper;
    }

    public ClassesResponse saveClasses(ClassesRequest classesRequest) throws LucidSamsExecutionException {

        Classes classes = classesMapper.classesRequestToClasses(classesRequest);

        Long generatedKey = classesResource.save(classes, classesResource);
        classes.setClassId(Math.toIntExact(generatedKey));

        ClassesResponse classesResponse = new ClassesResponse();
        classesResponse.setClasses(classes);
        classesResponse.setResponseMessage("Successfully saved 'Classes' data.");
        classesResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return classesResponse;
    }
}
