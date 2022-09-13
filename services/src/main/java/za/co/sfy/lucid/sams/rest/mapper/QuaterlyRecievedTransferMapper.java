package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.QuaterlyRecievedTransferRequest;
import za.co.sfy.sams.lucid.schema.QuaterlyRecievedTransfer;

@Component
public class QuaterlyRecievedTransferMapper {

    public QuaterlyRecievedTransfer quaterlyRecievedTransferRequestToQuaterlyRecievedTransfer(QuaterlyRecievedTransferRequest quaterlyRecievedTransferRequest) {
        QuaterlyRecievedTransfer quaterlyRecievedTransfer = new QuaterlyRecievedTransfer();

        Integer id = quaterlyRecievedTransfer.getID();
        if (id != null) {
            quaterlyRecievedTransfer.setID(id);
        }
        quaterlyRecievedTransfer.setAmount(quaterlyRecievedTransferRequest.getAmount());
        quaterlyRecievedTransfer.setDataYear(quaterlyRecievedTransferRequest.getDataYear());
        quaterlyRecievedTransfer.setQuarter(quaterlyRecievedTransferRequest.getQuarter());
        quaterlyRecievedTransfer.setDateRecieved(quaterlyRecievedTransferRequest.getDateRecieved());

        return quaterlyRecievedTransfer;
    }
}
