package point_access_control.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.NivelAcesso;
import point_access_control.service.NivelAcessoService;

@RestController
@RequestMapping(value = "/nivel-acesso")
public class NivelAcessoController {

    private final NivelAcessoService nivelAcessoService;

    public NivelAcessoController(NivelAcessoService nivelAcessoService) {
        this.nivelAcessoService = nivelAcessoService;
    }

    @PostMapping
    public ResponseEntity<NivelAcesso> createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return ResponseEntity.status(201).body(nivelAcessoService.create(nivelAcesso));
    }

    @GetMapping
    public ResponseEntity<Iterable<NivelAcesso>> getNivelAcessoList(){
        return ResponseEntity.ok(nivelAcessoService.findAll());
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<NivelAcesso> getNivelAcesso(@PathVariable Long id){
        return ResponseEntity.ok(nivelAcessoService.findById(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<NivelAcesso> updateNivelAcesso(@PathVariable Long id, @RequestBody NivelAcesso nivelAcesso){
        return ResponseEntity.ok(nivelAcessoService.update(id,nivelAcesso));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteNivelAcesso(@PathVariable Long id){
        nivelAcessoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
