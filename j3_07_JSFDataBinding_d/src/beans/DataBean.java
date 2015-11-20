package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import model.Artikel;

@ManagedBean
@SessionScoped
public class DataBean {
	
	
	private List<Artikel> list = new ArrayList<>();
	private HtmlDataTable table;
	private Artikel artikel;
	
	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public DataBean() {
		list.add(new Artikel(1, "Smartphone"));
		list.add(new Artikel(2, "Staubsauger"));
		list.add(new Artikel(3, "Drucker"));
		
	}

	public List<Artikel> getList() {
		return list;
	}

	public void setList(List<Artikel> list) {
		this.list = list;
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}
	
	
	public String store(){
		artikel = (Artikel) table.getRowData();
		System.out.println(artikel);
		return "";
	}
	

}
