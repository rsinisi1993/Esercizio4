package it.apulia.LibreriaAutenticata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "prenotazioni")
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione
{
    @Id
    private String idPrenotazione;
    private String idVolo;
    private String idPasseggero;
    private LocalDate dataPrenotazione;
    private List<Bagaglio> listaBagagli;
}