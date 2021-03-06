package ir.navaco.mcb.sms.gateway.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.gateway.consumer.services.IRoute;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.PoliciesHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.ConfigurationHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto.ApplicationConfiguration;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.DBHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.ObjectConverter;
import ir.navaco.mcb.sms.gateway.consumer.services.redis.RedisQueueListener;
import ir.navaco.mcb.sms.gateway.consumer.services.redis.RedisThread;
import ir.navaco.mcb.sms.gateway.consumer.webservice.handler.SMSServiceHandler;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import javax.xml.bind.JAXBException;

public class ApplicationContext {

    private PoliciesHandler policiesHandler = new PoliciesHandler();
    private static ConfigurationHandler configurationHandler = null;
    private ApplicationConfiguration applicationConfiguration = null;

    public ApplicationContext() {
        if(configurationHandler == null){
            configurationHandler = new ConfigurationHandler();
        }
        try {
            applicationConfiguration = configurationHandler.getConfig();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void start() throws Exception {
        // Create camel routes
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new IRoute());
        context.start();
        // Create Redis listener
        RedisThread redisThread = new RedisThread();
        Thread redisService = new Thread(redisThread);
        redisService.start();
        redisThread.setOnQueueListener(new ApplicationContext.HandlerRedisQueueListener());
    }

    private class HandlerRedisQueueListener implements RedisQueueListener {

        private SMSServiceHandler smsServiceHandler = new SMSServiceHandler();
        private DBHandler dbHandler = new DBHandler();

        private IRestSMSRequest getSMSRequestObj(String jsonFormat){
            return new GsonBuilder().create().fromJson(jsonFormat, IRestSMSRequest.class);
        }

        @Override
        public void listenerQueue(String jsonObjectFormat) {
            String standardJsonObjectFormat = ObjectConverter.convertToStandardJsonFormat(jsonObjectFormat);
            System.out.println("[>>>] " + standardJsonObjectFormat);
            IRestSMSRequest restSMSRequest = this.getSMSRequestObj(standardJsonObjectFormat);
            // todo - this line must be modify for upper version
            boolean isPoliciesValid = true;/*policiesHandler.isMessageValid(restSMSRequest.getRequestId());*/
            if(isPoliciesValid) {
                boolean webserviceRsp = smsServiceHandler.sendMessage(
                        restSMSRequest.getMsisdn(),
                        restSMSRequest.getMessageContent(),
                        applicationConfiguration.getSmsSenderNumber(),
                        policiesHandler.isPriority(restSMSRequest.getRequestId()) ? 1 : 0);
                if (webserviceRsp) {
                    dbHandler.updateStatusRequest(restSMSRequest.getRequestId(), "SUCCESSFUL");
                } else {
                    dbHandler.updateStatusRequest(restSMSRequest.getRequestId(), "FAILED");
                }
            }else{
                dbHandler.updateStatusRequest(restSMSRequest.getRequestId(), "FAILED - POLICIES RULES");
            }
        }
    }
}
