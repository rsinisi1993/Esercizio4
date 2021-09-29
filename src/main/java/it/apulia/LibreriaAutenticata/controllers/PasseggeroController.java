package it.apulia.LibreriaAutenticata.controllers;

import it.apulia.LibreriaAutenticata.model.Passeggero;
import it.apulia.LibreriaAutenticata.services.PasseggeroServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/viaggiatori")
public class PasseggeroController
{
    private final PasseggeroServiceImpl passeggeroService;

    @Autowired
    public PasseggeroController(PasseggeroServiceImpl passeggeroService) {
        this.passeggeroService = passeggeroService;
    }

    @PostMapping("/passeggero")
    public ResponseEntity<Passeggero> creaPasseggero(@RequestBody Passeggero passeggero)
    {
        passeggeroService.savePasseggero(passeggero);
        return ResponseEntity.ok().body(passeggero);
    }
}
