package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.NotFoundElementsException;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullException;
import point_access_control.model.JornadaTrabalho;
import point_access_control.repository.JornadaRepository;
import point_access_control.service.JornadaService;
import java.util.List;

@Service
public class JornadaServiceImp implements JornadaService {


    private final JornadaRepository jornadaRepository;


    public JornadaServiceImp(JornadaRepository jornadarepository) {

        jornadaRepository = jornadarepository;
    }

    @Override
    public JornadaTrabalho create(JornadaTrabalho entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        return jornadaRepository.save(entity);
    }
    @Override
    public Iterable<JornadaTrabalho> findAll() {
        List<JornadaTrabalho> jornadas = jornadaRepository.findAll();
        if(jornadas.isEmpty()){
            throw new NotFoundElementsException();
        }
        return jornadas;
    }

    @Override
    public JornadaTrabalho findById(Long id) {
        return jornadaRepository.findById(id).orElseThrow(()-> new NotFoundException());

    }

    @Override
    public JornadaTrabalho update(Long id, JornadaTrabalho entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        JornadaTrabalho jornada = jornadaRepository.findById(id).orElseThrow(()-> new NotFoundException());
        jornada.setDescricao(entity.getDescricao());
        return jornadaRepository.save(jornada);
    }

    @Override
    public void delete(Long id) {
        jornadaRepository.findById(id).orElseThrow(()-> new NotFoundException());
        jornadaRepository.deleteById(id);

    }
}
