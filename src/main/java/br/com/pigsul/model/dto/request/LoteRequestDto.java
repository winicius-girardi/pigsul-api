package br.com.pigsul.model.dto.request;

import java.time.LocalDate;

public record LoteRequestDto(Integer idLote, LocalDate dataSaida,
                             Float pesoMedioAnimaisSaida,
                             Integer quantidadeAnimaisSaida
                             ) {
}
