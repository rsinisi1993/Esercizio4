package it.apulia.LibreriaAutenticata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "passeggeri")
@AllArgsConstructor
@NoArgsConstructor
public class Passeggero
{
    @Id
    private String idPasseggero;
    private String nome;
    private String cognome;
    private String email;
    private List<Contatto> listaContatti;
}