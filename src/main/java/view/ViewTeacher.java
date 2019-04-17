package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewTeacher  extends JFrame {
	JButton btn1,btn2,btn3,btn4;
	public ViewTeacher() {
		JFrame frame = new JFrame("Admin page");
		btn1=new JButton("Create student");
		btn2=new JButton("Read student information");
		btn3=new JButton("Update student information");
		btn4=new JButton("Delete student");
		
		btn1.setBounds(80, 30, 200, 30);
		btn2.setBounds(80, 70, 200, 30);
		btn3.setBounds(80, 110, 200, 30);
		btn4.setBounds(80, 150, 200, 30);
		
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		
		  frame.setSize(400, 350);
		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  frame.setLayout(null);
		  frame.setVisible(true);
		  btn1.setActionCommand("createstudent");
		  btn2.setActionCommand("readstudent");
		  btn3.setActionCommand("updatestudent");
		  btn4.setActionCommand("deletestudent");
	}
	public void addBtnListener(ActionListener listener) {
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
		btn4.addActionListener(listener);
	}

}
