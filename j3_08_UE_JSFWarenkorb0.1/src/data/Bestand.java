package data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.Artikel;

public class Bestand {
	private static List<Artikel> artikleListe = new ArrayList<>();

	static {
		artikleListe.add(new Artikel(10000, "Hemd", "schönes Hemd", "hemd.jpg", new BigDecimal("20.00")));
		artikleListe.add(new Artikel(11111, "Hose", "schöne Hose", "hose.jpg", new BigDecimal("10.00")));
		artikleListe.add(new Artikel(12222, "Mantel", "schöner Mantel", "mantel.jpg", new BigDecimal("10.00")));
	}

	public static List<Artikel> getArtikleListe() {
		return artikleListe;
	}
}
