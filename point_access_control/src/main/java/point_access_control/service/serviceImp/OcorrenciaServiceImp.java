package point_access_control.service.serviceImp;

import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.Ocorrencia;
import point_access_control.repository.OcorrenciaRepository;
import point_access_control.service.OcorrenciaSevice;

import java.util.List;

import static java.util.Optional.ofNullable;

public class OcorrenciaServiceImp implements OcorrenciaSevice {

    private final OcorrenciaRepository ocorrenciaRepository;

    public OcorrenciaServiceImp(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Override
    public Ocorrencia create(Ocorrencia entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Ocorrêcia"));
        return  ocorrenciaRepository.save(entity);
    }

    @Override
    public Iterable<Ocorrencia> findAll() {
        List<Ocorrencia> ocorrencias =ocorrenciaRepository.findAll();
        if(ocorrencias.isEmpty()){
            throw new ElementsNotFound("Ocorrências");
        }
        return ocorrencias;
    }

    @Override
    public Ocorrencia findById(Long id) {
        return ocorrenciaRepository.findById(id).orElseThrow(()-> new NotFoundException("Ocorrência"));
    }
    @Override
    public Ocorrencia update(Long id, Ocorrencia entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Ocorrências"));
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(id).orElseThrow(()-> new NotFoundException("Ocorrêcia"));
        ocorrencia.setDescricao(entity.getDescricao());
        return ocorrencia;
    }
    @Override
    public void delete(Long id) {
        ocorrenciaRepository.findById(id).orElseThrow(()-> new NotFoundException("Ocorrência"));
        ocorrenciaRepository.deleteById(id);
    }
}
