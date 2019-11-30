package ir.navaco.mcb.sms.gateway.services.handlers.db;

import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.common.IRestSMSResponse;
import ir.navaco.mcb.sms.gateway.services.handlers.db.entity.SMSRequest;
import ir.navaco.mcb.sms.gateway.services.handlers.db.entity.SMSResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class DBHandler {
    private static SessionFactory factory = null;

    public DBHandler(){
        if(factory == null) {
            /*DOCKER*/
//            File file = new File(getClass().getClassLoader().getResource("hibernate.cfg.xml").getFile());
            File file = new File("/root/hibernate.cfg.xml");
            factory = new Configuration().configure(file).buildSessionFactory();
        }
    }

    public void insertSMSRequest(IRestSMSRequest smsRequest){
        Session session = factory.openSession();
        SMSRequest request = ObjectConverter.convertToSMSRequest(smsRequest);
        Transaction transaction = session.beginTransaction();
        session.save(request);
        session.flush();
        session.clear();
        transaction.commit();
        session.close();

    }

    public void insertSMSResponse(IRestSMSResponse smsResponse){
        Session session = this.factory.openSession();
        SMSResponse response = ObjectConverter.convertToSMSResponse(smsResponse);
        Transaction transaction = session.beginTransaction();
        session.save(response);
        session.flush();
        session.clear();
        transaction.commit();
        session.close();
    }

    public void insertSMSResponse(SMSResponse smsResponse){
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(smsResponse);
        session.flush();
        session.clear();
        transaction.commit();
        session.close();
    }
}
