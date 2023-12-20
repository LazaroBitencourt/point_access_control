package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.NotFoundElementsException;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullException;
import point_access_control.model.Calendario;
import point_access_control.repository.CalendarioRepository;
import point_access_control.service.CalendarioService;
import java.util.List;

@Service
public class CalendarioServiceImp implements CalendarioService {

   private final CalendarioRepository calendarioRepository;

    public CalendarioServiceImp(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    @Override
    public Calendario create(Calendario entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        return calendarioRepository.save(entity);
    }

    @Override
    public Iterable<Calendario> findAll() {
        List<Calendario> calendarios = calendarioRepository.findAll();
        if (calendarios.isEmpty()){
            throw new NotFoundElementsException();
        }
        return calendarios;
    }

    @Override
    public Calendario findById(Long id) {
        return calendarioRepository.findById(id).orElseThrow(()-> new NotFoundException());

    }

    @Override
    public Calendario update(Long id, Calendario entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        Calendario calendarioDb = calendarioRepository.findById(id).orElseThrow(()-> new NotFoundException());
        calendarioDb.setDescricao(entity.getDescricao());
        calendarioDb.setDataEspecial(entity.getDataEspecial());
        calendarioDb.setTipoData(entity.getTipoData());
        return calendarioRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        calendarioRepository.findById(id).orElseThrow(()-> new NotFoundException());
        calendarioRepository.deleteById(id);

    }
}
