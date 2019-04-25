package com.BillingCenter.dao;

import com.BillingCenter.model.Action;
import com.BillingCenter.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class ActionDAO {

    public Action getById(int id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Action action = (Action) session.get(Action.class, id);
        session.close();
        return action;
    }

    public void save(Action action){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.save(action);
        session.close();
    }

    public void update(Action action) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.update(action);
        session.close();
    }

    public void delete(Action action) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.delete(action);
        session.close();
    }

    public List<Action> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        @SuppressWarnings("unchecked")
        List<Action> list = (List<Action>)session
                .createQuery("From Action").list();
        session.close();
        return list;
    }
}
