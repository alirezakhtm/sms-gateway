package ir.navaco.mcb.sms.gateway.services.handlers.db;

import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.common.IRestSMSResponse;
import ir.navaco.mcb.sms.gateway.services.handlers.db.entity.SMSRequest;
import ir.navaco.mcb.sms.gateway.services.handlers.db.entity.SMSResponse;

import java.util.UUID;

public class ConverterObjectToEntity {

    public static SMSRequest convertToSMSRequest(IRestSMSRequest restSMSRequest){
        SMSRequest smsRequest = new SMSRequest(
                restSMSRequest.getMsisdn(),
                restSMSRequest.getMessageContent(),
                restSMSRequest.getRequestId()
        );
        return smsRequest;
    }


    public static SMSResponse convertToSMSResponse(IRestSMSResponse restSMSResponse) {
        SMSResponse smsResponse = new SMSResponse(
                restSMSResponse.getRequestId(),
                restSMSResponse.getAccessId(),
                restSMSResponse.getMsisdn(),
                restSMSResponse.getMessage()
        );
        return smsResponse;
    }

    public static SMSResponse convertToSMSResponse(IRestSMSRequest restSMSRequest) {
        SMSResponse smsResponse = new SMSResponse(
                restSMSRequest.getRequestId(),
                UUID.randomUUID().toString(),
                restSMSRequest.getMsisdn(),
                restSMSRequest.getMessageContent()
        );
        return smsResponse;
    }
}
