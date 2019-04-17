package main;


import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import controller.Controller;
import model.Course;
import model.CourseBLL;
import model.Enrollment;
import model.EnrollmentBLL;
import model.GuiceModule;
import model.Profile;
import model.ProfileBLL;
import model.User;
import model.UserBLL;
import view.Login;

public class Main {
	public static void main(String[] args) {
		Login v = new Login();
		
		@SuppressWarnings("unused")
		Controller c = new Controller(v);
		
	}
}
