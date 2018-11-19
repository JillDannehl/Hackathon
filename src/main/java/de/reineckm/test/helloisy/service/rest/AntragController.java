package de.reineckm.test.helloisy.service.rest;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Antrag.Antrag;
import Antrag.Entscheidung;
import de.reineckm.test.helloisy.core.verwaltung.Verwaltung;


@RestController
@RequestMapping("/antrag")
public class AntragController {
	private final Verwaltung verwaltung;
	public ArrayList<Antrag> offeneAntrage = new ArrayList<>();
	public HashMap<Antrag, Entscheidung> antragMap = new HashMap<>();
	int idFolge = 1;

    @Autowired
    public AntragController(Verwaltung verwaltung) {
        this.verwaltung = verwaltung;
    }
    
    public void AntragEmpfangen (Antrag a) {
    	a.setID(idFolge);
    	idFolge++;
    	offeneAntrage.add(a);
    	Entscheidung e = new Entscheidung (true, "");
    	antragMap.put(a,e);
    }
    
    public ArrayList<Antrag> getOffeneAntrage () {
    	return offeneAntrage;
    }
    
    public void AntragBewerten (Antrag a, boolean genehmigt, String kitaID) {
    	offeneAntrage.remove(a);
    	Entscheidung e = new Entscheidung (genehmigt, kitaID);
    	antragMap.put(a, e);
    }
    
    public Entscheidung getStatus (Antrag a) {
    	return antragMap.get (a);
    }
    /**
     * Erzeugt einen neuen Eintrag.
     *
     * @param neuerEintrag Schnittstellenobjekt zur Erstellung eines neuen Eintrags.
     */
    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void erstelleEintrag(@RequestBody Antrag a) {
        verwaltung.erfasseAntrag(a);
    }

}
