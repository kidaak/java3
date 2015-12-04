package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
//@Table(name="user")  // optional für Tabellenname
public class User implements Serializable{

	private Integer id;
	private String vorname;
	private String nachname;
	private String email;
	private String password;
	private String username;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String vorname, String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public User(String vorname, String nachname, String email, String password, String username) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.password = password;
		this.username = username;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)// Autoincrement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", email=" + email + ", password="
				+ password + ", username=" + username + "]";
	}
	
	
}
