package point_access_control.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.Usuario;
import point_access_control.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final  UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
      return ResponseEntity.status(201).body(usuarioService.create(usuario));
    }

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> getUsuarioList(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> getUsuario (@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.update(id,usuario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
