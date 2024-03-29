package Model;

public class Fahrrad {
	private String name;
	private String artikelnummer;
	private Typ typ;
	private String farbe;
	private int zoll;

	public Fahrrad(String name, String artikelnummer, Typ typ, String farbe, int zoll) {
		super();
		this.name = name;
		this.artikelnummer = artikelnummer;
		this.farbe = farbe;
		this.zoll = zoll;
		this.typ = typ;
	}

	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public int getZoll() {
		return zoll;
	}

	public void setZoll(int zoll) {
		this.zoll = zoll;
	}

}