package beans;

import java.awt.event.ActionEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MessageBean {
	
	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
	public void message(){
	
		if(x<0){
		FacesContext.getCurrentInstance().addMessage("",
				
	new FacesMessage(FacesMessage.SEVERITY_WARN,"zu klein","keine negative Zahl"));
		
		}
	}
	

}
