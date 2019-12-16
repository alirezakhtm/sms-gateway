package ir.navaco.mcb.sms.gateway.register.config;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class ApplicationConfiguration {

    private String eurekaServer;
    private String applicationName;
    private List<XMLAPI> apis;

    private String smsGatewayeIp;
    private int smsGatewayPort;

    private static ApplicationConfiguration applicationConfiguration = null;
    private static File configFile = null;

    private ApplicationConfiguration(){
        if (configFile == null){
            /* DOCKER */
//            configFile = new File(getClass().getClassLoader().getResource("configuration.xml").getFile());
            configFile = new File("/root/configuration.xml");
        }
    }

    public static ApplicationConfiguration getInstance(){
        if(applicationConfiguration == null){
            applicationConfiguration = new ApplicationConfiguration();
            try {
                JAXBContext context = JAXBContext.newInstance(XMLRootConfig.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                XMLRootConfig xmlRootConfig = (XMLRootConfig) unmarshaller.unmarshal(configFile);
                applicationConfiguration.apis = xmlRootConfig.getApis();
                applicationConfiguration.applicationName = xmlRootConfig.getApplicationName();
                applicationConfiguration.eurekaServer = xmlRootConfig.getEurekaServer();
                applicationConfiguration.smsGatewayeIp = xmlRootConfig.getSmsGatewayeIp();
                applicationConfiguration.smsGatewayPort = xmlRootConfig.getSmsGatewayPort();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return applicationConfiguration;
    }

    public String getEurekaServer() {
        return eurekaServer;
    }

    public void setEurekaServer(String eurekaServer) {
        this.eurekaServer = eurekaServer;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public List<XMLAPI> getApis() {
        return apis;
    }

    public void setApis(List<XMLAPI> apis) {
        this.apis = apis;
    }

    public String getSmsGatewayeIp() {
        return smsGatewayeIp;
    }

    public void setSmsGatewayeIp(String smsGatewayeIp) {
        this.smsGatewayeIp = smsGatewayeIp;
    }

    public int getSmsGatewayPort() {
        return smsGatewayPort;
    }

    public void setSmsGatewayPort(int smsGatewayPort) {
        this.smsGatewayPort = smsGatewayPort;
    }
}
