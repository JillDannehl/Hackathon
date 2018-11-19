package de.reineckm.test.helloisy.service.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Factory zum Erzeugen eines ObjectMappers, der
 *  - die Java 8 Erweiterungen von Jackson lädt
 *  - Datums- und Zeitangaben nicht als Timestamp serialisiert
 *
 */
public class CustomObjectMapperFactory {

    /**
     * Erzeugt eine konfigurierte Instanz eines ObjectMappers.
     *
     * @return die ObjectMapper-Instanz.
     */
    public static ObjectMapper getInstance() {

        ObjectMapper mapper = new ObjectMapper();

        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper;
    }
}
