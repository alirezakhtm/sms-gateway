package ir.navaco.mcb.sms.gateway.consumer.services.handlers.db;

import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.common.IRestSMSResponse;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.entity.SMSRequest;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.entity.SMSResponse;

import java.util.UUID;

public class ObjectConverter {

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
                restSMSResponse.getReferenceId(),
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

    public static String convertToStandardJsonFormat(String jsonBody){
        return jsonBody.replace("{", "{\"").replace("=", "\":\"")
                .replace(", ", "\",\"").replace("}", "\"}");
    }
}
