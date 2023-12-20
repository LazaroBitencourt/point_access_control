package point_access_control.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.Calendario;
import point_access_control.service.CalendarioService;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    private final CalendarioService calendarioService;

    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    @PostMapping
    public ResponseEntity<Calendario> createCalendario(@RequestBody Calendario calendario){
        return ResponseEntity.status(HttpStatus.CREATED).body(calendarioService.create(calendario));
    }

    @GetMapping
    public ResponseEntity<Iterable<Calendario>> getCalendarioList(){
        return ResponseEntity.ok(calendarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Calendario> getCalendario(@PathVariable Long id){
        return ResponseEntity.ok(calendarioService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calendario> updateCalendario(@PathVariable Long id, @RequestBody Calendario calendario){
        return ResponseEntity.ok(calendarioService.update(id, calendario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendario(@PathVariable Long id){
        calendarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
