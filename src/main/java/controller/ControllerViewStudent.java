package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControllerTeacher.Listener;
import view.CreateStudent;
import view.DeleteStudent;
import view.Enroll;
import view.Updateinfo;
import view.ViewCourses;
import view.ViewStudent;
import view.Viewinfo;

public class ControllerViewStudent {
	private ViewStudent view;
	private Listener btnListener;
	public ControllerViewStudent(ViewStudent view) {
		this.view = view;
		btnListener = new Listener();
		view.addBtnListener(btnListener);
	}
	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.toString());
			// TODO Auto-generated method stub
			if (e.getActionCommand()=="viewcourses") {
				System.out.println("ddd");
				ViewCourses c=new ViewCourses();
				ViewCoursesController c2=new ViewCoursesController(c);
			}
			if(e.getActionCommand()=="viewinfo") {
				Viewinfo c1=new Viewinfo();
				ControllerViewinfo cc=new ControllerViewinfo(c1);
			}
			if (e.getActionCommand()=="updateinfo") {
				Updateinfo c2=new Updateinfo();
				ControllerUpdateinfo c3=new ControllerUpdateinfo(c2);
			}
			if(e.getActionCommand()=="enroll") {
				Enroll c3=new Enroll();
				ControllerEnroll c4=new ControllerEnroll(c3);
			}
			
		}
	}
	}
