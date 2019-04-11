package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uni.enrollment")
public class Enrollment {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name="idstudent")
	private int idstudent;
	@Column(name="idcourse")
	private int idcourse;
	
	public Enrollment() {}
	public Enrollment(int id, int idstudent,int idcourse) {
		this.id=id;
		this.idstudent=idstudent;
		this.idcourse=idcourse;
		
	}
	public int getid() {
		return this.id;
	}
	public int getidC() {
		return this.idcourse;
	}
	public int getidS() {
		return this.idstudent;
	}
	public void setid(int id) {
		this.id=id;
	}
	public void setidC(int idc) {
		this.idcourse=idc;
	}
	public void setidS(int ids) {
		this.idstudent=ids;
	}
	public String toString() {
		return (id+" "+idstudent+" "+idcourse);
	}
}
