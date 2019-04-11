package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.Connection;

public class CourseDAO implements CourseRepository {
	public SessionFactory sessionFactory = Connection.getSessionFactory();
	public Course findCourse(int id){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        Course user=currentSession.get(Course.class,id);
        transaction.commit();
        currentSession.close();
        return user;

    }
	public List<Object> list() {

        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Course.class);
        List <Object> results = cr.list();
        session.close();
        return results;

    }
}
