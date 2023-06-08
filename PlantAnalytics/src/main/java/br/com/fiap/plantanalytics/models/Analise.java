package br.com.fiap.plantanalytics.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resultado;
    private String doenca;
    private LocalDate dataEnvio;
    private String tipoPlanta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_da_analise")
    @JsonIgnore
    private Usuario usuario;

}
