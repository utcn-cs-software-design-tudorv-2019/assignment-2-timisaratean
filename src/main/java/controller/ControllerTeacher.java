package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CreateStudent;
import view.DeleteStudent;
import view.ReadStudent;
import view.UpdateStudent;
import view.ViewTeacher;

public class ControllerTeacher {
	private ViewTeacher view;
	private Listener btnListener;
	public ControllerTeacher(ViewTeacher view) {
		this.view = view;
		btnListener = new Listener();
		view.addBtnListener(btnListener);
	}
	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand()=="createstudent") {
				CreateStudent c=new CreateStudent();
				CreateStudentController c2=new CreateStudentController(c);
			}
			if(e.getActionCommand()=="readstudent") {
				ReadStudent c1=new ReadStudent();
				ControllerRead c2=new ControllerRead(c1);
			}
			if (e.getActionCommand()=="updatestudent") {
				UpdateStudent c2=new UpdateStudent();
				ControllerUpdate c3=new ControllerUpdate(c2);
			}
			if(e.getActionCommand()=="deletestudent") {
				DeleteStudent c3=new DeleteStudent();
				ControllerDelete c4=new ControllerDelete(c3);
			}
			
		}
	}
	}

