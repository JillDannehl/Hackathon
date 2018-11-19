package de.reineckm.test.helloisy.core.verwaltung.impl;

import de.reineckm.test.helloisy.core.verwaltung.Verwaltung;
import de.reineckm.test.helloisy.core.verwaltung.ausgabedaten.EintragDaten;
import de.reineckm.test.helloisy.core.verwaltung.eingabedaten.NeuerEintrag;
import de.reineckm.test.helloisy.persistence.verwaltung.dao.EintragDao;
import de.reineckm.test.helloisy.persistence.verwaltung.entity.Eintrag;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class VerwaltungImpl implements Verwaltung {

    private final EintragDao eintragDao;

    public VerwaltungImpl(EintragDao eintragDao) {
        this.eintragDao = eintragDao;
    }

    @Override
    public EintragDaten neuerEintrag(NeuerEintrag neuerEintrag) {
        Eintrag eintrag = new Eintrag();
        eintrag.setText(neuerEintrag.getText());
        eintrag.setVerfasser(neuerEintrag.getVerfasser());
        eintrag.setDatum(ZonedDateTime.now(ZoneId.of("Z")));

        eintragDao.speichere(eintrag);

        return mappeEintrag(eintrag);
    }

    @Override
    public List<EintragDaten> leseAlleEintraege() {
        return eintragDao.leseAlle().stream().map(this::mappeEintrag).collect(Collectors.toList());
    }

    private EintragDaten mappeEintrag(Eintrag eintrag) {
        return new EintragDaten(eintrag.getVerfasser(), eintrag.getText(), eintrag.getDatum());
    }
}
