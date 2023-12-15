package point_access_control.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import point_access_control.model.Usuario;
import point_access_control.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuário Controller", description = "Gerenciamento de usuários.")
public class UsuarioController {

   private final  UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Operation(summary = "Criar usuário", description = "Cria um usuário e retorna os seus dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuário nulo ou contém campos nulos")
    } )
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
      return ResponseEntity.status(201).body(usuarioService.create(usuario));
    }

}
