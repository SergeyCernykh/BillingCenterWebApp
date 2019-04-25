package com.BillingCenter.dao;

import com.BillingCenter.model.PhoneService;
import com.BillingCenter.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ServiceDAO {
    @Transactional
    public PhoneService getById(int id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        PhoneService action = session.get(PhoneService.class, id);
        session.close();
        return action;
    }

    @Transactional
    public void save(PhoneService service){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = null;
        session.save(service);
        session.close();
    }

    @Transactional
    public void update(PhoneService service) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.update(service);
        session.close();
    }

    @Transactional
    public void delete(PhoneService service) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.delete(service);
        session.close();
    }

    @Transactional
    public List<PhoneService> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<PhoneService> list = (List<PhoneService>)session
                .createQuery("From PhoneService").list();
        session.close();
        return list;
    }
}
