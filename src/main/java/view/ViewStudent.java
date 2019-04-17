package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewStudent extends JFrame{
	JButton btn11,btn12,btn13,btn14;
	JLabel l1;
	public ViewStudent() {
	JFrame frame = new JFrame("Student page");
	l1 = new JLabel("Enroll to another course");
	  l1.setForeground(Color.blue);
	 l1.setBounds(100,120,200,100);
	 frame.add(l1);
	btn11=new JButton("View my courses");
	btn11.setBounds(80, 30, 200, 30);
	frame.add(btn11);
	
	btn12=new JButton("View my information");
	btn12.setBounds(80,70,200,30);
	frame.add(btn12);
	
	btn13=new JButton("Update my information");
	btn13.setBounds(80,110,200,30);
	frame.add(btn13);
	
	btn14=new JButton("Enroll");
	btn14.setBounds(80,190,200,30);
	frame.add(btn14);
	
	frame.setSize(400, 350);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  btn11.setActionCommand("viewcourses");
	  btn12.setActionCommand("viewinfo");
	  btn13.setActionCommand("updateinfo");
	  btn14.setActionCommand("enroll");
	}
	public void addBtnListener(ActionListener listener) {
		btn11.addActionListener(listener);
		btn12.addActionListener(listener);
		btn13.addActionListener(listener);
		btn14.addActionListener(listener);
	}
}
