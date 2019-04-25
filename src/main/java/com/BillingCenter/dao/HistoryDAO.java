package com.BillingCenter.dao;

import com.BillingCenter.model.History;
import com.BillingCenter.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HistoryDAO {

    @Transactional
    public History getById(int id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        History action = session.get(History.class, id);
        session.close();
        return action;
    }

    @Transactional
    public void save(History history) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.save(history);
        session.close();
    }

    @Transactional
    public void update(History history) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.update(history);
        session.close();
    }

    @Transactional
    public void delete(History history) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.delete(history);
        session.close();
    }

    @Transactional
    public List<History> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<History> list = (List<History>)session
                .createQuery("From History").list();
        session.close();
        return list;
    }
}
