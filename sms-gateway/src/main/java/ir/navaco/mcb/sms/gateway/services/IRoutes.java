package ir.navaco.mcb.sms.gateway.services;

import ir.navaco.mcb.sms.gateway.services.Processors.DBManager;
import ir.navaco.mcb.sms.gateway.services.Processors.QueueManager;
import ir.navaco.mcb.sms.gateway.services.handlers.ErrorHandler;
import ir.navaco.mcb.sms.gateway.services.predicates.RequestValidityPredicate;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class IRoutes extends RouteBuilder {


    public void configure() throws Exception {
        restConfiguration("rest-api")
                .component("restlet")
                .host("localhost")
                .port(9696)
                .bindingMode(RestBindingMode.json);

        rest("/navaco-sms")
                .post("/send-message").to("direct:check-validity");

        from("direct:check-validity")
                .choice()
                    .when(new RequestValidityPredicate()).to("direct:insert-to-queue")
                .otherwise()
                    .process(new Processor() {
                        @Override
                        public void process(Exchange exchange) throws Exception {
                            Message message = exchange.getIn();
                            ErrorHandler errorHandler = new ErrorHandler("wrong-request");
                            message.setBody(errorHandler);
                            exchange.setMessage(message);
                        }
                    }).transform().body();

        from("direct:insert-to-queue").process(new QueueManager()).to("direct:insert-to-db");

        from("direct:insert-to-db").process(new DBManager()).to("direct:response");

        from("direct:response").transform().body();


    }
}