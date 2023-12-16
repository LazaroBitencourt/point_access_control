package point_access_control.service.serviceImp;

import point_access_control.exception.*;
import point_access_control.model.NivelAcesso;
import point_access_control.repository.NivelAcessoRepository;
import point_access_control.service.NivelAcessoService;
import java.util.List;

import static java.util.Optional.ofNullable;

public class NivelAcessoImp implements NivelAcessoService {

    private final NivelAcessoRepository niveAcessoRepository;

    public NivelAcessoImp(NivelAcessoRepository niveAcessoRepository) {
        this.niveAcessoRepository = niveAcessoRepository;
    }

    @Override
    public NivelAcesso create(NivelAcesso entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Nível de acesso"));
        return  niveAcessoRepository.save(entity);
    }

    @Override
    public Iterable<NivelAcesso> findAll() {
        List<NivelAcesso> nivelAcessoList = niveAcessoRepository.findAll();
        if(nivelAcessoList.isEmpty()){
            throw new ElementsNotFound("Níveis de acesso");
        }
        return nivelAcessoList;
    }

    @Override
    public NivelAcesso findById(Long id) {
        return niveAcessoRepository.findById(id).orElseThrow(()-> new NotFoundException("Nível de acesso"));
    }
    @Override
    public NivelAcesso update(Long id, NivelAcesso entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Nível de acesso"));
        NivelAcesso nivelAcessodb = niveAcessoRepository.findById(id).orElseThrow(()-> new NotFoundException("Nível de acesso"));
        nivelAcessodb.setDescricao(entity.getDescricao());
        return nivelAcessodb;
    }
    @Override
    public void delete(Long id) {
        niveAcessoRepository.findById(id).orElseThrow(()-> new NotFoundException("Nível de acesso"));
        niveAcessoRepository.deleteById(id);
    }
}
