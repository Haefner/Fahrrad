package Model;

public class Fahrrad {
	private String bezeichnung;
	private String artikelnummer;
	private String farbe;
	private int zoll;

	public Fahrrad(String bezeichnung, String artikelnummer, String farbe, int zoll) {
		super();
		this.bezeichnung = bezeichnung;
		this.artikelnummer = artikelnummer;
		this.farbe = farbe;
		this.zoll = zoll;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	
	public int getZoll() {
		return zoll;
	}

	public void setZoll(int zoll) {
		this.zoll = zoll;
	}
}