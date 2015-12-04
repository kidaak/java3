package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Adresse")
public class Adresse {
	private long adressId;
	private String ort;
	private String strasse;
	
	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public Adresse(String ort, String strasse) {
		super();
		this.ort = ort;
		this.strasse = strasse;
	}

	@Id
	@GeneratedValue
	@Column(name="ADRESS_ID")
	public long getAdressId() {
		return adressId;
	}

	public void setAdressId(long adressId) {
		this.adressId = adressId;
	}

	@Column(name="ORT")
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Column(name="STRASSE")
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	@Override
	public String toString() {
		return "Adresse [adressId=" + adressId + ", ort=" + ort + ", strasse=" + strasse + "]";
	}
	
	

}
