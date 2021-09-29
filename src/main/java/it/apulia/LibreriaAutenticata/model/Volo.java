package it.apulia.LibreriaAutenticata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Volo implements Comparable<Volo>
{
    @Id
    private String idVolo;
    private String cittaPartenza;
    private String cittaDestinazione;
    private String compagniaVolo;
    private Integer capienza;
    private LocalDate giornoPartenza;
    private LocalTime oraPartenza;
    private LocalTime oraArrivo;
    private Integer numeroPasseggeri = 0;

    public Volo(String idVolo, String cittaPartenza, String cittaDestinazione, String compagniaVolo, Integer capienza, LocalDate giornoPartenza, LocalTime oraPartenza, LocalTime oraArrivo)
    {
        this.idVolo = idVolo;
        this.cittaPartenza = cittaPartenza;
        this.cittaDestinazione = cittaDestinazione;
        this.compagniaVolo = compagniaVolo;
        this.capienza = capienza;
        this.giornoPartenza = giornoPartenza;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
    }

    @Override
    public int compareTo(Volo volo)
    {
        return this.giornoPartenza.compareTo(volo.getGiornoPartenza());
    }
}