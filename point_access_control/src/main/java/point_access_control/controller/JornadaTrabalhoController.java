package point_access_control.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.JornadaTrabalho;
import point_access_control.service.JornadaService;

@RestController
@RequestMapping(value = "/jornada")
public class JornadaTrabalhoController{

    private final JornadaService jornadaService;
    public JornadaTrabalhoController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    @PostMapping
    public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.status(201).body(jornadaService.create(jornadaTrabalho));
    }

    @GetMapping
    public ResponseEntity<Iterable<JornadaTrabalho>> getJornadaList(){
       return ResponseEntity.ok( jornadaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JornadaTrabalho> getJornada(@PathVariable Long id){
       return ResponseEntity.ok( jornadaService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<JornadaTrabalho> updateJornada(@PathVariable Long id,@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.ok(jornadaService.update(id,jornadaTrabalho));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteJornada(@PathVariable Long id){
        jornadaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
