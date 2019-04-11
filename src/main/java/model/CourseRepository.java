package model;

import java.util.List;

public interface CourseRepository {
	public Course findCourse(int id);
	public List<Object> list();
}
