package point_access_control.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.Localidade;
import point_access_control.model.Movimentacao;
import point_access_control.service.LocalidadeService;

@RestController
@RequestMapping(value = "/localidade")
public class LocalidadeController {

    private final LocalidadeService localidadeService;

    public LocalidadeController(LocalidadeService localidadeService) {
        this.localidadeService = localidadeService;
    }

    @PostMapping
    public ResponseEntity<Localidade> createLocalidade(@RequestBody Localidade localidade){
        return ResponseEntity.status(HttpStatus.CREATED).body(localidadeService.create(localidade));
    }

    @GetMapping
    public ResponseEntity<Iterable<Localidade>> getLocalidadeList(){
        return ResponseEntity.ok(localidadeService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Localidade> getLocalidade(@PathVariable Long id){
        return ResponseEntity.ok(localidadeService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Localidade> updateLocalidade (@PathVariable Long id, @RequestBody Localidade localidade){
        return ResponseEntity.ok(localidadeService.update(id, localidade));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteLocalidade(@PathVariable Long id){
        localidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
