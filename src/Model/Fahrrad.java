package Model;

public class Fahrrad {
	private String name;
	private String artikelnummer;
	private String farbe;
	public Fahrrad(String name, String artikelnummer, String farbe, int zoll) {
		super();
		this.name = name;
		this.artikelnummer = artikelnummer;
		this.farbe = farbe;
		this.zoll = zoll;
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
	private int zoll;

}