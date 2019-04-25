package com.BillingCenter.dao;

import com.BillingCenter.model.CustomerInfo;
import com.BillingCenter.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerInfoDAO {

    public CustomerInfo getById(int id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        CustomerInfo action = (CustomerInfo) session.get(CustomerInfo.class, id);
        session.close();
        return action;
    }

    public void save(CustomerInfo custInfo) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.save(custInfo);
        session.close();
    }

    public void update(CustomerInfo custInfo) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.update(custInfo);
        session.close();
    }

    public void delete(CustomerInfo custInfo) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.delete(custInfo);
        session.close();
    }

    public List<CustomerInfo> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<CustomerInfo> list = (List<CustomerInfo>)session
                .createQuery("From CustomerInfo").list();
        session.close();
        return list;
    }
}
