package Antrag;

public class Entscheidung {

	boolean genehmigt;
	String kitaID;
	
	public Entscheidung (boolean abgelehnt, String kitaID) {
		this.genehmigt = abgelehnt;
		this.kitaID = kitaID;
	}
}
