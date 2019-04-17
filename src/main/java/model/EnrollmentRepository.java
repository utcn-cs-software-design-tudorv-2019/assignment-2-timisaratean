package model;

import java.util.List;

public interface EnrollmentRepository {
	public Enrollment findEnroll(int id);
	public List<Enrollment> list();
	public void create(Enrollment objectToCreate);
	public List<Integer> getAllByIdStudent(int idstudent);
}
