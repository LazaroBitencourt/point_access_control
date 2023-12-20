package point_access_control.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.Movimentacao;
import point_access_control.service.MovimentacaoService;

@RestController
@RequestMapping(value = "/movimentacao")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }
    @PostMapping
    public ResponseEntity<Movimentacao> createMovimentacao(@RequestBody Movimentacao movimentacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoService.create(movimentacao));
    }

    @GetMapping
    public ResponseEntity<Iterable<Movimentacao>> getMovimentacaoList(){
        return ResponseEntity.ok(movimentacaoService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Movimentacao> getMovimentacao(@PathVariable Long id){
        return ResponseEntity.ok(movimentacaoService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movimentacao> updateMovimentacao (@PathVariable Long id, @RequestBody Movimentacao movimentacao){
        return ResponseEntity.ok(movimentacaoService.update(id, movimentacao));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMovimentacao(@PathVariable Long id){
        movimentacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
