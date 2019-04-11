package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uni.course")
public class Course {
	@Id
	  
    @Column(name = "id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="teacher")
	private String teacher;
	
	public Course() {}
	public Course(int id, String name,String teacher) {
		this.id=id;
		this.name=name;
		this.teacher=teacher;
	}
	
	public int getID() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getTeacher() {
		return this.teacher;
	}
	public void setID(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setTeacher(String teacher) {
		this.teacher=teacher;
	}
	public String toString() {
		return (id+" "+name+" "+teacher);
	}
}
