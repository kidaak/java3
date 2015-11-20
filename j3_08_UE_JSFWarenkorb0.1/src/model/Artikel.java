package model;

import java.math.BigDecimal;

public class Artikel {
	
		private int artikelNummer;
		private String name;
		private String beschreibung;
		private String img;
		private BigDecimal preis;
		private int anzahl=1;
		public Artikel(int artikelNummer, String name, String beschreibung, String img, BigDecimal preis) {
			this.artikelNummer = artikelNummer;
			this.name = name;
			this.beschreibung = beschreibung;
			this.img = img;
			this.preis = preis;
		}
		public int getArtikelNummer() {
			return artikelNummer;
		}
		public void setArtikelNummer(int artikelNummer) {
			this.artikelNummer = artikelNummer;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBeschreibung() {
			return beschreibung;
		}
		public void setBeschreibung(String beschreibung) {
			this.beschreibung = beschreibung;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public BigDecimal getPreis() {
			return preis;
		}
		public void setPreis(BigDecimal preis) {
			this.preis = preis;
		}
		public int getAnzahl() {
			return anzahl;
		}
		public void setAnzahl(int anzahl) {
			this.anzahl = anzahl;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + anzahl;
			result = prime * result + artikelNummer;
			result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
			result = prime * result + ((img == null) ? 0 : img.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((preis == null) ? 0 : preis.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Artikel other = (Artikel) obj;
			if (anzahl != other.anzahl)
				return false;
			if (artikelNummer != other.artikelNummer)
				return false;
			if (beschreibung == null) {
				if (other.beschreibung != null)
					return false;
			} else if (!beschreibung.equals(other.beschreibung))
				return false;
			if (img == null) {
				if (other.img != null)
					return false;
			} else if (!img.equals(other.img))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (preis == null) {
				if (other.preis != null)
					return false;
			} else if (!preis.equals(other.preis))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Artikel [artikelNummer=" + artikelNummer + ", name=" + name + ", beschreibung=" + beschreibung
					+ ", img=" + img + ", preis=" + preis + ", anzahl=" + anzahl + "]";
		}
		

}
