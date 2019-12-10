package ir.navaco.mcb.sms.gateway.consumer.services.handlers.db;

import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.common.IRestSMSResponse;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.entity.SMSPolicy;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.entity.SMSRequest;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.entity.SMSResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.internal.QueryImpl;

import java.io.File;
import java.util.List;

public class DBHandler {
    private static SessionFactory factory = null;

    public DBHandler(){
        if(factory == null) {
            /*DOCKER*/
            File file = new File(getClass().getClassLoader().getResource("hibernate.cfg.xml").getFile());
//            File file = new File("/root/hibernate.cfg.xml");
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
        Session session = factory.openSession();
        SMSResponse response = ObjectConverter.convertToSMSResponse(smsResponse);
        Transaction transaction = session.beginTransaction();
        session.save(response);
        session.flush();
        session.clear();
        transaction.commit();
        session.close();
    }

    public void insertSMSResponse(SMSResponse smsResponse){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(smsResponse);
        session.flush();
        session.clear();
        transaction.commit();
        session.close();
    }

    public SMSResponse getSMSResponse(String referenceId){
        Session session = factory.openSession();
        Query query = session.createQuery("FROM SMSResponse E WHERE E.referenceId = :referenceId");
        query = query.setParameter("referenceId", referenceId);
        List<SMSResponse> lstAns = query.list();
        session.close();
        return lstAns.size() == 0 || lstAns == null ? null : lstAns.get(0);
    }

    public void updateStatusRequest(String requestId, String status){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE SMSResponse E SET E.status = :status WHERE E.requestId = :requestId");
        query = query.setParameter("requestId", requestId);
        query = query.setParameter("status", status);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public List<SMSPolicy> getAllPolicies(){
        Session session = factory.openSession();
        Query query = session.createQuery("FROM SMSPolicy E WHERE E.id > 0");
        List<SMSPolicy> policies = query.list();
        session.close();
        return policies;
    }
}
