package br.com.pigsul.web.service;

import br.com.pigsul.model.dto.request.LoteRequestDto;
import br.com.pigsul.model.entity.Obituario;
import br.com.pigsul.model.repository.LoteRepository;
import br.com.pigsul.model.repository.ObituarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

    private final ObituarioRepository obituarioRepository;
    private final LoteRepository loteRepository;

    @Autowired
    public ValidatorService(LoteRepository loteRepository,ObituarioRepository obituarioRepository){
        this.loteRepository=loteRepository;
        this.obituarioRepository=obituarioRepository;
    }

    public boolean validaObituario(Obituario obituario)   {

        if(!validaIdLoteExiste(obituario.getIdLote()))
            return false;

        return true;
    }
    public boolean validaCampoInteger(Integer numero){

        return numero == null;
    }
    public boolean validaIdUsuario(Integer idUsuario){
        if (validaCampoInteger(idUsuario))
            System.out.println("id nulo");
       // if(usuarioRepository())
        return true;
    }

    public boolean validaIdLoteExiste(Integer idLote)   {

        if(validaCampoInteger(idLote))
            return  false;

        return !loteRepository.getIdLoteExists(idLote);
    }
    public boolean validaIntegerPositivo(Integer numero){
        return numero<0;
    }

    public void validaLoteRequest(LoteRequestDto loteRequest) {
        validaIdLoteExiste(loteRequest.idLote());
        validaCampoInteger(loteRequest.quantidadeAnimaisSaida());
        validaIntegerPositivo(loteRequest.quantidadeAnimaisSaida());
    }
}
