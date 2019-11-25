import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.common.IRestSMSResponse;
import ir.navaco.mcb.sms.gateway.services.handlers.db.ConverterObjectToEntity;
import ir.navaco.mcb.sms.gateway.services.handlers.db.DBHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DBHandlerTest {
    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();
        IRestSMSRequest restSMSRequest = new IRestSMSRequest();
        restSMSRequest.setMessageContent("hi world!");
        restSMSRequest.setMsisdn("+989194018087");
        restSMSRequest.setRequestId(UUID.randomUUID().toString());
        dbHandler.insertSMSRequest(restSMSRequest);

        IRestSMSResponse restSMSResponse = new IRestSMSResponse(
                restSMSRequest.getRequestId(),
                UUID.randomUUID().toString(),
                restSMSRequest.getMsisdn(),
                restSMSRequest.getMessageContent()
        );

        dbHandler.insertSMSResponse(restSMSResponse);

    }
}
