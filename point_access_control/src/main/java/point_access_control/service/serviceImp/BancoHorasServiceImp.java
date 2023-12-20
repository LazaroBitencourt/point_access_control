package point_access_control.service.serviceImp;
import org.springframework.stereotype.Service;
import point_access_control.exception.NotFoundElementsException;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullException;
import point_access_control.model.BancoHoras;
import point_access_control.repository.BancoHorasRepository;
import point_access_control.service.BancoHorasService;
import java.util.List;

@Service
public class BancoHorasServiceImp implements BancoHorasService {

    private final BancoHorasRepository bancoHorasRepository;

    public BancoHorasServiceImp(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    @Override
    public BancoHoras create(BancoHoras entity) {
        if(entity == null){
            throw new NullException();
        }
        return bancoHorasRepository.save(entity);
    }

    @Override
    public Iterable<BancoHoras> findAll() {
        List<BancoHoras> bancoHoras = bancoHorasRepository.findAll();
        if(bancoHoras.isEmpty()){
            throw new NotFoundElementsException();
        }
        return bancoHoras;
    }

    @Override
    public BancoHoras findById(Long id) {
        return bancoHorasRepository.findById(id).orElseThrow(()-> new NotFoundException());

    }

    @Override
    public BancoHoras update(Long id, BancoHoras entity) {
        if(entity == null){
            throw new NullException();
        }
        BancoHoras bancoHoras = bancoHorasRepository.findById(id).orElseThrow(()-> new NotFoundException());
        bancoHoras.setQuantidadeHoras(entity.getQuantidadeHoras());
        bancoHoras.setSaldoHoras(entity.getSaldoHoras());
        bancoHoras.setDataTrabalhada(entity.getDataTrabalhada());
        return bancoHorasRepository.save(bancoHoras);
    }

    @Override
    public void delete(Long id) {
        bancoHorasRepository.findById(id).orElseThrow(()-> new NotFoundException());
        bancoHorasRepository.deleteById(id);
    }
}
