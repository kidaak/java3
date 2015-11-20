package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Warenkorb {
	
	private Set<Artikel> warenkorbliste = new HashSet<>();

	public Set<Artikel> getWarenkorbliste() {
		return warenkorbliste;
	}
	
	public void addArtikel(Artikel artikel){
		warenkorbliste.add(artikel);
	}
	
	
	public void removeArtikel(int artNr){
		warenkorbliste.removeIf(art -> art.getArtikelNummer()==artNr );//Java8
		
	}
	
	public BigDecimal getGesamtpreis(){
		
		
		return null;//TODO rechnen
	}

}
