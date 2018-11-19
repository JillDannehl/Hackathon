package de.reineckm.test.helloisy.persistence.verwaltung.dao;

import de.reineckm.test.helloisy.persistence.verwaltung.entity.Eintrag;
import de.bund.bva.pliscommon.persistence.dao.Dao;

import java.util.List;

/**
 * DAO-Interface für die Persistierung von Einträgen.
 */
public interface EintragDao extends Dao<Eintrag, Long> {

    /**
     * Liest alle vorhandenen Einträge.
     *
     * @return Eine Liste mit allen Einträgen.
     */
    List<Eintrag> leseAlle();
}
