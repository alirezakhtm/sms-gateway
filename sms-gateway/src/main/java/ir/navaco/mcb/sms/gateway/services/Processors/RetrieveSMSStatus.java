package ir.navaco.mcb.sms.gateway.services.Processors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.sms.gateway.services.handlers.ErrorHandler;
import ir.navaco.mcb.sms.gateway.services.handlers.db.DBHandler;
import ir.navaco.mcb.sms.gateway.services.handlers.db.entity.SMSResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.util.Map;

public class RetrieveSMSStatus implements Processor {

    private DBHandler dbHandler = new DBHandler();

    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getIn();
        Map<String, Object> headers = message.getHeaders();
        if(headers.keySet().contains("referenceId")){
            // query information in database
            SMSResponse smsResponse = dbHandler.getSMSResponse((String)headers.get("referenceId"));
            // if information found then set this on body
            if(smsResponse != null){
                message.setBody(smsResponse);
            }else{
                message.setBody(new ErrorHandler("Reference Id is not valid."));
            }
            // else send message in error that this reference Id is not exist on database.
        }else {
            message.setBody(new ErrorHandler("this request must be contained referenceId parameter in URL."));
        }
        exchange.setMessage(message);
    }
}
