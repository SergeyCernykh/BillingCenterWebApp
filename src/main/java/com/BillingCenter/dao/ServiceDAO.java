package com.BillingCenter.dao;

import com.BillingCenter.model.PhoneService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ServiceDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public PhoneService getById(int id){
        Session session = sessionFactory.openSession();
        PhoneService action = session.get(PhoneService.class, id);
        session.close();
        return action;
    }

    @Transactional
    public void save(PhoneService service){
        Session session = sessionFactory.openSession();
        Transaction tx1 = null;
        session.save(service);
        session.close();
    }

    @Transactional
    public void update(PhoneService service) {
        Session session = sessionFactory.openSession();
        session.update(service);
        session.close();
    }

    @Transactional
    public void delete(PhoneService service) {
        Session session = sessionFactory.openSession();
        session.delete(service);
        session.close();
    }

    @Transactional
    public List<PhoneService> findAll() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<PhoneService> list = (List<PhoneService>)session
                .createQuery("From Service").list();
        session.close();
        return list;
    }
}
