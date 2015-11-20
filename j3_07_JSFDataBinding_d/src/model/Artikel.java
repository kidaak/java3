package model;

public class Artikel {
	
	private int id;
	private String name;
	
	public Artikel(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
