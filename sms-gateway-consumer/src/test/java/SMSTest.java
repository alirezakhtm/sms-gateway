import ir.navaco.mcb.sms.gateway.consumer.webservice.handler.SMSServiceHandler;

import java.util.UUID;

public class SMSTest {

    public static void main(String[] args) {
        SMSServiceHandler smsServiceHandler = new SMSServiceHandler();
        smsServiceHandler.sendMessage("+989194018087", "Hi This is a test message." + UUID.randomUUID(), "10002501", 1);
        smsServiceHandler.sendMessage("+989359785722", "Hi This is a test message." + UUID.randomUUID(), "10002501", 1);
    }

}
