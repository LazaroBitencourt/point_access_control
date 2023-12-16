package point_access_control.service.serviceImp;

import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.TipoData;
import point_access_control.repository.TipoDataRepository;
import point_access_control.service.TipoDataService;
import java.util.List;

import static java.util.Optional.ofNullable;
public class TipoDataServiceImp implements TipoDataService {

    private final TipoDataRepository tipoDataRepository;

    public TipoDataServiceImp(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    @Override
    public TipoData create(TipoData tipoData) {
        ofNullable(tipoData).orElseThrow(()-> new NullField("TipoData"));
        return tipoDataRepository.save(tipoData);
    }

    @Override
    public Iterable<TipoData> findAll() {
        List<TipoData> datas = tipoDataRepository.findAll();
        if(datas.isEmpty()){
            throw new ElementsNotFound("TipoData");
        }
        return datas;
    }

    @Override
    public TipoData findById(Long id) {
        return tipoDataRepository.findById(id).orElseThrow((()-> new NotFoundException("TipoData")));
    }

    @Override
    public TipoData update(Long id, TipoData entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("TipoData"));
        TipoData tipoDatadb = tipoDataRepository.findById(id).orElseThrow(()-> new NotFoundException("TipoData"));
        tipoDatadb.setDescricao(entity.getDescricao());
        tipoDataRepository.save(tipoDatadb);
        return tipoDatadb;
    }

    @Override
    public void delete(Long id) {
        tipoDataRepository.findById(id).orElseThrow(()-> new NotFoundException("TipoData"));
        tipoDataRepository.deleteById(id);
    }
}
