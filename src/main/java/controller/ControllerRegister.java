package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.google.inject.Guice;
import com.google.inject.Injector;

import controller.Controller.Listener;
import model.GuiceModule;
import model.Profile;
import model.ProfileBLL;
import view.Register;

public class ControllerRegister {
	private Register register;
	private Listener1 btnListener;
	Injector guice=Guice.createInjector(new GuiceModule());
	ProfileBLL profile=guice.getInstance(ProfileBLL.class);
	
	public ControllerRegister(Register view) {
		this.register = view;
		btnListener = new Listener1();
		view.addBtnListener1(btnListener);
	}
	class Listener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("anaaa");
			if (arg0.getActionCommand()=="register2") {
				System.out.println("anaaa");
				int id1=Integer.parseInt(String.valueOf(register.getft1().getText()));
				String name=String.valueOf(register.getft2().getText());
				String address=String.valueOf(register.getft3().getText());
				int cnp=Integer.parseInt(String.valueOf(register.getft4().getText()));
				int idC=Integer.parseInt(String.valueOf(register.getft5().getText()));
				String username=String.valueOf(register.getft6().getText());
				String pass=String.valueOf(register.getft7().getText());
				Profile p=new Profile(id1,idC,name,address,cnp);
				profile.register(p,username,pass);
				JOptionPane.showMessageDialog(null, "Your account has been created!");
			}
			
		}
	}
	}

