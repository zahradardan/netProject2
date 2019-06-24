package ir.asta.training.contacts.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "userTB8")
public class UserEntity {

	boolean student = false ;
	boolean confirmed = false;
	boolean activate = true;
	boolean ismanger = false;
	boolean isTeacher = false;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String name;
	private String password;


	@Column(name = "UserID")
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "UserActivation")
	public boolean getActivate() {
		return activate;
	}

	public void setActivate(boolean act) {
		this.activate = act;
	}


	@Column(name = "Management")
	public boolean getMangement() {
		return ismanger;
	}

	public void setManagement(boolean ismanger) {
		this.ismanger = ismanger;
	}

	@Column(name = "UserName")

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}


	@Column(name = "UsePass")

	public String getPassword() {

		return password;
		
	}

	public void setPassword(String password) {
		
		this.password = password;
		
	}


	@Column(name = "isStudent")

	public boolean getStudent() {

		return student;
		
	}

	public void setStudent(boolean student) {
		
		this.student = student;
		
	}


	@Column(name = "isTeacher")

	public boolean getTeacher() {
		return isTeacher;
	}

	public void setTeacher(boolean teacher) {
		this.isTeacher = teacher;
	}


	@Column(name="isConfirmed")

	public void setConfirmed(boolean confirmed){
		this.confirmed = confirmed;
	}

	public boolean getConfirmed(){
		return confirmed;
	}
}
