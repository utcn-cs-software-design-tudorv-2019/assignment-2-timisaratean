package model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.inject.Guice;
import com.google.inject.Injector;



public class CourseBLL {
	CourseRepository courseRepository;
	Injector guice=Guice.createInjector(new GuiceModule());
	EnrollmentBLL e=guice.getInstance(EnrollmentBLL.class);
	@Inject
	public CourseBLL(CourseRepository courseRepository) {
		this.courseRepository=courseRepository;
	}
	public Course findCourse(int id){
        return courseRepository.findCourse(id);
    }
	public List<Object> list() {
        return courseRepository.list();
    }
	public List<Course> listCourses(int id){
		List<Integer> list1= e.findbyIdStudent(id);
		List<Course> list=new ArrayList<Course>();
		for (Integer c: list1) {
			list.add(courseRepository.findCourse(c)); 
			
		}
		return list;
	}
}
