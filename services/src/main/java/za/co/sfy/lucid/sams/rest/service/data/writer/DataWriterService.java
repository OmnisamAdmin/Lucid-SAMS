package za.co.sfy.lucid.sams.rest.service.data.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.data.writer.DataWriter;
import za.co.sfy.lucid.sams.rest.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.mapper.DataWriterMapper;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DataWriterRequest;
import za.co.sfy.lucid.sams.rest.vo.data.writer.DataWriterResponse;

@Service
public class DataWriterService {

    private final DataWriterMapper dataWriterMapper;

    @Autowired
    public DataWriterService(final DataWriterMapper dataWriterMapper) {
        this.dataWriterMapper = dataWriterMapper;
    }

    public DataWriterResponse writeData(DataWriterRequest dataWriterRequest) throws LucidSamsExecutionException {
        DataWriter dataWriter = dataWriterMapper.dataWriterRequestToDataWriter(dataWriterRequest);

        DataWriterResponse dataWriterResponse = dataWriterMapper.dataWriterToDataWriterResponse(dataWriter);
        dataWriterResponse.setResponseMessage("Saved Successfully.");
        dataWriterResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return dataWriterResponse;
    }

}
