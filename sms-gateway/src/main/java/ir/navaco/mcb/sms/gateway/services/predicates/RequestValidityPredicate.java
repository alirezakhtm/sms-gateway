package ir.navaco.mcb.sms.gateway.services.predicates;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.gateway.services.handlers.config.ConfigurationHandler;
import ir.navaco.mcb.sms.gateway.services.handlers.db.DBHandler;
import ir.navaco.mcb.sms.gateway.services.handlers.db.ObjectConverter;
import ir.navaco.mcb.sms.gateway.services.handlers.db.entity.SMSPolicy;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Predicate;

import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RequestValidityPredicate implements Predicate {

    private static Gson gson = null;
    private static List<SMSPolicy> policies = null;
    private DBHandler dbHandler;
    private ConfigurationHandler configurationHandler = new ConfigurationHandler();

    public RequestValidityPredicate(){
        dbHandler = new DBHandler();
        if(policies == null)
            policies = dbHandler.getAllPolicies();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(configurationHandler.getConfig().getInterval());
                    } catch (InterruptedException | JAXBException e) {
                        e.printStackTrace();
                    }finally {
                        policies = dbHandler.getAllPolicies();
                        System.out.println(String.format("[>>>] %s Policies list had been updated.",
                                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime())));
                    }
                }
            }
        }).start();
    }

    public boolean matches(Exchange exchange) {
        if(gson == null) gson = new GsonBuilder().create();
        Message message = exchange.getIn();
        String jsonBody = message.getBody().toString();
        jsonBody = ObjectConverter.convertToStandardJsonFormat(jsonBody);
        try{
            IRestSMSRequest SMSRequest = gson.fromJson(jsonBody, IRestSMSRequest.class);
            boolean isValidPolicies = policies.stream().filter(new java.util.function.Predicate<SMSPolicy>() {
                @Override
                public boolean test(SMSPolicy smsPolicy) {
                    return smsPolicy.getTag().equals(SMSRequest.getRequestId().split("-")[0]);
                }
            }).count() == 1;
            return SMSRequest.getMessageContent() != null && isValidPolicies &&
                    SMSRequest.getMsisdn() != null &&
                    SMSRequest.getRequestId() != null;
        }catch (Exception e){
            return false;
        }
    }
}
