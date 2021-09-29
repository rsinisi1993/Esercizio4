package it.apulia.LibreriaAutenticata.controllers;

import it.apulia.LibreriaAutenticata.model.Volo;
import it.apulia.LibreriaAutenticata.services.VoloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/aereoporto")
public class VoloController
{
    private final VoloServiceImpl voloService;

    @Autowired
    public VoloController(VoloServiceImpl voloService)
    {
        this.voloService = voloService;
    }

    @GetMapping("/voli")
    public ResponseEntity<List<Volo>> mostraVoli()
    {
        Collections.sort(voloService.getVoli());
        return ResponseEntity.ok().body(voloService.getVoli());
    }

    @PostMapping("/voli")
    public ResponseEntity<Volo> aggiungiVolo(@RequestBody Volo volo)
    {
        voloService.saveVolo(volo);
        return ResponseEntity.ok().body(volo);
    }

    @GetMapping("/voli/{giornoPartenza}")
    public ResponseEntity<List<Volo>> mostarVoliByGiornoPartenza(@PathVariable LocalDate giornoPartenza)
    {
        return ResponseEntity.ok().body(voloService.getVoliByData(giornoPartenza));
    }

    @GetMapping("/voli/ricerca/{idVolo}")
    public ResponseEntity<Volo> mostraVoliByIdVolo(@PathVariable String idVolo)
    {
        return ResponseEntity.ok().body(voloService.getVoloByIdVolo(idVolo));
    }
}
