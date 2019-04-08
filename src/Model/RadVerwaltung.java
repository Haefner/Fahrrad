package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class RadVerwaltung {
	
Fahrrad rad;
	
	int anzahlLager=0;
	
	int anzahlVerkauft=0;
	
	LocalDate datum;
	
	public RadVerwaltung(Fahrrad rad, int anzahlLager, int anzahlVerkauft, LocalDate date) {
		super();
		this.rad = rad;
		this.anzahlLager = anzahlLager;
		this.anzahlVerkauft = anzahlVerkauft;
		this.datum = date;
	}

	

	public Fahrrad getRad() {
		return rad;
	}

	public void setRad(Fahrrad rad) {
		this.rad = rad;
	}

	public int getAnzahlLager() {
		return anzahlLager;
	}

	public void setAnzahlLager(int anzahlLager) {
		this.anzahlLager = anzahlLager;
	}

	public int getAnzahlVerkauft() {
		return anzahlVerkauft;
	}

	public void setAnzahlVerkauft(int anzahlVerkauft) {
		this.anzahlVerkauft = anzahlVerkauft;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	

}
