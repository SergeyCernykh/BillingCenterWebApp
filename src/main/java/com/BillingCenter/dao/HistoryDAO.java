package com.BillingCenter.dao;

import com.BillingCenter.model.History;
import com.BillingCenter.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HistoryDAO {

    public History getById(int id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        History action = (History) session.get(History.class, id);
        session.close();
        return action;
    }

    public void save(History history) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.save(history);
        session.close();
    }

    public void update(History history) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.update(history);
        session.close();
    }

    public void delete(History history) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.delete(history);
        session.close();
    }


    public List<History> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<History> list = (List<History>)session
                .createQuery("From History").list();
        session.close();
        return list;
    }
}
