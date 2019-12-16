package ir.navaco.mcb.sms.gateway.register.adapter;

import com.khtm.eureka.impl.EurekaService;
import ir.navaco.mcb.sms.gateway.register.config.ApplicationConfiguration;
import ir.navaco.mcb.sms.gateway.register.dto.ServiceDto;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ServiceAdapter implements IService {

    private ServiceDto serviceDto;

    public ServiceAdapter(ServiceDto serviceDto){
        this.serviceDto = serviceDto;
    }

    public String getServiceName() {
        return serviceDto.getApiName();
    }

    public String getServiceURL() {
        return serviceDto.getUrl();
    }

    public String getApplicationName() {
        return serviceDto.getApplicationName();
    }

    public void registerService() {
        ApplicationConfiguration applicationConfiguration = ApplicationConfiguration.getInstance();
        EurekaService eurekaService = new EurekaService(applicationConfiguration.getEurekaServer(), "127.0.0.1");
        try {
            eurekaService.registerServiceInEurekaService(applicationConfiguration.getApplicationName(),
                    8080,
                    "/health",
                    "/status",
                    "/",
                    "");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
