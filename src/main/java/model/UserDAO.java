package model;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import connection.Connection;
import model.User;

public class UserDAO implements UserRepository {
	private EntityManagerFactory entityManagerFactory;
	public SessionFactory sessionFactory = Connection.getSessionFactory();
	public User findById(int id){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        User user=currentSession.get(User.class,id);
        transaction.commit();
        currentSession.close();
        return user;

    }
	public int findId(String username) {
		 	Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(User.class);
	        cr.add(Restrictions.eq("username", username));
	        List <User> results = cr.list();
	        session.close();
	        User u=results.get(0);
	        return u.getId();
	}
	
	public List<User> list() {

        Session session = sessionFactory.openSession();
        List<User> results = session.createQuery("From User").list();
        session.close();
        return results;

    }
	public void insert(User objectToCreate) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.merge(objectToCreate);
        transaction.commit();
        currentSession.close();
    }
}
