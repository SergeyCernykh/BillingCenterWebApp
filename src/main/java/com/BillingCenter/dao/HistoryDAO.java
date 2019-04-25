package com.BillingCenter.dao;

import com.BillingCenter.model.History;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HistoryDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public History getById(int id){
        Session session = sessionFactory.openSession();
        History action = session.get(History.class, id);
        session.close();
        return action;
    }

    @Transactional
    public void save(History history) {
        Session session = sessionFactory.openSession();
        session.save(history);
        session.close();
    }

    @Transactional
    public void update(History history) {
        Session session = sessionFactory.openSession();
        session.update(history);
        session.close();
    }

    @Transactional
    public void delete(History history) {
        Session session = sessionFactory.openSession();
        session.delete(history);
        session.close();
    }

    @Transactional
    public List<History> findAll() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<History> list = (List<History>)session
                .createQuery("From History").list();
        session.close();
        return list;
    }
}
