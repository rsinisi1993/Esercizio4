package it.apulia.LibreriaAutenticata.config;


import it.apulia.LibreriaAutenticata.model.*;
import it.apulia.LibreriaAutenticata.repo.PasseggeroRepo;
import it.apulia.LibreriaAutenticata.repo.PrenotazioneRepo;
import it.apulia.LibreriaAutenticata.repo.VoloRepo;
import it.apulia.LibreriaAutenticata.services.PasseggeroServiceImpl;
import it.apulia.LibreriaAutenticata.services.PrenotazioneServiceImpl;
import it.apulia.LibreriaAutenticata.services.UserService;
import it.apulia.LibreriaAutenticata.services.VoloServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Configurazione {
    @Bean
    CommandLineRunner commandLineRunner(UserService userService, VoloServiceImpl voloService, VoloRepo voloRepo,
                                        PasseggeroServiceImpl passeggeroService, PasseggeroRepo passeggeroRepo,
                                        PrenotazioneServiceImpl prenotazioneService, PrenotazioneRepo prenotazioneRepo) {
        return args -> {
            userService.resetAll();
            voloRepo.deleteAll();
            passeggeroRepo.deleteAll();
            prenotazioneRepo.deleteAll();


            userService.saveRole(new Role("ROLE_USER"));
            userService.saveRole(new Role("ROLE_MANAGER"));
            userService.saveRole(new Role("ROLE_ADMIN"));
            userService.saveRole(new Role("ROLE_SUPER_ADMIN"));

            passeggeroService.savePasseggero(new Passeggero("abc","John", "Travolta", "jt@gmail.com", new ArrayList<Contatto>()));
            passeggeroService.savePasseggero(new Passeggero("bcd","Will", "Smith", "ws@gmail.com", new ArrayList<Contatto>()));
            passeggeroService.savePasseggero(new Passeggero("cde","Jim", "Carry", "jc@gmail.com", new ArrayList<Contatto>()));
            passeggeroService.savePasseggero(new Passeggero("def","Arnold", "Schwarzenegger", "as@gmail.com", new ArrayList<Contatto>()));

            userService.saveUtente(new Utente("abc", "john", "1234", new ArrayList<>()));
            userService.saveUtente(new Utente("bcd", "will", "1234", new ArrayList<>()));
            userService.saveUtente(new Utente("cde", "jim", "1234", new ArrayList<>()));
            userService.saveUtente(new Utente("def", "arnold", "1234", new ArrayList<>()));

            //.
            userService.addRoleToUtente("john", "ROLE_USER");
            userService.addRoleToUtente("will", "ROLE_MANAGER");
            userService.addRoleToUtente("jim", "ROLE_ADMIN");
            userService.addRoleToUtente("arnold", "ROLE_SUPER_ADMIN");
            userService.addRoleToUtente("arnold", "ROLE_ADMIN");
            userService.addRoleToUtente("arnold", "ROLE_USER");


            voloService.saveVolo(new Volo("abc", "Bari", "Milano", "Alitalia", 200, LocalDate.of(2021,10,04), LocalTime.of(9,00), LocalTime.of(10,00)));
            voloService.saveVolo(new Volo("bcd", "Milano", "Bari", "Alitalia", 200, LocalDate.of(2021,10,04), LocalTime.of(9,00), LocalTime.of(10,00)));
            voloService.saveVolo(new Volo("cde", "Napoli", "Roma", "Alitalia", 200, LocalDate.of(2021,10,04), LocalTime.of(9,00), LocalTime.of(10,00)));
            voloService.saveVolo(new Volo("def", "Bari", "Pisa", "Alitalia", 200, LocalDate.of(2021,10,05), LocalTime.of(9,00), LocalTime.of(10,00)));

            prenotazioneService.savePrenotazione(new Prenotazione("alfa","abc","abc",LocalDate.of(2021,9,27), new ArrayList<Bagaglio>()));
            prenotazioneService.savePrenotazione(new Prenotazione("beta","bcd","bcd",LocalDate.of(2021,9,27), new ArrayList<Bagaglio>()));

        };

    }
}
