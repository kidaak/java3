package model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="student")
public class Student implements java.io.Serializable {

	
	@Id
	//@GeneratedValue
	@Column(name = "id_student",unique=true )
	private Integer id;
	private String vorname;
	private String nachname;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(	name="student_kurs", 
				joinColumns={@JoinColumn(name="id_student")},
				inverseJoinColumns={@JoinColumn(name="id_kurs")}
	)
	private Set<Kurs> kurse = new HashSet(0);

	public Student() {
	}

	public Student(Integer id, String vorname, String nachname) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public Student(String vorname, String nachname) {

		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	public void addKurs(Kurs kurs){
		kurse.add(kurs);
	}
	
	public void removeKurs(Kurs kurs){
		kurse.remove(kurs);
	}

	
	public Set<Kurs> getKurse() {
		return kurse;
	}

	public void setKurse(Set<Kurs> kurse) {
		this.kurse = kurse;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", vorname=" + vorname + ", nachname="
				+ nachname + ", kurse=" + kurse + "]";
	}


}
