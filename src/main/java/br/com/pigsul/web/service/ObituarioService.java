package br.com.pigsul.web.service;


import br.com.pigsul.model.dto.request.ObituarioRequestDto;
import br.com.pigsul.model.entity.Obituario;
import br.com.pigsul.model.mapper.ObituarioMapper;
import br.com.pigsul.model.repository.ObituarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObituarioService {

    private final ObituarioRepository obituarioRepository;
    private final ValidatorService validatorService;

    @Autowired
    public ObituarioService(ObituarioRepository obituarioRepository,
                            ValidatorService validatorService) {
        this.validatorService=validatorService;
        this.obituarioRepository = obituarioRepository;
    }

    public List<?> getListObituarioByLoteId(Integer loteId){
        return obituarioRepository.getObituarioByLoteId( loteId);
    }


    public void insertObituario(ObituarioRequestDto obituarioRequestDto) {
        ObituarioMapper obituarioMapper = new ObituarioMapper();
        Obituario obituario= obituarioMapper.requestToEntity(obituarioRequestDto);

        //ARRUMAR FLUXO COM EXCEÇÕES
        if(validatorService.validaObituario(obituario)) {
            System.out.println("id informado nao eh valido");
            return;
        }

        obituarioRepository.createObituario(obituario);
    }
}
