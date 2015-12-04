package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="kurs")
public class Kurs implements java.io.Serializable {

	public static final int BWL=1;
	public static final int PROGRAMMIEREN=2;
	public static final int ANDROID=3;
	
	@Id
	@Column(name = "id_kurs",nullable=false,unique=true)
	private Integer id;
	public Kurs(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private String name;
	

	public Kurs() {
	}

	public Kurs(String name) {
		this.name = name;
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
