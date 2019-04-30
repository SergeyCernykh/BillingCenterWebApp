package com.BillingCenter.dao;

import com.BillingCenter.model.Action;
import com.BillingCenter.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class ActionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Action getById(int id){
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Action action = (Action) session.get(Action.class, id);
        session.close();
        return action;
    }

    public void save(Action action){
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(action);
        tx1.commit();
        session.close();
    }

    public void update(Action action) {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(action);
        tx1.commit();
        session.close();
    }

    public void delete(Action action) {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(action);
        tx1.commit();
        session.close();
    }

    public List<Action> findAll() {
        Session session = sessionFactory.openSession();
        //Session session = HibernateSessionFactory.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Action> list = (List<Action>)session
                .createQuery("From Action").list();
        session.close();
        return list;
    }
}
