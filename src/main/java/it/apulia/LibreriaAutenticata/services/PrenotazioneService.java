package it.apulia.LibreriaAutenticata.services;

import it.apulia.LibreriaAutenticata.model.Prenotazione;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneService
{
    List<Prenotazione> getPrenotazioni();
    Prenotazione getPrenotazioneByIdPrenotazione(String idPrenotazione);
    List<Prenotazione> getPrenotazioniByDataPrenotazione(LocalDate dataPrenotazione);
    void updatePrenotazione (Prenotazione prenotazione);
    void deletePrenotazione (String idPrenotazione);
    void savePrenotazione(Prenotazione prenotazione);
}
