package ir.navaco.mcb.sms.gateway.consumer.webservice.handler;

import ir.navaco.mcb.sms.gateway.consumer.services.handlers.PoliciesHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.DBHandler;
import ir.navaco.mcb.sms.gateway.consumer.webservice.ArrayOfString;
import ir.navaco.mcb.sms.gateway.consumer.webservice.MaskanSendService;
import ir.navaco.mcb.sms.gateway.consumer.webservice.MaskanSendServiceSoap;

import java.util.List;

public class SMSServiceHandler implements ServiceInterface {

    @Override
    public boolean sendMessage(String msisdn, String body, int priority) {
        // TODO
        System.out.println("[>>>] Sending Message ....");
        ArrayOfString arrayOfString = new ArrayOfString();
        MaskanSendService maskanSendService = new MaskanSendService();
        try {
            List<String> ans = maskanSendService.getMaskanSendServiceSoap().sendSMS(body,
                    arrayOfString,
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    true,
                    true,
                    true).getString();
            System.out.println("[>>>] Message successfully has been sent.");
            return true;
        }catch (Exception e){
            System.err.println("[>>>] Sending message failed.");
            System.err.println("[>>>] " + e.getMessage());
            return false;
        }
    }
}
