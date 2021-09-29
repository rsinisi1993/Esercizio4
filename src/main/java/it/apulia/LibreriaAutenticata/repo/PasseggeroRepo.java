package it.apulia.LibreriaAutenticata.repo;

import it.apulia.LibreriaAutenticata.model.Passeggero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasseggeroRepo extends MongoRepository<Passeggero, String>
{
    Passeggero findPasseggeroByEmail(String email);
}
