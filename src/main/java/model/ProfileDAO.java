package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import connection.Connection;

public class ProfileDAO implements ProfileRepository {
	public SessionFactory sessionFactory = Connection.getSessionFactory();
	public Profile findProfile(int id){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        Profile user=currentSession.get(Profile.class,id);
        transaction.commit();
        currentSession.close();
        return user;

    }
	
	public Profile findByIdUser (int id){
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Profile.class);
        cr.add(Restrictions.eq("iduser", id));
        List <Profile> results = cr.list();
        session.close();
        return results.get(0);
    }

	
	public List<Profile> list() {

        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Profile.class);
        List <Profile> results = cr.list();
        session.close();
        return results;

    }
	public void create(Profile objectToCreate) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.merge(objectToCreate);
        transaction.commit();
        currentSession.close();
    }
	public void delete(Profile objectToDelete) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(objectToDelete);
        transaction.commit();
        currentSession.close();
    }

    public void update(Profile objectToUpdate) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.update(objectToUpdate);
        transaction.commit();
        currentSession.close();
    }
}
