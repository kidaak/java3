package beans;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import model.Artikel;

@ManagedBean
@SessionScoped
public class WarenkorbBean {

	@ManagedProperty(value="#{artikelBean}")
	private ArtikelBean artikelBean;

	private HtmlDataTable table;
	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}

	public ArtikelBean getArtikelBean() {
		return artikelBean;
	}

	public void setArtikelBean(ArtikelBean artikelBean) {
		this.artikelBean = artikelBean;
	}
	
	
	
	public String  remove(){
		Artikel artikel = (Artikel) table.getRowData();
		artikelBean.getWarenkorb().removeArtikel(artikel.getArtikelNummer());
		
		return "";
	}
}
