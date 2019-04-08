package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Verwaltung {
	
	private List<RadVerwaltung> verwaltung;
	
	public Verwaltung()
	{
		verwaltung= new ArrayList<>();
	}
	
	public void addRadVerwaltung(Fahrrad rad, int anzahlLager, int anzahlVerkauft, LocalDate datum)
	{
		verwaltung.add(new RadVerwaltung(rad, anzahlLager, anzahlVerkauft, datum));
	}
	
	public void addRadVerwaltung(Fahrrad rad, int anzahlLager, int anzahlVerkauft)
	{
		LocalDate date = LocalDate.now();
		verwaltung.add(new RadVerwaltung(rad, anzahlLager, anzahlVerkauft, date));
	}
	

}
