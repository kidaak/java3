package beans;

import java.util.Arrays;
import java.util.List;

public class PersonBean {
	private String name="No Name";
	
	private List<String> freunde =  Arrays.asList("Max","Erna","Otto");

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFreunde() {
		return freunde;
	}

	public void setFreunde(List<String> freunde) {
		this.freunde = freunde;
	}
	
	

}
