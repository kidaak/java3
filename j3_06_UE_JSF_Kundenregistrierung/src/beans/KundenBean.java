package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import data.Kunde;
import db.KundenDao;
import exception.DBConnectException;

@ManagedBean
@SessionScoped
public class KundenBean {

	private int kundenStatus = 1;
	
	private Kunde kunde = new Kunde();
	private boolean kundeValid;
	private KundenDao dao;
	private String tempUserName;
	private String tempPassword;
	
	
//	public KundenBean() {
//		try {
//			dao = new KundenDao();
//		} catch (DBConnectException e) {
//			e.printStackTrace();
//		}
//	}
	
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
	
	public String isKundeValid() {
		kunde = dao.findKunde(tempUserName, tempPassword);
		if(kunde.getKundenNummer() != -1 ) {
			return "showKunde";
		}
		return "noKunde";
	}
	public void setKundeValid(boolean kundeValid) {
		this.kundeValid = kundeValid;
	}	
	
	public String getTempUserName() {
		return tempUserName;
	}

	public void setTempUserName(String tempUserName) {
		this.tempUserName = tempUserName;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
}
