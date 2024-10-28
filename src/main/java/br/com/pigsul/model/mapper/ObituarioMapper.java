package br.com.pigsul.model.mapper;

import br.com.pigsul.model.dto.request.ObituarioRequestDto;
import br.com.pigsul.model.entity.Obituario;

public class ObituarioMapper {


    public Obituario requestToEntity(ObituarioRequestDto novoObituario) {
        return new Obituario(novoObituario.idLote(),novoObituario.idCausaMorte(),
                novoObituario.quantidadeAnimaisMortos(),novoObituario.pesoMedioEstimado());
    }
}
