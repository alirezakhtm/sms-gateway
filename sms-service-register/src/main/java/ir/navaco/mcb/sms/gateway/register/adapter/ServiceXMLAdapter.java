package ir.navaco.mcb.sms.gateway.register.adapter;

import com.khtm.eureka.impl.EurekaService;
import ir.navaco.mcb.sms.gateway.register.config.ApplicationConfiguration;
import ir.navaco.mcb.sms.gateway.register.config.XMLAPI;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ServiceXMLAdapter implements IService{

    private XMLAPI instance;
    private ApplicationConfiguration configuration = ApplicationConfiguration.getInstance();

    public ServiceXMLAdapter(XMLAPI instance){
        this.instance = instance;
    }

    public String getServiceName() {
        return instance.getName();
    }

    public String getServiceURL() {
        return instance.getUrl();
    }

    public String getApplicationName() {
        return configuration.getApplicationName();
    }

    public void registerService() {
        EurekaService eurekaService = new EurekaService(configuration.getEurekaServer(), configuration.getSmsGatewayeIp());
        try {
            eurekaService.registerServiceInEurekaService(configuration.getApplicationName(),
                    configuration.getSmsGatewayPort(),
                    "/health",
                    "/status",
                    instance.getUrl(),
                    instance.getName());
        } catch (IOException | JAXBException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}
