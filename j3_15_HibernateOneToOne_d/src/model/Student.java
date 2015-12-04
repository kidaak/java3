package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student implements Serializable{

	private long id;
	private String name;
	private Adresse adresse;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, Adresse adresse) {
		super();
		this.name = name;
		this.adresse = adresse;
	}

	
	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	@Column(name="STUDENT_NAME" ,nullable=false, length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@OneToOne(cascade=CascadeType.ALL)
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", adresse=" + adresse + "]";
	}
	
	
	
}
