package model;

import java.util.List;

public interface EnrollmentRepository {
	public Enrollment findEnroll(int id);
	public List<Object> list();
	public void create(Enrollment objectToCreate);
	public List<Integer> getAllByIdStudent(int idstudent);
}
