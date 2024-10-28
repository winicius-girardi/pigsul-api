package br.com.pigsul.model.dto.request;

public record ObituarioRequestDto(Integer idLote,
        Integer idCausaMorte,
        Integer quantidadeAnimaisMortos,
        Float pesoMedioEstimado
        ) {

}
