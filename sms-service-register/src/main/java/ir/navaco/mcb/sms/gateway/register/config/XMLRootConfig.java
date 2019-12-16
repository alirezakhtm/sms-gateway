package ir.navaco.mcb.sms.gateway.register.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "application")
public class XMLRootConfig {
    private String eurekaServer;
    private String applicationName;
    private List<XMLAPI> apis;
    private String smsGatewayeIp;
    private int smsGatewayPort;

    @XmlElement(name = "eureka-server")
    public String getEurekaServer() {
        return eurekaServer;
    }

    public void setEurekaServer(String eurekaServer) {
        this.eurekaServer = eurekaServer;
    }

    @XmlElement(name = "application-name")
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @XmlElementWrapper(name = "apis")
    @XmlElement(name = "api")
    public List<XMLAPI> getApis() {
        return apis;
    }

    public void setApis(List<XMLAPI> apis) {
        this.apis = apis;
    }

    @XmlElement(name = "sms-gateway-ip")
    public String getSmsGatewayeIp() {
        return smsGatewayeIp;
    }

    public void setSmsGatewayeIp(String smsGatewayeIp) {
        this.smsGatewayeIp = smsGatewayeIp;
    }

    @XmlElement(name = "sms-gateway-port")
    public int getSmsGatewayPort() {
        return smsGatewayPort;
    }

    public void setSmsGatewayPort(int smsGatewayPort) {
        this.smsGatewayPort = smsGatewayPort;
    }
}
