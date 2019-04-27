package com.BillingCenter.dao;

import com.BillingCenter.model.PhoneNumber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PhoneNumbersDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public PhoneNumber getById(int id){
        Session session = sessionFactory.openSession();
        PhoneNumber action = (PhoneNumber) session.get(PhoneNumber.class, id);
        session.close();
        return action;
    }

    public void save(PhoneNumber phoneNumber){
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(phoneNumber);
        tx1.commit();
        session.close();
    }

    public void update(PhoneNumber phoneNumber) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(phoneNumber);
        tx1.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        PhoneNumber phoneNumber = session.get(PhoneNumber.class, id);
        session.delete(phoneNumber);
        tx1.commit();
        session.close();
    }

    public List<PhoneNumber> findAll() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<PhoneNumber> list = (List<PhoneNumber>)session
                .createQuery("From PhoneNumber").list();
        session.close();
        return list;
    }
}
