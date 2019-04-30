package com.BillingCenter.dao;

import com.BillingCenter.model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PhoneNumbersDAO phoneNumbersDAO;

    @Autowired
    private CustomerInfoDAO customerInfoDAO;

    @Autowired
    private ActionDAO actionDAO;

    @Autowired
    private HistoryDAO historyDAO;

    public Customer getCustomerById(int id){
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Customer customer = (Customer) session.get(Customer.class, id);
        session.close();
        List<PhoneNumber> forDeleteNumbers = new ArrayList<PhoneNumber>();
        List<PhoneNumber> numbers = phoneNumbersDAO.findAll();
        for (PhoneNumber number : numbers) {
            if (number.getCustomerid() != id) {
                forDeleteNumbers.add(number);
            }
        }
        numbers.removeAll(forDeleteNumbers);
        customer.setPhoneNumbersById(numbers);

        List<CustomerInfo> forDeleteCustmerInfo = new ArrayList<CustomerInfo>();
        List<CustomerInfo> contacts = customerInfoDAO.findAll();
        for (CustomerInfo contact : contacts) {
            if (contact.getCustomerid() != id) {
                forDeleteCustmerInfo.add(contact);
            }
        }
        contacts.removeAll(forDeleteCustmerInfo);
        customer.setCustomersInfosById(contacts);

        List<Action> forDeleteAction = new ArrayList<Action>();
        List<Action> actions = actionDAO.findAll();
        for (Action action : actions) {
            if (action.getCustomerid() != id) {
                forDeleteAction.add(action);
            }
        }
        actions.removeAll(forDeleteAction);
        customer.setActionsById(actions);

        List<History> forDeleteHistory = new ArrayList<History>();
        List<History> histories = historyDAO.findAll();
        for (History history : histories) {
            if (history.getCustomerid() != id) {
                forDeleteHistory.add(history);
            }
        }
        histories.removeAll(forDeleteHistory);
        customer.setHistoriesById(histories);
        return customer;
    }

    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.save(customer);
        session.close();
    }

    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(customer);
        tx1.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Customer customer = (Customer)session
                .get(Customer.class, id);
        Transaction tx1 = session.beginTransaction();
        session.delete(customer);
        tx1.commit();
        session.close();
    }

    public List<Customer> findAll() {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Customer> list = (List<Customer>)session
                .createQuery("From Customer").list();
        session.close();
        return list;
    }
}
