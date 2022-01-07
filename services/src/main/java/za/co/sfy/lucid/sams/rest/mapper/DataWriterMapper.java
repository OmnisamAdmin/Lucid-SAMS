package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.data.writer.DataWriter;
import za.co.sfy.lucid.sams.rest.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DataWriterRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DataWriterResponse;

@Component
public class DataWriterMapper {

    public DataWriter dataWriterRequestToDataWriter(DataWriterRequest dataWriterRequest) {
        DataWriter dataWriter = new DataWriter();

        String schoolName = dataWriterRequest.getSchoolName();
        dataWriter.setSchoolName(schoolName);

        String teacherName = dataWriterRequest.getTeacherName();
        dataWriter.setTeacherName(teacherName);

        return dataWriter;
    }


    public DataWriterResponse dataWriterToDataWriterResponse(DataWriter dataWriter)
            throws LucidSamsExecutionException {

        DataWriterResponse dataWriterResponse = new DataWriterResponse();

        String schoolName = dataWriter.getSchoolName();
        dataWriterResponse.setSchoolName(schoolName);

        String teacherName = dataWriter.getTeacherName();
        dataWriterResponse.setTeacherName(teacherName);

        return dataWriterResponse;
    }
}
