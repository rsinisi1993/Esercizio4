package it.apulia.LibreriaAutenticata.controllers;

import it.apulia.LibreriaAutenticata.model.Prenotazione;
import it.apulia.LibreriaAutenticata.services.PrenotazioneServiceImpl;
import it.apulia.LibreriaAutenticata.services.VoloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/prenota")
public class PrenotazioniController
{
    private final PrenotazioneServiceImpl prenotazioneService;
    private final VoloServiceImpl voloService;

    @Autowired
    public PrenotazioniController(PrenotazioneServiceImpl prenotazioneService, VoloServiceImpl voloService) {
        this.prenotazioneService = prenotazioneService;
        this.voloService = voloService;
    }

    @PostMapping("/prenotazione")
    public ResponseEntity<Prenotazione> creaPrenotazione(@RequestBody Prenotazione prenotazione)
    {
        if (voloService.verifyVolo(prenotazione.getIdVolo()))
        {
            if (voloService.getVoloByIdVolo(prenotazione.getIdVolo()).getCapienza()>voloService.getVoloByIdVolo(prenotazione.getIdVolo()).getNumeroPasseggeri())
            {
                if (prenotazioneService.verifyBagaglio(prenotazione.getListaBagagli()))
                {
                    voloService.getVoloByIdVolo(prenotazione.getIdVolo()).setNumeroPasseggeri(voloService.getVoloByIdVolo(prenotazione.getIdVolo()).getNumeroPasseggeri()+1);
                    prenotazioneService.savePrenotazione(prenotazione);
                }
                else
                {
                    log.error("Inserire almeno un bagaglio basic");
                }
            }
            else
            {
                log.error("Abbiamo già raggiunto la capienza massima");
            }
        }
        else
        {
            log.error("Il volo non esiste");
        }
        return ResponseEntity.ok().body(prenotazione);
    }
}
