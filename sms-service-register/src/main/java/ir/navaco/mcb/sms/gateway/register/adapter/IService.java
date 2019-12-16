package ir.navaco.mcb.sms.gateway.register.adapter;

public interface IService {
    String getServiceName();
    String getServiceURL();
    String getApplicationName();
    void registerService();
}
