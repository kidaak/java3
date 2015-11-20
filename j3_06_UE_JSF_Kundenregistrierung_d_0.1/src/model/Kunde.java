package model;

public class Kunde {
	private int kundenNummer=-1;
	private String vorname;
	private String nachname;
	private String email;
	private String username;
	private String passwort;

	public Kunde() {
	}

	public int getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(int kundenNummer) {
		this.kundenNummer = kundenNummer;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	@Override
	public String toString() {
		return "Kunde [kundenNummer=" + kundenNummer + ", vorname=" + vorname + ", nachname=" + nachname + ", email="
				+ email + ", username=" + username + ", passwort=" + passwort + "]";
	}
	
}