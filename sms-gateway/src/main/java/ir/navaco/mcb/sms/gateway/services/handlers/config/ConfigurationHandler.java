package ir.navaco.mcb.sms.gateway.services.handlers.config;

import ir.navaco.mcb.sms.gateway.services.handlers.config.dto.ApplicationConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class ConfigurationHandler {

    private static final String[] fileAddresses = new String[]{"application.xml", "/root/application.xml"};

    private File getConfigurationFile(){
        AtomicReference<File> ans = new AtomicReference<>();
        Arrays.stream(fileAddresses).forEach(address -> {
            File file = new File(address);
            if(file.exists()) ans.set(file);
        });
        return ans.get();
    }

    public ApplicationConfiguration getConfig() throws JAXBException {
//        File configurationFile = this.getConfigurationFile();
        File configurationFile = new File(this.getClass().getClassLoader().getResource("application.xml").getFile());
        JAXBContext context = JAXBContext.newInstance(ApplicationConfiguration.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ApplicationConfiguration applicationConfiguration = (ApplicationConfiguration) unmarshaller.unmarshal(configurationFile);
        return applicationConfiguration;
    }
}
