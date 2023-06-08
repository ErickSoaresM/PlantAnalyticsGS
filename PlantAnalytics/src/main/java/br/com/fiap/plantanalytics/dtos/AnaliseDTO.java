package br.com.fiap.plantanalytics.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AnaliseDTO(

     @NotNull
     String resultado,
     String doenca,
     LocalDate dataEnvio,
    String tipoPlanta

     ) {
}
