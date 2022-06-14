package za.co.sfy.lucid.sams.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.service.ClassesService;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ClassesRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ClassesResponse;

import javax.validation.Valid;

/**
 * @author muzim
 */
@RestController
@RequestMapping("classes")
public class ClassesController {

    private static final Logger logger = LoggerFactory.getLogger(ClassesController.class);
    private ClassesService classesService;

    @Autowired
    public ClassesController(final ClassesService classesService) {
        this.classesService = classesService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ClassesResponse> saveClasses(@Valid @RequestBody ClassesRequest classesRequest) {

        ClassesResponse classesResponse = new ClassesResponse();

        try {
            classesResponse = classesService.saveClasses(classesRequest);

        } catch (LucidSamsExecutionException executionException) {
            logger.error("Failure occurred: " + executionException.getMessage(), executionException);
            classesResponse.setResponseStatus(ServiceStatus.ERROR.value());
            classesResponse.setResponseMessage(executionException.getMessage());

            return ResponseEntity
                    .unprocessableEntity()
                    .body(classesResponse);
        }

        return ResponseEntity.ok(classesResponse);
    }


}
