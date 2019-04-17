package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import com.google.inject.Guice;
import com.google.inject.Injector;

import controller.ControllerTeacher.Listener;
import model.GuiceModule;
import model.Profile;
import model.ProfileBLL;
import view.ReadStudent;
import view.ViewTeacher;

public class ControllerRead {
	Injector guice=Guice.createInjector(new GuiceModule());
	ProfileBLL profile=guice.getInstance(ProfileBLL.class);
	private ReadStudent view;
	private Listener btnListener;
	public ControllerRead(ReadStudent view) {
		this.view = view;
		btnListener = new Listener();
		view.addBtnListener1(btnListener);
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
	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand()=="read") {
				List<Object> list2=new ArrayList<Object>();
				int id1=Integer.parseInt(String.valueOf(view.tf1.getText()));
				Profile p=profile.findbyIdUser(id1);
				list2.add(p);
				view.setTable(createTable(list2));
			}
			
		}

	}
}
