package ir.navaco.mcb.sms.gateway.consumer.webservice.handler;

import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.ConfigurationHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto.ApplicationConfiguration;
import ir.navaco.mcb.sms.gateway.consumer.webservice.MaskanSMSService;
import ir.navaco.mcb.sms.gateway.consumer.webservice.ObjectFactory;

import javax.xml.bind.JAXBException;
import java.util.List;

public class SMSServiceHandler implements ServiceInterface {

    private static ConfigurationHandler configurationHandler = null;
    private ApplicationConfiguration applicationConfiguration = null;

    public SMSServiceHandler(){

        if(configurationHandler == null){
            configurationHandler = new ConfigurationHandler();
        }

        try {
            applicationConfiguration = configurationHandler.getConfig();
        } catch (JAXBException e) {
            e.printStackTrace();
            System.err.println("[>>>] Reading configuration file has been failed.\n" + e);
        }
    }

    @Override
    public boolean sendMessage(String msisdn, String body, String senderNumber, int priority) {
        // TODO
        System.out.println("[>>>] Sending Message ....");
        MaskanSMSService smsService = new MaskanSMSService();
        smsService.getMaskanSMSServiceSoap().sendSMSSingle(
                body,
                msisdn,
                senderNumber,
                applicationConfiguration.getSmsUsername(),
                applicationConfiguration.getSmsPassword(),
                null,
                null,
                null
        );
        System.out.println("[>>>] Message successfully has been sent.");
        return true;
    }
}
