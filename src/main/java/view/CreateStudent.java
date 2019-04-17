package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CreateStudent extends JFrame {
	private JTable table;
	private JScrollPane scrollPane=new JScrollPane();
	JLabel l1,l2,l3;
	JLabel l4,l5,l6,l7;
	 public JTextField tf1;
	public JTextField tf2;
	public JTextField tf3;
	public JTextField tf4;
	public JTextField tf5;
	public JTextField tf6;
	public JTextField tf7;
	 JButton btn1;
	 public CreateStudent() {
	  JFrame frame = new JFrame("Create student");
	  l1 = new JLabel("Id");
	  l2 = new JLabel("Name");
	  l3 = new JLabel("Address");
	  l4= new JLabel("CNP");
	  l5=new JLabel("Id User");
	  l6=new JLabel("Username");
	  l7=new JLabel("Password");
	  tf1 = new JTextField();
	  tf2 = new JTextField();
	  tf3 = new JTextField();
	  tf4 = new JTextField();
	  tf5 = new JTextField();
	  tf6 = new JTextField();
	  tf7 = new JTextField();
	  btn1=new JButton("Create student!");
	 
	  l1.setBounds(80, 30, 200, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  l4.setBounds(80, 150, 200, 30);
	  l5.setBounds(80, 190, 200, 30);
	  l6.setBounds(80, 230, 200, 30);
	  l7.setBounds(80, 270, 200, 30);
	  tf1.setBounds(300, 30, 200, 30);
	  tf2.setBounds(300, 70, 200, 30);
	  tf3.setBounds(300, 110, 200, 30);
	  tf4.setBounds(300, 150, 200, 30);
	  tf5.setBounds(300, 190, 200, 30);
	  tf6.setBounds(300, 230, 200, 30);
	  tf7.setBounds(300, 270, 200, 30);
	  scrollPane.setBounds(10, 370, 530, 160);
	  frame.add(scrollPane);
	  
	  btn1.setBounds(180, 330, 200, 30);
	
	 
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(l5);
	  frame.add(l6);
	  frame.add(l7);
	  frame.add(tf1);
	  frame.add(tf2);
	  frame.add(tf3);
	  frame.add(tf4);
	  frame.add(tf5);
	  frame.add(tf6);
	  frame.add(tf7);
	  frame.add(l3);
	  frame.add(btn1);
	  frame.add(l4);
	  frame.setSize(580, 600);
	  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  btn1.setActionCommand("create");
}
	 public void addBtnListener1(ActionListener listener) {
			btn1.addActionListener(listener);
		}
	 public void setTable(JTable newTable) {
			this.table = newTable;
			scrollPane.setViewportView(table);
			repaint();
			revalidate();
		}
}
