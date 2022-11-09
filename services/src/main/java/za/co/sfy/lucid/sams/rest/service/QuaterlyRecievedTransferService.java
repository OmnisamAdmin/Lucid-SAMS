package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.QuaterlyRecievedTransferResource;
import za.co.sfy.lucid.sams.rest.mapper.QuaterlyRecievedTransferMapper;
import za.co.sfy.sams.response.ServiceStatus;
import za.co.sfy.sams.vo.QuaterlyRecievedTransferRequest;
import za.co.sfy.sams.vo.QuaterlyRecievedTransferResponse;
import za.co.sfy.sams.lucid.schema.QuaterlyRecievedTransfer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Service
public class QuaterlyRecievedTransferService {

    private final QuaterlyRecievedTransferResource quaterlyRecievedTransferResource;
    private final QuaterlyRecievedTransferMapper quaterlyRecievedTransferMapper;
    private static final List<String> acceptedQuarters = Arrays.asList("QUARTER 1", "QUARTER 2", "QUARTER 3", "QUARTER 4");

    @Autowired
    public QuaterlyRecievedTransferService(final QuaterlyRecievedTransferResource quaterlyRecievedTransferResource
            , final QuaterlyRecievedTransferMapper quaterlyRecievedTransferMapper) {
        this.quaterlyRecievedTransferResource = quaterlyRecievedTransferResource;
        this.quaterlyRecievedTransferMapper = quaterlyRecievedTransferMapper;
    }

    public QuaterlyRecievedTransferResponse saveQuaterlyRecievedTransfer(QuaterlyRecievedTransferRequest quaterlyRecievedTransferRequest) throws LucidSamsExecutionException {
        QuaterlyRecievedTransfer quaterlyRecievedTransfer = quaterlyRecievedTransferMapper
                .quaterlyRecievedTransferRequestToQuaterlyRecievedTransfer(quaterlyRecievedTransferRequest);

        String quarter = quaterlyRecievedTransfer.getQuarter();
        ResultSet retrievedQuaterlyRecievedTransfer = quaterlyRecievedTransferResource.retrieveQuaterlyRecievedTransferByQuarter(quarter);
        try {
            if (retrievedQuaterlyRecievedTransfer.next()) {
                throw new LucidSamsExecutionException("The given quarter '" + quarter + "' already exists in the system" +
                        ", please execute an update service instead.");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        if (!acceptedQuarters.contains(quarter.toUpperCase())) {
            throw new LucidSamsExecutionException("The given quarter '" + quarter + "' is not an accepted value in the system");
        }

        //TODO: May have to consider validating data_year against date_received as well as validating if date_recieved(yyy/mm/dd) is a date since it is a string
        Long generatedKey = quaterlyRecievedTransferResource.save(quaterlyRecievedTransfer, quaterlyRecievedTransferResource);
        quaterlyRecievedTransfer.setID(Math.toIntExact(generatedKey));

        QuaterlyRecievedTransferResponse quaterlyRecievedTransferResponse = new QuaterlyRecievedTransferResponse();
        quaterlyRecievedTransferResponse.setQuaterlyRecievedTransfer(quaterlyRecievedTransfer);
        quaterlyRecievedTransferResponse.setResponseMessage("Successfully saved 'QuaterlyRecievedTransfer' data");
        quaterlyRecievedTransferResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return quaterlyRecievedTransferResponse;
    }

    public QuaterlyRecievedTransferResponse updateQuaterlyRecievedTransfer(QuaterlyRecievedTransferRequest quaterlyRecievedTransferRequest) throws LucidSamsExecutionException {
        QuaterlyRecievedTransfer quaterlyRecievedTransfer = quaterlyRecievedTransferMapper
                .quaterlyRecievedTransferRequestToQuaterlyRecievedTransfer(quaterlyRecievedTransferRequest);

        String quarter = quaterlyRecievedTransfer.getQuarter();
        ResultSet retrievedQuaterlyRecievedTransfer = quaterlyRecievedTransferResource.retrieveQuaterlyRecievedTransferByQuarter(quarter);
        try {
            if (!retrievedQuaterlyRecievedTransfer.next()) {
                throw new LucidSamsExecutionException("The given quarter '" + quarter + " does not exist in the system.");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        //TODO: May have to consider validating data_year against date_received as well as validating if date_recieved(yyy/mm/dd) is a date since it is a string
        quaterlyRecievedTransferResource.update(quaterlyRecievedTransfer, quaterlyRecievedTransferResource);

        QuaterlyRecievedTransferResponse quaterlyRecievedTransferResponse = new QuaterlyRecievedTransferResponse();
        quaterlyRecievedTransferResponse.setResponseMessage(ServiceStatus.SUCCESS.value());
        quaterlyRecievedTransferResponse.setResponseStatus("Successfully updated 'QuaterlyRecievedTransfer' table");
        quaterlyRecievedTransferResponse.setQuaterlyRecievedTransfer(quaterlyRecievedTransfer);

        return quaterlyRecievedTransferResponse;
    }
}