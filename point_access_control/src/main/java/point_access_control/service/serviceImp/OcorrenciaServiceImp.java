package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.NotFoundElementsException;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullException;
import point_access_control.model.Ocorrencia;
import point_access_control.repository.OcorrenciaRepository;
import point_access_control.service.OcorrenciaService;
import java.util.List;

@Service
public class OcorrenciaServiceImp implements OcorrenciaService {

    private final OcorrenciaRepository ocorrenciaRepository;

    public OcorrenciaServiceImp(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Override
    public Ocorrencia create(Ocorrencia entity) {
        if(entity == null || entity.getNome() == null && entity.getDescricao() == null){
            throw new NullException();
        }
        return  ocorrenciaRepository.save(entity);
    }

    @Override
    public Iterable<Ocorrencia> findAll() {
        List<Ocorrencia> ocorrencias =ocorrenciaRepository.findAll();
        if(ocorrencias.isEmpty()){
            throw new NotFoundElementsException();
        }
        return ocorrencias;
    }

    @Override
    public Ocorrencia findById(Long id) {
        return ocorrenciaRepository.findById(id).orElseThrow(()-> new NotFoundException());
    }

    @Override
    public Ocorrencia update(Long id, Ocorrencia entity) {
        if(entity == null || entity.getNome() == null && entity.getDescricao() == null){
            throw new NullException();
        }
        Ocorrencia ocorrenciaDb = ocorrenciaRepository.findById(id).orElseThrow(()-> new NotFoundException());
        ocorrenciaDb.setDescricao(entity.getDescricao());
        return ocorrenciaRepository.save(ocorrenciaDb);
    }

    @Override
    public void delete(Long id) {
        ocorrenciaRepository.findById(id).orElseThrow(()-> new NotFoundException());
        ocorrenciaRepository.deleteById(id);
    }
}
