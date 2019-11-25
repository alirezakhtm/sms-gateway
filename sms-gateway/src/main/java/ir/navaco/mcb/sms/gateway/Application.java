package ir.navaco.mcb.sms.gateway;

import ir.navaco.mcb.sms.gateway.services.IRoutes;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Application {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new IRoutes());
        context.start();
    }

}
