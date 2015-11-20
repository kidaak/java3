package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

@ManagedBean
public class AutocompleteBean {
	private List<String> namen = Arrays.asList("Berta","Benny",
			"Alf","Anton","Otto","Oscar","Olaf","Erwin","Erna");
	
	private String auswahl;

	public String getAuswahl() {
		return auswahl;
	}

	public void setAuswahl(String auswahl) {
		this.auswahl = auswahl;
	}
	
	public List<String> loadlist(String query){
		List<String> templist = new ArrayList<>();
		for (String name : namen) {
			if(name.toLowerCase().startsWith(query.toLowerCase())){
				templist.add(name);
			}
		}
		
		System.out.println(query);
		
		
		return templist;
	}
	
	
	public void select(SelectEvent event){
		FacesContext.getCurrentInstance().
		addMessage(null,  new FacesMessage(event.getObject().toString()));
	}
}
