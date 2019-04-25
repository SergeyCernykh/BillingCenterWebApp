package com.BillingCenter.dao;

import com.BillingCenter.model.PhoneNumber;
import com.BillingCenter.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PhoneNumbersDAO {

    public PhoneNumber getById(int id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        PhoneNumber action = (PhoneNumber) session.get(PhoneNumber.class, id);
        session.close();
        return action;
    }

    public void save(PhoneNumber phoneNumber){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.save(phoneNumber);
        session.close();
    }

    public void update(PhoneNumber phoneNumber) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.update(phoneNumber);
        session.close();
    }

    public void delete(PhoneNumber phoneNumber) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.delete(phoneNumber);
        session.close();
    }

    public List<PhoneNumber> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<PhoneNumber> list = (List<PhoneNumber>)session
                .createQuery("From PhoneNumber").list();
        session.close();
        return list;
    }
}
