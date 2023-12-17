package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.Calendario;
import point_access_control.repository.CalendarioRepository;
import point_access_control.service.CalendarioService;
import java.util.List;
import static java.util.Optional.ofNullable;

@Service
public class CalendarioServiceImp implements CalendarioService {

   private final CalendarioRepository calendarioRepository;

    public CalendarioServiceImp(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    @Override
    public Calendario create(Calendario entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Calendario"));
        return calendarioRepository.save(entity);
    }

    @Override
    public Iterable<Calendario> findAll() {
        List<Calendario> calendarios = calendarioRepository.findAll();
        if (calendarios.isEmpty()){
            throw new ElementsNotFound("calendarios");
        }
        return calendarios;
    }

    @Override
    public Calendario findById(Long id) {
        return calendarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Calendario"));

    }

    @Override
    public Calendario update(Long id, Calendario entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Calendario"));
        Calendario calendarioDb = calendarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Calendario"));
        calendarioDb.setDescricao(entity.getDescricao());
        calendarioDb.setDataEspecial(entity.getDataEspecial());
        calendarioDb.setTipoData(entity.getTipoData());
        return calendarioRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        calendarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Calendario"));
        calendarioRepository.deleteById(id);

    }
}
