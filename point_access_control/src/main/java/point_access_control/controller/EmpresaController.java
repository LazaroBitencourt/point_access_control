package point_access_control.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.Empresa;
import point_access_control.service.EmpresaService;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa){
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.create(empresa));
    }

    @GetMapping
    public ResponseEntity<Iterable<Empresa>> getEmpresaList(){
        return ResponseEntity.ok(empresaService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Empresa> updateEmpresa (@PathVariable Long id, @RequestBody Empresa empresa){
        return ResponseEntity.ok(empresaService.update(id, empresa));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id){
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
