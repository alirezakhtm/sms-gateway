package ir.navaco.mcb.sms.gateway.consumer.services.handlers;

import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.ConfigurationHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.DBHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.entity.SMSPolicy;

import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PoliciesHandler {

    private DBHandler dbHandler = new DBHandler();
    private static boolean runUpdateService = false;
    private ConfigurationHandler configurationHandler = new ConfigurationHandler();
    private static List<SMSPolicy> policies = null;

    public PoliciesHandler(){
        if(!runUpdateService){
            Thread policyUpdateService = new Thread(new RunnablePoliciesUpdateService());
            policyUpdateService.start();
            policies = dbHandler.getAllPolicies();
            runUpdateService = true;
        }
    }

    public List<SMSPolicy> getPolicies() {
        return policies;
    }

    public boolean isMessageValid(String requestId) {
        return policies.stream().filter(smsPolicy -> smsPolicy.getTag() == requestId.split("-")[0]).count() == 1;
    }

    public boolean isPriority(String requestId){
        if(this.isMessageValid(requestId)) {
            return policies.stream().filter(smsPolicy -> smsPolicy.getTag() == requestId.split("-")[0])
                    .findFirst()
                    .get()
                    .isPriority();
        } else return false;
    }

    private class RunnablePoliciesUpdateService implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(configurationHandler.getConfig().getInterval());
                    policies = dbHandler.getAllPolicies();
                    System.out.println(String.format("[>>>] %s Policies list had been updated.",
                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime())));
                }catch (JAXBException | InterruptedException e){
                    System.err.println(String.format("[>>>] %s Retrieving policies data from database has failed.",
                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime())));
                    runUpdateService = false;
                }
            }
        }
    }
}
