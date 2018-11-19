package Antrag;

public class Antrag {
	
		private int id;
	    private String vorname;
	    private String nachname;
	    private Long praeferenz1;
	    private Long praeferenz2;
	    private Long praeferenz3;
	    boolean abgelehnt;
	    
	    public void setID(int id) {
	    	this.id = id;
	    }
	    
	    public int getID () {
	    	return id;
	    }

	    public Antrag(String vorname, String nachname, Long praeferenz1, Long praeferenz2, Long praeferenz3) {
	    }


	    public String getAktenzeichen() {
			return vorname;
		}


		public void setAktenzeichen(String aktenzeichen) {
			this.vorname = aktenzeichen;
		}


		public String getWohnort() {
			return nachname;
		}


		public void setWohnort(String wohnort) {
			this.nachname = wohnort;
		}




		public Long getPraeferenz1() {
			return praeferenz1;
		}


		public void setPraeferenz1(Long praeferenz1) {
			this.praeferenz1 = praeferenz1;
		}


		public Long getPraeferenz2() {
			return praeferenz2;
		}


		public void setPraeferenz2(Long praeferenz2) {
			this.praeferenz2 = praeferenz2;
		}


		public Long getPraeferenz3() {
			return praeferenz3;
		}


		public void setPraeferenz3(Long praeferenz3) {
			this.praeferenz3 = praeferenz3;
		}

		

		@Override
	    public String toString() {
	        return "Antrag { aktenzeichen='" + vorname + "'" + ", wohnort='" + nachname + "', praeferenz1='" + praeferenz1 + "', praeferenz2='" + praeferenz2 + "', praeferenz3='" + praeferenz3 + "' }";
	    }
}
