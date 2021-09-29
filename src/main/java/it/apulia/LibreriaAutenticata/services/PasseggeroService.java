package it.apulia.LibreriaAutenticata.services;

import it.apulia.LibreriaAutenticata.model.Passeggero;

import java.util.List;

public interface PasseggeroService
{
    List<Passeggero> getPasseggeri();
    Passeggero getPasseggeroByEmail(String email);
    void deletePasseggero(String idPasseggero);
    void savePasseggero(Passeggero passeggero);
}