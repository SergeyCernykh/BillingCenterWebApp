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
    private SessionFactory sessionFactory;

    public History getById(int id){
        Session session = sessionFactory.openSession();
        History action = (History) session.get(History.class, id);
        session.close();
        return action;
    }

    public void save(History history) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(history);
        tx1.commit();
        session.close();
    }

    public void update(History history) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(history);
        tx1.commit();
        session.close();
    }

    public void delete(History history) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(history);
        tx1.commit();
        session.close();
    }


    public List<History> findAll() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<History> list = (List<History>)session
                .createQuery("From History").list();
        session.close();
        return list;
    }
}
