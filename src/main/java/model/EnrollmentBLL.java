package model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;



public class EnrollmentBLL {
	EnrollmentRepository enrollmentRepository;
	
	@Inject
	public EnrollmentBLL(EnrollmentRepository enrollmentRepository) {
		this.enrollmentRepository=enrollmentRepository;
	}
	
	public Enrollment findEnroll(int id){
        return enrollmentRepository.findEnroll(id);
    }
	public List<Object> list() {
        return enrollmentRepository.list();
    }
	public void create(Enrollment client) {

        enrollmentRepository.create(client);
    }
	public List<Integer> findbyIdStudent(int id){
		return enrollmentRepository.getAllByIdStudent(id);
	}
}
