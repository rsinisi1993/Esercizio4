package it.apulia.LibreriaAutenticata.services;

import it.apulia.LibreriaAutenticata.model.Bagaglio;
import it.apulia.LibreriaAutenticata.model.Prenotazione;
import it.apulia.LibreriaAutenticata.repo.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService
{
    private final PrenotazioneRepo prenotazioneRepository;

    @Autowired
    public PrenotazioneServiceImpl(PrenotazioneRepo prenotazioneRepository)
    {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    @Override
    public List<Prenotazione> getPrenotazioni()
    {
        return prenotazioneRepository.findAll();
    }

    @Override
    public Prenotazione getPrenotazioneByIdPrenotazione(String idPrenotazione)
    {
        return prenotazioneRepository.findById(idPrenotazione).get();
    }

    @Override
    public List<Prenotazione> getPrenotazioniByDataPrenotazione(LocalDate dataPrenotazione)
    {
        return prenotazioneRepository.findPrenotazioniByDataPrenotazione(dataPrenotazione);
    }

    @Override
    public void updatePrenotazione(Prenotazione prenotazione)
    {
        prenotazione.setDataPrenotazione(prenotazione.getDataPrenotazione());
        //prenotazioneRepository.deleteById(prenotazioneRepository.findPrenotazioniByData_prenotazione(prenotazione.getData_prenotazione()).getId());
        prenotazioneRepository.save(prenotazione);
    }

    @Override
    public void deletePrenotazione(String idPrenotazione)
    {
        prenotazioneRepository.deleteById(idPrenotazione);
    }

    @Override
    public void savePrenotazione(Prenotazione prenotazione)
    {
        prenotazioneRepository.save(prenotazione);
    }

    public boolean verifyBagaglio(List<Bagaglio> listaBagagli)
    {
        for (Bagaglio bagaglio : listaBagagli)
        {
            if(bagaglio.equals(Bagaglio.bagaglio_basic))
            {
                return true;
            }
        }
        return false;
    }
}
