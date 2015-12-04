package hibernate;
// Generated 26.11.2015 16:00:44 by Hibernate Tools 4.3.1.Final

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer id;
	private String email;
	private String nachname;
	private String password;
	private String username;
	private String vorname;

	public User() {
	}

	public User(String email, String nachname, String password, String username, String vorname) {
		this.email = email;
		this.nachname = nachname;
		this.password = password;
		this.username = username;
		this.vorname = vorname;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

}
