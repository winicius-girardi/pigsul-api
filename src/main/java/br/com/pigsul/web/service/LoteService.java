package br.com.pigsul.web.service;

import br.com.pigsul.model.dto.request.LoteRequestDto;
import br.com.pigsul.model.dto.response.LoteResponseDto;
import br.com.pigsul.model.entity.Lote;
import br.com.pigsul.model.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteService {

    private final LoteRepository loteRepository;

    private final ValidatorService validatorService;

    @Autowired
    public LoteService(LoteRepository loteRepository, ValidatorService validatorService) {
        this.loteRepository = loteRepository;
        this.validatorService = validatorService;
    }


    public List<LoteResponseDto> getLoteListByUserId(Integer userId, Boolean estadoLote) {
        List<Lote> loteList = loteRepository.getLoteListByUserId(userId, estadoLote);

        return loteList.stream().map(lote -> new LoteResponseDto(lote.getIdUsuario(),
                                lote.getIdLote(), lote.getDataEntradaLote(), lote.getDataSaidaLote(),
                                lote.getEstadoLote(), lote.getQuantidadeAnimaisAlojados(),
                                lote.getPesoMedioAnimaisEntrada(), lote.getPesoMedioAnimaisSaida(),
                                lote.getOrigem(), lote.getObservacoes(), lote.getQuantidadeAnimaisSaida()
                        )
                )
                .toList();

    }

    public Lote getLoteByLoteId(Integer loteId) {
        return loteRepository.getLoteByLoteId(loteId);
    }

    public void changeLoteByLoteId(int loteId, LoteRequestDto loteRequest) {
        validatorService.validaLoteRequest(loteRequest);
        loteRepository.changeLoteByLoteId(loteId, loteRequest);

    }
}