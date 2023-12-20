package point_access_control.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import point_access_control.model.TipoData;
import point_access_control.service.TipoDataService;



@RestController
@RequestMapping(value = "/tipo-data")
public class TipoDataController {

    private final TipoDataService tipoDataService;

    public TipoDataController(TipoDataService tipoDataService) {
        this.tipoDataService = tipoDataService;
    }

    @PostMapping
    public ResponseEntity<TipoData> createTipoData(@RequestBody TipoData tipoData){
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoDataService.create(tipoData));
    }

    @GetMapping
    public ResponseEntity<Iterable<TipoData>> getTipoDataList(){
        return ResponseEntity.ok(tipoDataService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoData> getTipoData (@PathVariable Long id){
        return ResponseEntity.ok(tipoDataService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoData> updateTipoData (@PathVariable Long id, @RequestBody TipoData tipoData){
        return ResponseEntity.ok(tipoDataService.update(id, tipoData));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTipoData(@PathVariable Long id){
        tipoDataService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
