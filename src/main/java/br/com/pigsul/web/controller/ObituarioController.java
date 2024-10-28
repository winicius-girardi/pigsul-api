package br.com.pigsul.web.controller;

import br.com.pigsul.model.dto.request.ObituarioRequestDto;
import br.com.pigsul.web.service.ObituarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("obituario")
@RestController
public class ObituarioController {

    private final ObituarioService obituarioService;
    //private final MapperService mapperService;

    @Autowired
    public ObituarioController(ObituarioService obituarioService) {
        this.obituarioService = obituarioService;
    }

    @GetMapping("v1/{idLote}")
    public ResponseEntity<?> getObituarioPeloLote(@PathVariable Integer idLote){
        return ResponseEntity.ok().body(obituarioService.getListObituarioByLoteId(idLote));

    }
    @PutMapping("v1/criar")
    public ResponseEntity<?> criaObituario(@RequestBody ObituarioRequestDto request){
        obituarioService.insertObituario(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
