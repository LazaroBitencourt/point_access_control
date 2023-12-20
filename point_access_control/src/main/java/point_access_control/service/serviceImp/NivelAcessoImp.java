package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.*;
import point_access_control.model.NivelAcesso;
import point_access_control.repository.NivelAcessoRepository;
import point_access_control.service.NivelAcessoService;
import java.util.List;

@Service
public class NivelAcessoImp implements NivelAcessoService {

    private final NivelAcessoRepository niveAcessoRepository;

    public NivelAcessoImp(NivelAcessoRepository niveAcessoRepository) {
        this.niveAcessoRepository = niveAcessoRepository;
    }

    @Override
    public NivelAcesso create(NivelAcesso entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        return  niveAcessoRepository.save(entity);
    }

    @Override
    public Iterable<NivelAcesso> findAll() {
        List<NivelAcesso> nivelAcessoList = niveAcessoRepository.findAll();
        if(nivelAcessoList.isEmpty()){
            throw new NotFoundElementsException();
        }
        return nivelAcessoList;
    }

    @Override
    public NivelAcesso findById(Long id) {
        return niveAcessoRepository.findById(id).orElseThrow(()-> new NotFoundException());
    }
    @Override
    public NivelAcesso update(Long id, NivelAcesso entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        NivelAcesso nivelAcessodb = niveAcessoRepository.findById(id).orElseThrow(()-> new NotFoundException());
        nivelAcessodb.setDescricao(entity.getDescricao());
        return niveAcessoRepository.save(nivelAcessodb);
    }
    @Override
    public void delete(Long id) {
        niveAcessoRepository.findById(id).orElseThrow(()-> new NotFoundException());
        niveAcessoRepository.deleteById(id);
    }
}
