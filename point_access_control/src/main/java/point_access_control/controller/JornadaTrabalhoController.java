package point_access_control.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.JornadaTrabalho;
import point_access_control.service.JornadaService;

@RestController
@RequestMapping("/jornada")
@Tag(name = "Jornada de trabalho controller", description = "RESTful API para gerênciar jornadas de trabalho.")
public class JornadaTrabalhoController{

    private final JornadaService jornadaService;

    public JornadaTrabalhoController(JornadaService jornadaService) {

        this.jornadaService = jornadaService;
    }

    @PostMapping
    @Operation(summary = "Criar jornada de trabalho", description = "Cria uma jornada de trabalho e retorna os seus dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jornada de trabalho criada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Jornada de trabalho inexistente")
    })
    public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.status(201).body(jornadaService.create(jornadaTrabalho));
    }


    @GetMapping
    @Operation(summary = "Obter todas jornada de trabalho", description = "Retorna um lista com todas jornadas de trabalho")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Operação bem sucedida"),
            @ApiResponse(responseCode = "404", description = "jornadas de trabalho inexistentes")
    })
    public ResponseEntity<Iterable<JornadaTrabalho>> getAllJornadas(){
       return ResponseEntity.ok( jornadaService.findAll());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Obter jornada de trabalho pelo ID", description = "Retorna um jornada de trabalho pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
            @ApiResponse(responseCode = "404", description = "Jornada de trabalho não encotrada")
    })
    public ResponseEntity<JornadaTrabalho> getJornada(@PathVariable Long id){
       return ResponseEntity.ok( jornadaService.findById(id));
    }


    @PutMapping("/{id}")
    @Operation(summary = "Atualizar jornada de trabalho", description = "Atualiza uma jornada de trabalho existente pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jornada de trabalho atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Jornada de trabalho não encontrada"),
            @ApiResponse(responseCode = "400", description = "Campo nulo existente")
    })
    public ResponseEntity<JornadaTrabalho> updateJornada(@PathVariable Long id,@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.ok(jornadaService.update(id,jornadaTrabalho));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar jornada de trabalho", description = "Deleta uma jornada de trabalho pelo ID")
    @ApiResponses(value = {
                    @ApiResponse(responseCode = "204", description = "Jornada de trabalho deletada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Jornada de trabalho não encontrada")})
    public ResponseEntity<Void> deleteJornada(@PathVariable Long id){
        jornadaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
