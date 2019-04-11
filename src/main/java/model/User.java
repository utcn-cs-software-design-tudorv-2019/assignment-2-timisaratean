package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "uni.user")
public class User {
	@Id
    @Column(name = "id")
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="tip")
	private int tip;
	
	public User() {}
	
	public User(int idu, String username, String password, int tip) {
		this.id=idu;
		this.username=username;
		this.password=password;
		this.tip=tip;
	}
	
	public int getId() {
		return this.id;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPass() {
		return this.password;
	}
	public int getTip() {
		return this.tip;
	}
	
	public void setId(int idu) {
		this.id=idu;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public void setPass(String password) {
		this.password=password;
	}
	public void setTip(int tip) {
		this.tip=tip;
	}
	public String toString() {
		return (id+" "+username+" "+password+" "+tip); 
	}
}
