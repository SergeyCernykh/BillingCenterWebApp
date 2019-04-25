package com.BillingCenter.dao;

import com.BillingCenter.model.CustomerInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerInfoDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public CustomerInfo getById(int id){
        Session session = sessionFactory.openSession();
        CustomerInfo action = session.get(CustomerInfo.class, id);
        session.close();
        return action;
    }

    @Transactional
    public void save(CustomerInfo custInfo) {
        Session session = sessionFactory.openSession();
        session.save(custInfo);
        session.close();
    }

    @Transactional
    public void update(CustomerInfo custInfo) {
        Session session = sessionFactory.openSession();
        session.update(custInfo);
        session.close();
    }

    @Transactional
    public void delete(CustomerInfo custInfo) {
        Session session = sessionFactory.openSession();
        session.delete(custInfo);
        session.close();
    }

    @Transactional
    public List<CustomerInfo> findAll() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<CustomerInfo> list = (List<CustomerInfo>)session
                .createQuery("From CustomerInfo").list();
        session.close();
        return list;
    }
}
