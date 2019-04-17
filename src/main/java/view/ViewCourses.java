package view;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.CourseBLL;
import model.GuiceModule;
import model.ProfileBLL;

public class ViewCourses extends JFrame {
	Injector guice=Guice.createInjector(new GuiceModule());
	CourseBLL course=guice.getInstance(CourseBLL.class);
	Login login=new Login();
	private JTable table;
	 private JScrollPane scrollPane=new JScrollPane();
	public ViewCourses() {
		JFrame frame = new JFrame("View my courses");
		scrollPane.setBounds(10, 30, 530, 160);
		frame.add(scrollPane);
		 
		frame.setSize(580, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		setTable(createTable(course.listCourses(login.idd)));
		
	}
	private <T> JTable createTable(List<T> object) {
		JTable table = null;
		int numberOfColumns = object.get(0).getClass().getDeclaredFields().length;
		String columns[] = new String[numberOfColumns];
		int i=0;
		for (Field field : object.get(0).getClass().getDeclaredFields()) {
			columns[i] = field.getName();
			i++;
		
		}
		String rows[][] = new String[object.size()][numberOfColumns];
		int row = 0;
		for (Object obj : object) {
			int col = 0;
			for (Field field : obj.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value;
				try {
					value = field.get(obj);
					rows[row][col] = value.toString();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				col++;
			}
			row++;
		}
		table = new JTable(rows,columns);
		return table;
	}
public void setTable(JTable newTable) {
		this.table = newTable;
		scrollPane.setViewportView(table);
		repaint();
		revalidate();
	}

}
