package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.inject.Guice;
import com.google.inject.Injector;
import model.Enrollment;
import model.EnrollmentBLL;
import model.GuiceModule;


import view.Enroll;
import view.Login;


public class ControllerEnroll {
	private Enroll enroll;
	private Listener1 btnListener; 
	Injector guice=Guice.createInjector(new GuiceModule());
	EnrollmentBLL profile=guice.getInstance(EnrollmentBLL.class);
	public ControllerEnroll(Enroll view) {
		this.enroll = view;
		btnListener = new Listener1();
		view.addBtnListener(btnListener);
	}
	class Listener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getActionCommand()=="enrollment") {
				int ok=0;
				
					
					int idU=Integer.parseInt(enroll.getTable().getValueAt(enroll.getTable().getSelectedRow(), 0).toString());
					Enrollment p=new Enrollment((idU+Login.idd)*10,Login.idd,idU);
					List<Enrollment> list=profile.list();
					for(Enrollment pc:list) {
						System.out.println(pc.toString());
						if (pc.getidS()==Login.idd && pc.getidC()==idU) {
							System.out.println(ok);
							ok=1;
						}
					}
					if (ok==0) {
					profile.create(p);
					JOptionPane.showMessageDialog(null, "You enrolled to the course");
					}
					else {
					JOptionPane.showMessageDialog(null, "You are already enrolled to this course");
					
					
					
				}
			}
			
		}
}
}
