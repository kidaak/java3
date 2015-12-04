package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
@Entity
public class Artist {
 
	@Id
    @Column(name="ARTIST_ID")
    private String id;
     
    @Column(name="NAME")
    private String name;
     
    @OneToMany(cascade=CascadeType.ALL)
    private Set<Links> links;

	public Artist(String id, String name, Set<Links> links) {
		super();
		this.id = id;
		this.name = name;
		this.links = links;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Links> getLinks() {
		return links;
	}

	public void setLinks(Set<Links> links) {
		this.links = links;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
    
}