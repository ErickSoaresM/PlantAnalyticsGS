package br.com.fiap.plantanalytics.errors;

public record RestValidationError(
        Integer code,
        String field,
        String message
) {}
