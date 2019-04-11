package model;

public class GuiceModule extends com.google.inject.AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(UserRepository.class).to(UserDAO.class);
		bind(ProfileRepository.class).to(ProfileDAO.class);
		bind(CourseRepository.class).to(CourseDAO.class);
		bind(EnrollmentRepository.class).to(EnrollmentDAO.class);
	}
	
}
