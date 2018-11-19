package kita;

	import org.springframework.beans.factory.InitializingBean;
	import org.springframework.transaction.PlatformTransactionManager;
	import org.springframework.transaction.support.TransactionTemplate;
	import org.springframework.web.client.RestTemplate;

	/**
	 * Importiert die Liste aller Kitas aus der Online-Datenquelle und speichert sie in der Datenbank.
	 */
	public class KitaImporter implements InitializingBean {

	    private static final String URL = "http://prodigy84.pythonanywhere.com/api/kitas";

	    private final RestTemplate kitaQuelle = new RestTemplate();

	    private final KitaDao kitaDao;

	    private final PlatformTransactionManager txManager;

	    public KitaImporter(KitaDao kitaDao, PlatformTransactionManager txManager) {
	        this.kitaDao = kitaDao;
	        this.txManager = txManager;
	    }

	    @Override
	    public void afterPropertiesSet() {
	        // @Transactional an afterPropertiesSet() nicht möglich
	        TransactionTemplate tmpl = new TransactionTemplate(txManager);
	        tmpl.execute(status -> {
	            KitaQuelldaten daten = kitaQuelle.getForObject(URL, KitaQuelldaten.class);

	            daten.features.stream().map(feature -> new Kita(feature.attributes.objectId,
	                feature.attributes.stadtbezirk + " (" + feature.attributes.adresse + ") ("
	                    + feature.attributes.traegerTyp + ")")).filter(k -> kitaDao.sucheMitId(k.getId()) == null)
	                .forEach(kitaDao::speichere);

	            return null;
	        });
	    }

	}


