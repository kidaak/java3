package beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class PersonBean implements Serializable{
	private String name;
	private List<String> freunde =Arrays.asList("Marta","Otto","Inge");
	
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((freunde == null) ? 0 : freunde.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonBean other = (PersonBean) obj;
		if (freunde == null) {
			if (other.freunde != null)
				return false;
		} else if (!freunde.equals(other.freunde))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PersonBean [name=" + name + ", freunde=" + freunde + "]";
	}
	
	
	
	

}
