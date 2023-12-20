package point_access_control.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.BancoHoras;
import point_access_control.service.BancoHorasService;

@RestController
@RequestMapping("/banco-horas")
public class BancoHorasController {

    private final BancoHorasService bancoHorasService;

    public BancoHorasController(BancoHorasService bancoHorasService) {
        this.bancoHorasService = bancoHorasService;
    }

    @PostMapping
    public ResponseEntity<BancoHoras> createBancoHoras(@RequestBody BancoHoras bancoHoras){
        return ResponseEntity.status(HttpStatus.CREATED).body(bancoHorasService.create(bancoHoras));
    }

    @GetMapping
    public ResponseEntity<Iterable<BancoHoras>> getBancoHorasList(){
        return ResponseEntity.ok(bancoHorasService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BancoHoras> getBancoHoras(@PathVariable Long id){
        return ResponseEntity.ok(bancoHorasService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BancoHoras> updateBancoHoras(@PathVariable Long id, @RequestBody BancoHoras bancoHoras){
        return ResponseEntity.ok(bancoHorasService.update(id, bancoHoras));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBancoHoras(@PathVariable Long id){
        bancoHorasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
