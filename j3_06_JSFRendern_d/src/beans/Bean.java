package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Bean {
	private int kundenStatus =1;

	public int getKundenStatus() {
		return kundenStatus;
	}

	public void setKundenStatus(int kundenStatus) {
		this.kundenStatus = kundenStatus;
	}

	

}
