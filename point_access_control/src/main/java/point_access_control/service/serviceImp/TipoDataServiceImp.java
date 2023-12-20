package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.NotFoundElementsException;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullException;
import point_access_control.model.TipoData;
import point_access_control.repository.TipoDataRepository;
import point_access_control.service.TipoDataService;
import java.util.List;

@Service
public class TipoDataServiceImp implements TipoDataService {

    private final TipoDataRepository tipoDataRepository;

    public TipoDataServiceImp(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    @Override
    public TipoData create(TipoData entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        return tipoDataRepository.save(entity);
    }

    @Override
    public Iterable<TipoData> findAll() {
        List<TipoData> datas = tipoDataRepository.findAll();
        if(datas.isEmpty()){
            throw new NotFoundElementsException();
        }
        return datas;
    }

    @Override
    public TipoData findById(Long id) {
        return tipoDataRepository.findById(id).orElseThrow((()-> new NotFoundException()));
    }

    @Override
    public TipoData update(Long id, TipoData entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        TipoData tipoDatadb = tipoDataRepository.findById(id).orElseThrow(()-> new NotFoundException());
        tipoDatadb.setDescricao(entity.getDescricao());
        tipoDataRepository.save(tipoDatadb);
        return tipoDatadb;
    }

    @Override
    public void delete(Long id) {
        tipoDataRepository.findById(id).orElseThrow(()-> new NotFoundException());
        tipoDataRepository.deleteById(id);
    }
}
