package com.BillingCenter.dao;

import com.BillingCenter.model.PhoneService;
import com.BillingCenter.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ServiceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public PhoneService getById(int id){
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        PhoneService phoneService = (PhoneService) session.get(PhoneService.class, id);
        session.close();
        return phoneService;
    }

    public int save(PhoneService service) {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Serializable id = session.save(service);
        tx1.commit();
        session.close();
        return (Integer) id;
    }

    //@Transactional
    public void update(PhoneService service) {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(service);
        tx1.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        PhoneService phoneService = (PhoneService) session
                .get(PhoneService.class, id);
        Transaction tx1 = session.beginTransaction();
        session.delete(phoneService);
        tx1.commit();
        session.close();
        return;
    }

    public List<PhoneService> findAll() {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<PhoneService> list = (List<PhoneService>)session
                .createQuery("From PhoneService").list();
        session.close();
        return list;
    }
}
