package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.Course;
import model.CourseBLL;
import model.EnrollmentBLL;
import model.GuiceModule;
import model.Profile;
import model.ProfileBLL;
import model.User;
import model.UserBLL;

public class Tests {
	Injector guice=Guice.createInjector(new GuiceModule());
	EnrollmentBLL e=guice.getInstance(EnrollmentBLL.class);
	UserBLL u=guice.getInstance(UserBLL.class);
	ProfileBLL p=guice.getInstance(ProfileBLL.class);
	CourseBLL c=guice.getInstance(CourseBLL.class);
	@Test
	public void test1() {
		User expecteduser=new User(1,"timi@yahoo.com","timi",1);
		String s1=expecteduser.toString();
		User actualuser=u.findUser(1);
		String s2=actualuser.toString();
		System.out.println(actualuser.toString());
		Assert.assertEquals(s1,s2);
	}
	
	@Test
	public void test2() {
		int expected1=u.login("admin", "admin");
		int actual=0;
		Assert.assertEquals(expected1, actual);
	}
	
	@Test
	public void test3() {
		Profile expected=new Profile(4,3,"Monalisa","Moldova",444);
		String s1=expected.toString();
		Profile actual=p.findbyIdUser(3);
		String s2=actual.toString();
		Assert.assertEquals(s1, s2);
		
	}
	@Test
    public void test4() {
		Profile expected=new Profile(4,3,"Monalisa","Moldova",444);
		String s1=expected.toString();
		Profile actual=p.findProfile(4);
		String s2=actual.toString();
		Assert.assertEquals(s1,s2);
	}
	@Test
	public void test5() {
		Course expected=new Course(2,"SSC","Baruch");
		String s1=expected.toString();
		Course actual=c.findCourse(2);
		String s2=actual.toString();
		Assert.assertEquals(s1, s2);
		
	}
	@Test
	public void test6() {
		Course cc=new Course(2,"SSC","Baruch");
		String s=cc.toString();
		List<Course> l2=c.listCourses(2);
		String s1=l2.get(0).toString();
		Assert.assertEquals(s,s1);
	}
}
