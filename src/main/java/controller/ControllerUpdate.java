package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JTable;

import com.google.inject.Guice;
import com.google.inject.Injector;

import controller.ControllerRead.Listener;
import model.GuiceModule;
import model.Profile;
import model.ProfileBLL;
import view.ReadStudent;
import view.UpdateStudent;

public class ControllerUpdate {
	Injector guice=Guice.createInjector(new GuiceModule());
	ProfileBLL profile=guice.getInstance(ProfileBLL.class);
	private UpdateStudent view;
	private Listener btnListener;
	public ControllerUpdate(UpdateStudent view) {
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
			if(e.getActionCommand()=="update") {
				
				int idU=Integer.parseInt(view.getTable().getValueAt(view.getTable().getSelectedRow(), 0).toString());
				int idU1=Integer.parseInt(view.getTable().getValueAt(view.getTable().getSelectedRow(), 1).toString());
				String name=view.getTable().getValueAt(view.getTable().getSelectedRow(), 2).toString();
				String address=view.getTable().getValueAt(view.getTable().getSelectedRow(), 3).toString();
				int cnp=Integer.parseInt(view.getTable().getValueAt(view.getTable().getSelectedRow(), 4).toString());
				Profile p=new Profile(idU,idU1,name,address,cnp);
				profile.update(p);
				view.setTable(createTable(profile.list()));
			}
		}
	}
	}

