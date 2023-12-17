package point_access_control.service.serviceImp;


import org.springframework.stereotype.Service;
import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.Localidade;
import point_access_control.repository.LocalidadeRepository;
import point_access_control.service.LocalidadeService;

import java.util.List;

import static java.util.Optional.ofNullable;
@Service
public class LocalidadeServiceImp implements LocalidadeService {
    private final LocalidadeRepository localidadeRepository;

    public LocalidadeServiceImp(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    @Override
    public Localidade create(Localidade entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Localidade"));
        localidadeRepository.save(entity);
        return null;
    }

    @Override
    public Iterable<Localidade> findAll() {
        List<Localidade> localidades = localidadeRepository.findAll();
        if(localidades.isEmpty()){
            throw new ElementsNotFound("Localidade");
        }
        return localidades;
    }

    @Override
    public Localidade findById(Long id) {
        return localidadeRepository.findById(id).orElseThrow(()-> new NotFoundException("Localidade"));

    }

    @Override
    public Localidade update(Long id, Localidade entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Localidade"));
        Localidade localidadedb = localidadeRepository.findById(id).orElseThrow(()-> new NotFoundException("Localidade"));
        localidadedb.setDescricao(entity.getDescricao());
        localidadedb.setNivelAcesso(entity.getNivelAcesso());
        return localidadeRepository.save(localidadedb);
    }

    @Override
    public void delete(Long id) {
        localidadeRepository.findById(id).orElseThrow(()-> new NotFoundException("Localidade"));
        localidadeRepository.deleteById(id);
    }
}
