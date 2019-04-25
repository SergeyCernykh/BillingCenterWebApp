package com.BillingCenter.dao;

import com.BillingCenter.model.Customer;

import com.BillingCenter.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerDAO {

    public Customer getCustomerById(int id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Customer action = (Customer) session.get(Customer.class, id);
        session.close();
        return action;
    }

    public void save(Customer customer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.save(customer);
        session.close();
    }

    public void update(Customer customer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.update(customer);
        session.close();
    }

    public void delete(Customer customer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.delete(customer);
        session.close();
    }

    public List<Customer> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Customer> list = (List<Customer>)session
                .createQuery("From Customer").list();
        session.close();
        return list;
    }
}
