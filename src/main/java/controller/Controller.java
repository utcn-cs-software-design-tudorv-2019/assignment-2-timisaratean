package controller;

import view.Login;
import view.ViewStudent;
import view.ViewTeacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.UserBLL;
import view.Register;
import model.GuiceModule;
import model.ProfileBLL;

public class Controller {
	private Login login;
	private Listener btnListener;
	Injector guice=Guice.createInjector(new GuiceModule());
	UserBLL user=guice.getInstance(UserBLL.class);
	ProfileBLL profile=guice.getInstance(ProfileBLL.class);
	
	public Controller(Login view) {
		this.login = view;
		btnListener = new Listener();
		view.addBtnListener(btnListener);
	}
	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand()=="login") {
				login.idd=user.findId(String.valueOf(login.tf1.getText()));
			if(user.login(String.valueOf(login.gettf1().getText()),String.valueOf(login.gettf2().getPassword()))==0)
			{
				System.out.println("Login as teacher");
				ViewTeacher v=new ViewTeacher();
				ControllerTeacher c1=new ControllerTeacher(v);
				
				
			} 
			else 
				if(user.login(String.valueOf(login.gettf1().getText() ),String.valueOf(login.gettf2().getPassword()))==1) {
				System.out.println("Login as student");
				ViewStudent v1=new ViewStudent();
				ControllerViewStudent c=new ControllerViewStudent(v1);
				
				}
			
		}
			if(e.getActionCommand()=="register") {
					System.out.println("aaaa");
					Register r1=new Register();
					ControllerRegister c1=new ControllerRegister(r1);
				}
		}
	}
}
