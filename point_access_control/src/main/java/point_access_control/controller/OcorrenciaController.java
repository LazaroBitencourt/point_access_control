package point_access_control.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.Ocorrencia;
import point_access_control.service.OcorrenciaService;

@RestController
@RequestMapping(value = "/ocorrencia")
public class OcorrenciaController {

    private final OcorrenciaService ocorrenciaService;

    public OcorrenciaController(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> createOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaService.create(ocorrencia));
    }

    @GetMapping
    public ResponseEntity<Iterable<Ocorrencia>> getOcorrenciaList(){
        return ResponseEntity.ok(ocorrenciaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ocorrencia> getOcorrencia(@PathVariable Long id){
        return ResponseEntity.ok(ocorrenciaService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Ocorrencia> updateOcorrencia(@PathVariable Long id, @RequestBody Ocorrencia ocorrencia){
        return ResponseEntity.ok(ocorrenciaService.update(id, ocorrencia));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteOcorrencia(@PathVariable Long id){
        ocorrenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
