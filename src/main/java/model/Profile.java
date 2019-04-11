package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "uni.profile")
public class Profile {
	@Id
  
    @Column(name = "id")
	private int id;
	@Column(name="iduser")
	private int iduser;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="cnp")
	private int cnp;
	
	public Profile() {}
	public Profile(int id, int iduser, String name, String address,int cnp) {
		this.id=id;
		this.iduser=iduser;
		this.name=name;
		this.address=address;
		this.cnp=cnp;
	}
	
	public int getId() {
		return this.id;
	}
	public int getIdUser() {
		return this.iduser;
	}
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public int getCnp() {
		return this.cnp;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setIdUser(int iduser) {
		this.iduser=iduser;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setCnp(int cnp) {
		this.cnp=cnp;
	}
	public String toString() {
		return(id+" "+iduser+" "+name+" "+address+" "+cnp);
	}
	
	
	
	
}
