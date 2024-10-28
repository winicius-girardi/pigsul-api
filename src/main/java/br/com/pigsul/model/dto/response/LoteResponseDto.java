package br.com.pigsul.model.dto.response;

import br.com.pigsul.model.entity.Origem;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LoteResponseDto(
        Integer idUsuario,
        Integer idLote,
        LocalDate dataEntradaLote,
        LocalDate dataSaidaLote,
        Boolean estadoLote,
        Integer quantidadeAnimaisAlojados,
        Float pesoMedioAnimaisEntrada,
        Float pesoMedioAnimaisSaida,
        Origem origem,
        String observacoes,
        Integer quantidadeAnimaisSaida
        ){
}
