package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import data.Bestand;
import model.Artikel;
import model.Warenkorb;

@ManagedBean
@SessionScoped
public class ArtikelBean {
	
	private HtmlDataTable table;
	private Artikel auswahlArtikel;
	private Warenkorb warenkorb = new Warenkorb();
	
	public List<Artikel> getArtikellist(){
		return Bestand.getArtikleListe();
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}
	
	public String store(){//TODO ActionListener
		auswahlArtikel =(Artikel) table.getRowData();
		warenkorb.addArtikel(auswahlArtikel);
		return "";
		
	}

	public Artikel getAuswahlArtikel() {
		return auswahlArtikel;
	}

	public void setAuswahlArtikel(Artikel auswahlArtikel) {
		this.auswahlArtikel = auswahlArtikel;
	}

}
