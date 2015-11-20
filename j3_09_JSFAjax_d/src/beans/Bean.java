package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Bean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
		
	}
	
}
