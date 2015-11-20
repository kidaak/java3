package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Warenkorb {
	
	private List<Artikel> warenkorbliste = new ArrayList<>();

	public List<Artikel> getWarenkorbliste() {
		return warenkorbliste;
	}
	
	public void addArtikel(Artikel artikel){
		if(!warenkorbliste.contains(artikel))
			warenkorbliste.add(artikel);
	}
	
	
	public void removeArtikel(int artNr){
		warenkorbliste.removeIf(art -> art.getArtikelNummer()==artNr );//Java8
	}
	
	public BigDecimal getGesamtpreis(){
		BigDecimal bd = new BigDecimal(0);
		
		for (Artikel artikel : warenkorbliste) {
//			BigDecimal tempBig = bd.add(artikel.getPreis().
//					multiply(new BigDecimal(artikel.getAnzahl())));
//			bd = tempBig;
			BigDecimal tempBig = new BigDecimal(artikel.getAnzahl());
			bd = bd.add(artikel.getPreis().multiply(tempBig));
		}
		return bd;//TODO rechnen
	}

}
