package point_access_control.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.CategoriaUsuario;
import point_access_control.service.CategoriaUsuarioService;

@RestController
@RequestMapping(value = "/categoria-usuario")
public class CategoriaUsuarioController {
    private final CategoriaUsuarioService categoriaUsuarioService;

    public CategoriaUsuarioController(CategoriaUsuarioService categoriaUsuarioService) {
        this.categoriaUsuarioService = categoriaUsuarioService;
    }

    @PostMapping
    public ResponseEntity<CategoriaUsuario> createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaUsuarioService.create(categoriaUsuario));
    }

    @GetMapping
    public ResponseEntity<Iterable<CategoriaUsuario>> getCategoriaUsuarioList(){
        return ResponseEntity.ok(categoriaUsuarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuario(@PathVariable Long id){
        return ResponseEntity.ok(categoriaUsuarioService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> updateCategoriaUsuario(@PathVariable Long id, @RequestBody CategoriaUsuario categoriaUsuario){
        return ResponseEntity.ok(categoriaUsuarioService.update(id, categoriaUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoriaUsuario(@PathVariable Long id){
        categoriaUsuarioService.delete(id);
       return ResponseEntity.noContent().build();
    }

}
