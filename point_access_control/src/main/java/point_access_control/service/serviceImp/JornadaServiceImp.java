package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.JornadaTrabalho;
import point_access_control.repository.JornadaRepository;
import point_access_control.service.JornadaService;
import java.util.List;
import static java.util.Optional.ofNullable;

@Service
public class JornadaServiceImp implements JornadaService {


    private final JornadaRepository jornadaRepository;


    public JornadaServiceImp(JornadaRepository jornadarepository) {

        jornadaRepository = jornadarepository;
    }

    @Override
    public JornadaTrabalho create(JornadaTrabalho jornadaTrabalho) {
        ofNullable(jornadaTrabalho.getDescricao()).orElseThrow(()-> new NullField("Jornada de trabalho"));
        return jornadaRepository.save(jornadaTrabalho);
    }
    @Override
    public Iterable<JornadaTrabalho> findAll() {
        List<JornadaTrabalho> jornadas = jornadaRepository.findAll();
        if(jornadas.isEmpty()){
            throw new ElementsNotFound("Jornada de Trabalho");
        }
        return jornadas;
    }

    @Override
    public JornadaTrabalho findById(Long id) {
        return jornadaRepository.findById(id).orElseThrow(()-> new NotFoundException("Jornada de Trabalho"));

    }

    @Override
    public JornadaTrabalho update(Long id, JornadaTrabalho jornadaTrabalho) {
        ofNullable(jornadaTrabalho.getDescricao()).orElseThrow(()-> new NullField("Jornada de Trabalho"));
        JornadaTrabalho jornada = jornadaRepository.findById(id).orElseThrow(()-> new NotFoundException("Jornada de Trabalho"));
        jornada.setDescricao(jornadaTrabalho.getDescricao());
        return jornadaRepository.save(jornada);
    }

    @Override
    public void delete(Long id) {
        jornadaRepository.findById(id).orElseThrow(()-> new NotFoundException("Jornada de Trabalho"));
        jornadaRepository.deleteById(id);

    }
}
