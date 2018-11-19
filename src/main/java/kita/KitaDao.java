package kita;


	import java.util.List;

	import de.bund.bva.pliscommon.persistence.dao.Dao;

	/**
	 * DAO-Interface für die Speicherung von KiTas.
	 */
	public interface KitaDao extends Dao<Kita, Long> {

	    List<Kita> leseAlle();

	}


