package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ReadStudent extends JFrame {
	public JLabel l1;
	public JTextField tf1;
	public JButton btn1;
	private JTable table;
	 private JScrollPane scrollPane=new JScrollPane();
	 public ReadStudent() {
		 JFrame frame = new JFrame("Read student");
		 l1=new JLabel("Introduceti id-ul studentului");
		 btn1=new JButton("Cauta!");
		 tf1=new JTextField();
		 l1.setBounds(80, 30, 200, 30);
		 tf1.setBounds(310, 30,200,30);
		 btn1.setBounds(150, 80,200,30);
		 
		 frame.add(l1);
		 frame.add(tf1);
		 frame.add(btn1);
		 
		 scrollPane.setBounds(10, 170, 530, 160);
			frame.add(scrollPane);
		 
		 frame.setSize(580, 400);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  frame.setLayout(null);
		  frame.setVisible(true);
		  btn1.setActionCommand("read");
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
