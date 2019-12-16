package ir.navaco.mcb.sms.gateway.register;

import ir.navaco.mcb.sms.gateway.register.adapter.IService;
import ir.navaco.mcb.sms.gateway.register.adapter.ServiceXMLAdapter;
import ir.navaco.mcb.sms.gateway.register.config.ApplicationConfiguration;
import ir.navaco.mcb.sms.gateway.register.config.XMLAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationSMSRegister {
    public static void main(String[] args) {

        List<IService> services = new ArrayList<>();

        ApplicationConfiguration applicationConfiguration = ApplicationConfiguration.getInstance();
        List<XMLAPI> xmlapis = applicationConfiguration.getApis();
        xmlapis.stream().forEach(xmlapi -> {
            services.add(new ServiceXMLAdapter(xmlapi));
        });

        services.stream().forEach(iService -> iService.registerService());

        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.next();
            System.out.println(input);
            if(input.equals("break")){
                break;
            }
        }
    }
}
