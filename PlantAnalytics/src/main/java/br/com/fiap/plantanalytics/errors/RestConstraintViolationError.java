package br.com.fiap.plantanalytics.errors;

public record RestConstraintViolationError(
        int code,
        Object field,
        String message
) {}
