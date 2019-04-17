package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.google.inject.Guice;
import com.google.inject.Injector;


import model.CourseBLL;
import model.GuiceModule;
import model.UserBLL;

public class Login extends JFrame {
	Injector guice=Guice.createInjector(new GuiceModule());
	UserBLL course=guice.getInstance(UserBLL.class);
	JLabel l1, l2, l3;
	JLabel l4;
	 public static JTextField tf1;
	public static int idd;
	 JButton btn1;
	 JButton btn2;
	 JPasswordField p1;
	 public Login() {
	  JFrame frame = new JFrame("Login Form");
	  l1 = new JLabel("Login Form");
	  l1.setForeground(Color.blue);
	 
	 
	  l2 = new JLabel("Username");
	  l3 = new JLabel("Password");
	  l4= new JLabel("Create your account");
	  l4.setForeground(Color.blue);
	  tf1 = new JTextField();
	  p1 = new JPasswordField();
	  btn1 = new JButton("Login");
	  btn2=new JButton("Register");
	 
	  l1.setBounds(250, 30, 400, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  tf1.setBounds(300, 70, 200, 30);
	  p1.setBounds(300, 110, 200, 30);
	  btn1.setBounds(250, 160, 100, 30);
	  btn2.setBounds(250,200,100,30);
	  l4.setBounds(100,200 , 150, 30);
	 
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(tf1);
	  frame.add(l3);
	  frame.add(p1);
	  frame.add(btn1);
	  frame.add(btn2);
	  frame.add(l4);
	  frame.setSize(600, 300);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  btn1.setActionCommand("login");
	  btn2.setActionCommand("register");
	 }
	 public void addBtnListener(ActionListener listener) {
			btn1.addActionListener(listener);
			btn2.addActionListener(listener);
		}
	 public JTextField gettf1() {
		 return tf1;
	 }
	 public JPasswordField gettf2() {
		 return p1;
	 }
	 
}
