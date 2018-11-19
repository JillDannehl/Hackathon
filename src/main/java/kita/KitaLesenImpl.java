package kita;

	import java.util.List;
	import java.util.Set;
	import java.util.stream.Collectors;

	import org.springframework.transaction.annotation.Transactional;

	@Transactional
	public class KitaLesenImpl implements KitaLesen {

	    private final KitaDao kitaDao;

	    public KitaLesenImpl(KitaDao kitaDao) {
	        this.kitaDao = kitaDao;
	    }

	    @Override
	    public Set<KitaDaten> leseKitas() {
	        List<Kita> kitas = kitaDao.leseAlle();

	        return kitas.stream().map(KitaDaten::new).collect(Collectors.toSet());
	    }
	}