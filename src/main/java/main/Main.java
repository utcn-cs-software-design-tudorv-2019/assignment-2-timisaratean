package main;


import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.Course;
import model.CourseBLL;
import model.Enrollment;
import model.EnrollmentBLL;
import model.GuiceModule;
import model.Profile;
import model.ProfileBLL;
import model.User;
import model.UserBLL;

public class Main {
	public static void main(String[] args) {
		Injector guice=Guice.createInjector(new GuiceModule());
		UserBLL user=guice.getInstance(UserBLL.class);
		User u=user.findUser(1);
		System.out.println(u.toString());
		
	}
}
