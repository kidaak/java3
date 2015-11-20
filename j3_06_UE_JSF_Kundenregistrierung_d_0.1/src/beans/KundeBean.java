package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.KundeDAO;
import exception.DBConnectException;
import model.Kunde;

@ManagedBean
@SessionScoped
public class KundeBean {
	private int kundenStatus = 1;
	private Kunde kunde;
	private KundeDAO dao;
	private String tempUsername;
	private String tempPassword;
	public KundeBean() {
		try {
			kunde = new Kunde();
			dao = new KundeDAO();
		} catch (DBConnectException e) {
			e.printStackTrace();
		}
	}
	public String getTempUsername() {
		return tempUsername;
	}
	public void setTempUsername(String tempUsername) {
		this.tempUsername = tempUsername;
	}
	public String getTempPassword() {
		return tempPassword;
	}
	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
	public int getKundenStatus() {
		return kundenStatus;
	}
	public void setKundenStatus(int kundenStatus) {
		this.kundenStatus = kundenStatus;
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public String isKundeValid(){//TODO Methodenname??
		kunde = dao.findKunde(tempUsername, tempPassword);
		if(kunde.getKundenNummer()!=-1){
			return "showKunde";//TODO Navigationrules 
		}
		FacesMessage  msg = new FacesMessage("Username und/oder Passort falsch!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("msgout", msg);
		return "noKunde";
	}
	
	public String save(){
		
		boolean isStored= dao.storeNewKunde(kunde);
		if(isStored){
			setKundenStatus(1);
			return "formKunde";
		}
		return "";
	}
}
