package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.JornadaTrabalho;
import point_access_control.repository.JornadaRepository;
import point_access_control.service.JornadaService;
import java.util.List;
import java.util.NoSuchElementException;
import static java.util.Optional.ofNullable;

@Service
public class JornadaServiceImp implements JornadaService {


    private final JornadaRepository JORNADAREPOSITORY;


    public JornadaServiceImp(JornadaRepository jornadarepository) {

        JORNADAREPOSITORY = jornadarepository;
    }

    @Override
    public JornadaTrabalho create(JornadaTrabalho jornadaTrabalho) {
        ofNullable(jornadaTrabalho.getDescricao()).orElseThrow(()-> new NullField());
        return JORNADAREPOSITORY.save(jornadaTrabalho);
    }
    @Override
    public Iterable<JornadaTrabalho> findAll() {
        List<JornadaTrabalho> jornadas = JORNADAREPOSITORY.findAll();
        if(jornadas.isEmpty()){
            throw new ElementsNotFound();
        }
        return jornadas;
    }

    @Override
    public JornadaTrabalho findById(Long id) {
        return JORNADAREPOSITORY.findById(id).orElseThrow(()-> new NotFoundException());

    }

    @Override
    public JornadaTrabalho update(Long id, JornadaTrabalho jornadaTrabalho) {
        ofNullable(jornadaTrabalho.getDescricao()).orElseThrow(()-> new NullField());
        JornadaTrabalho jornada = JORNADAREPOSITORY.findById(id).orElseThrow(()-> new NotFoundException());
        jornada.setDescricao(jornadaTrabalho.getDescricao());
        return JORNADAREPOSITORY.save(jornada);
    }

    @Override
    public void delete(Long id) {
        JORNADAREPOSITORY.findById(id).orElseThrow(()-> new NotFoundException());
        JORNADAREPOSITORY.deleteById(id);

    }
}
