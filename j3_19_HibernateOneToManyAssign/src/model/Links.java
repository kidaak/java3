package model;



import java.sql.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
 
@Entity
@Table(name="LINKS")
public class Links {
 
    @Id
    @Column(name="LINK_ID")
    private Long id;
     
    @Column(name="URL")
    private String url;
     
    @Column(name="LABEL",unique=true)
    private String label;

	public Links(String url, String label) {
		super();
		this.url = url;
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
     
  
	
}