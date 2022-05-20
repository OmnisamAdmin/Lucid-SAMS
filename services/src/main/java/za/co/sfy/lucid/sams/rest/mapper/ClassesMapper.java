package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ClassesRequest;
import za.co.sfy.sams.lucid.schema.Classes;

/**
 * @author muzim
 */
@Component
public class ClassesMapper {

    public Classes classesRequestToClasses(ClassesRequest classesRequest) {

        Classes classes = new Classes();

        classes.setClassId(classesRequest.getClassId());
        classes.setClassName(classesRequest.getClassName());
        classes.setEdCode(classesRequest.getEdCode());
        classes.setGrade(classesRequest.getGrade());
        classes.setRoom(classesRequest.getRoom());
        classes.setType(classesRequest.getType());

        return classes;
    }

}
