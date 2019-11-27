package ir.navaco.mcb.sms.gateway.services.predicates;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.gateway.services.handlers.db.ObjectConverter;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Predicate;

public class RequestValidityPredicate implements Predicate {

    private static Gson gson = null;

    public boolean matches(Exchange exchange) {
        if(gson == null) gson = new GsonBuilder().create();
        Message message = exchange.getIn();
        String jsonBody = message.getBody().toString();
        jsonBody = ObjectConverter.convertToStandardJsonFormat(jsonBody);
        try{
            IRestSMSRequest SMSRequest = gson.fromJson(jsonBody, IRestSMSRequest.class);
            return SMSRequest.getMessageContent() != null &&
                    SMSRequest.getMsisdn() != null &&
                    SMSRequest.getRequestId() != null;
//            return true;
        }catch (Exception e){
            return false;
        }
    }
}
