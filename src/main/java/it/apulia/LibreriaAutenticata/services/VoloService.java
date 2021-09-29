package it.apulia.LibreriaAutenticata.services;

import it.apulia.LibreriaAutenticata.model.Volo;

import java.time.LocalDate;
import java.util.List;

public interface VoloService
{
    List<Volo> getVoli();
    List<Volo> getVoliByData(LocalDate giornoPartenza);
    Volo getVoloByIdVolo(String idVolo);
    void updateVolo(Volo volo);
    void deletVolo(String idVolo);
    void saveVolo(Volo volo);
    boolean verifyVolo(String idVolo);
}
