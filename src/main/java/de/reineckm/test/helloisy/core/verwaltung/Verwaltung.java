package de.reineckm.test.helloisy.core.verwaltung;

import de.reineckm.test.helloisy.core.verwaltung.ausgabedaten.EintragDaten;
import de.reineckm.test.helloisy.core.verwaltung.eingabedaten.NeuerEintrag;

import java.util.List;

/**
 * Interface der AWK-Komponente zur Verwaltung (Erstellen und Lesen) von Einträgen.
 */
public interface Verwaltung {


    /**
     * Erstellt einen neuen Eintrag.
     *
     * @param neuerEintrag Schnittstellenobjekt mit den Daten des neuen Eintrags.
     * @return Schnittstellenobjekt mit den Daten des neuen Eintrags zur Darstellung.
     */
    EintragDaten neuerEintrag(NeuerEintrag neuerEintrag);


    /**
     * Liest alle vorhandenen Einträge.
     *
     * @return Eine Liste mit Schnittstellenobjekten zur Darstellung der Einträge.
     */
    List<EintragDaten> leseAlleEintraege();
}
