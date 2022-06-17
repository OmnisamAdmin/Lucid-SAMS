package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ClassesRequest;
import za.co.sfy.sams.lucid.schema.Classes;

/**
 * @author muzim
 */
@Component
public class ClassesMapper {

	public Classes classesRequestToClasses(ClassesRequest classesRequest) throws LucidSamsExecutionException {

		Classes classes = new Classes();

		Integer classId = classesRequest.getClassId();
		if (null != classId) {
			classes.setClassId(Integer.valueOf(classId));
		} else {
			classes.setClassId(Integer.valueOf(0));
		}

		String className = classesRequest.getClassName();
		if (null != className) {
			classes.setClassName(classesRequest.getClassName());
		}

		String edCode = classesRequest.getEdCode();
		if (null != edCode) {
			classes.setEdCode(classesRequest.getEdCode());
		}
		Integer grade = classesRequest.getGrade();
		if (null != grade) {
			classes.setGrade(Integer.valueOf(grade));
		} else {
			classes.setGrade(Integer.valueOf(0));

		}
		String room = classesRequest.getRoom();
		if (null != room) {
			classes.setRoom(classesRequest.getRoom());
		}

		Integer type = classesRequest.getType();
		if (type > 2 || type < 1) {
			throw new LucidSamsExecutionException("The given type value '" + type + "' is invalid. "
					+ "The field 'Type' can either be 1(State Class) or 2(SGB CLass)");
		}
		classes.setType(type);

		return classes;
	}

}