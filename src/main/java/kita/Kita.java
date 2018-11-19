package kita;

public class Kita {
	
	public int id;
	public int postleitzahl;
	public int stadtteilnummer;
	public String stadtteil;
	public int stadtbezirknummer;
	public String stadtbezirk;
	public String adresse;
	
	public Kita (int id, int postleitzahl, int stadtteilnummer, String stadtteil, int stadtbezirknummer, 
			String stadtbezirk, String adresse) {
		this.id = id;
		this.postleitzahl = postleitzahl;
		this.stadtteilnummer = stadtteilnummer;
		this.stadtteil = stadtteil;
		this.stadtbezirknummer = stadtbezirknummer;
		this.stadtbezirk = stadtbezirk;
		this.adresse = adresse;
	}
}
