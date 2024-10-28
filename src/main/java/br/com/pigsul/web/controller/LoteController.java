package br.com.pigsul.web.controller;

import br.com.pigsul.model.dto.request.LoteRequestDto;
import br.com.pigsul.web.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("lote")
@RestController
public class LoteController {

    private final LoteService loteService;

    @Autowired
    public LoteController (LoteService loteService){
        this.loteService=loteService;
    }

    @GetMapping("/v1/user/{userId}")
    public ResponseEntity<?> getLoteListByUserId(@PathVariable int userId,
                                                 @RequestBody Boolean estado
                                                ){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loteService.getLoteListByUserId(userId,estado));

    }
    @GetMapping("/v1/user/{userId}/{loteId}")
    public ResponseEntity<?> getLoteByUserId(@PathVariable int userId){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loteService.getLoteByLoteId(userId));

    }

    @PutMapping("v1/lote/{loteId}")
    public ResponseEntity<?> changeLoteByLoteId(@PathVariable int loteId,
                                                @RequestBody LoteRequestDto loteRequest
                                                ){
        loteService.changeLoteByLoteId(loteId,loteRequest);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }


}
