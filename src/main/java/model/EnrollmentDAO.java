package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import connection.Connection;

public class EnrollmentDAO implements EnrollmentRepository {
	public SessionFactory sessionFactory = Connection.getSessionFactory();
	public Enrollment findEnroll(int id){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        Enrollment user=currentSession.get(Enrollment.class,id);
        transaction.commit();
        currentSession.close();
        return user;

    }
	public List<Enrollment> list() {

        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Enrollment.class);
        List <Enrollment> results = cr.list();
        session.close();
        return results;

    }
	public void create(Enrollment objectToCreate) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.merge(objectToCreate);
        transaction.commit();
        currentSession.close();
    }
	public List<Integer> getAllByIdStudent(int idstudent) {
		try {
			Session sessionObj = sessionFactory.openSession();
			Query<Integer> query = sessionObj.createQuery("Select idcourse from Enrollment where idstudent='"+idstudent+"'");
			List<Integer> offerts = query.getResultList();
			return offerts;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not working");
			return null;
		}
	}
}
