package br.com.fiap.plantanalytics.dtos;

import java.util.List;

public record PaginationResponseDTO(
    int number,
    long totalElements,
    int totalPages,
    boolean first,
    boolean last
) {}
