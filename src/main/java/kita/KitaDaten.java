package kita;

public class KitaDaten {
	    private Long id;

	    private String name;

	    public KitaDaten() {
	    }

	    public KitaDaten(Long id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public KitaDaten(Kita kita) {
	        this.id = kita.getId();
	        this.name = kita.getName();
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	}


