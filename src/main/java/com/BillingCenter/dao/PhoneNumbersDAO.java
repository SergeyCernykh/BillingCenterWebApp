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
    SessionFactory sessionFactory;

    @Transactional
    public PhoneNumber getById(int id){
        Session session = sessionFactory.openSession();
        PhoneNumber action = session.get(PhoneNumber.class, id);
        session.close();
        return action;
    }

    @Transactional
    public void save(PhoneNumber phoneNumber){
        Session session = sessionFactory.openSession();
        session.save(phoneNumber);
        session.close();
    }

    @Transactional
    public void update(PhoneNumber phoneNumber) {
        Session session = sessionFactory.openSession();
        session.update(phoneNumber);
        session.close();
    }

    @Transactional
    public void delete(PhoneNumber phoneNumber) {
        Session session = sessionFactory.openSession();
        session.delete(phoneNumber);
        session.close();
    }

    @Transactional
    public List<PhoneNumber> findAll() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<PhoneNumber> list = (List<PhoneNumber>)session
                .createQuery("From PhoneNumber").list();
        session.close();
        return list;
    }
}
