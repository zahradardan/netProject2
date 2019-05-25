package ir.asta.training.contacts.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "userTB")
public class UserEntity {

	boolean isStudent = false ;
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

//	@Basic

	@Column(name = "UserName")

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

//	@Basic

	@Column(name = "UsePass")

	public String getPassword() {

		return password;
		
	}

	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
//	@Basic

	@Column(name = "isStudent")

	public boolean getStatus() {

		return isStudent;
		
	}

	public void setStatus(boolean isStudent) {
		
		this.isStudent = isStudent;
		
	}

}
