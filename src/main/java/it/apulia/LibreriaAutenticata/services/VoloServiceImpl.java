package it.apulia.LibreriaAutenticata.services;

import it.apulia.LibreriaAutenticata.model.Volo;
import it.apulia.LibreriaAutenticata.repo.VoloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VoloServiceImpl implements VoloService
{
    private final VoloRepo voloRepository;

    @Autowired
    public VoloServiceImpl (VoloRepo voloRepository)
    {
        this.voloRepository = voloRepository;
    }
    @Override
    public List<Volo> getVoli()
    {
        return voloRepository.findAll();
    }

    @Override
    public List<Volo> getVoliByData(LocalDate giornoPartenza)
    {
        return voloRepository.findVoliByGiornoPartenza(giornoPartenza);
    }

    @Override
    public Volo getVoloByIdVolo(String idVolo)
    {
        return voloRepository.findById(idVolo).get();
    }

    @Override
    public void updateVolo(Volo volo)
    {
        volo.setGiornoPartenza(volo.getGiornoPartenza());
        voloRepository.deleteById(volo.getIdVolo());
        voloRepository.save(volo);
    }

    @Override
    public void deletVolo(String idVolo)
    {
        voloRepository.deleteById(idVolo);
    }

    @Override
    public void saveVolo(Volo volo)
    {
        voloRepository.save(volo);
    }

    @Override
    public boolean verifyVolo(String idVolo)
    {
        return voloRepository.existsById(idVolo);
    }
}
