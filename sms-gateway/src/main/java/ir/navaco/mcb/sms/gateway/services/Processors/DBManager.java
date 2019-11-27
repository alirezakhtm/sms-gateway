package ir.navaco.mcb.sms.gateway.services.Processors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.gateway.services.handlers.db.ObjectConverter;
import ir.navaco.mcb.sms.gateway.services.handlers.db.DBHandler;
import ir.navaco.mcb.sms.gateway.services.handlers.db.entity.SMSResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class DBManager implements Processor {

    private static DBHandler dbHandler = null;
    private static Gson gson = null;

    public DBManager(){
        if(dbHandler == null){
            dbHandler = new DBHandler();
            gson = new GsonBuilder().create();
        }
    }

    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getIn();
        String jsonSMSRequest = message.getBody().toString();
        jsonSMSRequest = ObjectConverter.convertToStandardJsonFormat(jsonSMSRequest);
        IRestSMSRequest restSMSRequest = gson.fromJson(jsonSMSRequest, IRestSMSRequest.class);
        dbHandler.insertSMSRequest(restSMSRequest);
        SMSResponse smsResponse = ObjectConverter.convertToSMSResponse(restSMSRequest);
        dbHandler.insertSMSResponse(smsResponse);
        message.setBody(smsResponse);
        exchange.setMessage(message);
    }
}
