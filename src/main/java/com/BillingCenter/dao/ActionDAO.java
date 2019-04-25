package com.BillingCenter.dao;

import com.BillingCenter.model.Action;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public class ActionDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Action getById(int id){
        Session session = sessionFactory.openSession();
        Action action = session.get(Action.class, id);
        session.close();
        return action;
    }

    @Transactional
    public void save(Action action){
        Session session = sessionFactory.openSession();
        session.save(action);
    }

    @Transactional
    public void update(Action action) {
        Session session = sessionFactory.openSession();
        session.update(action);
        session.close();
    }

    @Transactional
    public void delete(Action action) {
        Session session = sessionFactory.openSession();
        session.delete(action);
        session.close();
    }

    @Transactional
    public List<Action> findAll() {
        Session session = sessionFactory.openSession();

        @SuppressWarnings("unchecked")
        List<Action> list = (List<Action>)session
                .createQuery("From Action").list();
        session.close();
        return list;
    }
}
