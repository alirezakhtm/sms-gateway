package ir.navaco.mcb.sms.gateway.consumer.webservice.handler;

public interface ServiceInterface {
    boolean sendMessage(String msisdn, String body, String senderNumber, int priority);
}
