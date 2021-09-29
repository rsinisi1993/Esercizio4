package it.apulia.LibreriaAutenticata.repo;

import it.apulia.LibreriaAutenticata.model.Volo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoloRepo extends MongoRepository<Volo, String>
{
    boolean existsById(String idVolo);
    public List<Volo> findVoliByGiornoPartenza(LocalDate giornoPartenza);
}