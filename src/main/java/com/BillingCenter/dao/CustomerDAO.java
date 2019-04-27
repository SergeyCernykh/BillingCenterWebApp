package com.BillingCenter.dao;

import com.BillingCenter.model.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Customer getCustomerById(int id){
        Session session = sessionFactory.openSession();
        Customer action = (Customer) session.get(Customer.class, id);
        session.close();
        return action;
    }

    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        session.save(customer);
        session.close();
    }

    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(customer);
        tx1.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = (Customer)session
                .get(Customer.class, id);
        Transaction tx1 = session.beginTransaction();
        session.delete(customer);
        tx1.commit();
        session.close();
    }

    public List<Customer> findAll() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Customer> list = (List<Customer>)session
                .createQuery("From Customer").list();
        session.close();
        return list;
    }
}
