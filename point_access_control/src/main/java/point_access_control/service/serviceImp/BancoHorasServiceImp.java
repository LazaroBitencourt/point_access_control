package point_access_control.service.serviceImp;
import org.springframework.stereotype.Service;
import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.BancoHoras;
import point_access_control.repository.BancoHorasRepository;
import point_access_control.service.BancoHorasService;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class BancoHorasServiceImp implements BancoHorasService {

    private final BancoHorasRepository bancoHorasRepository;

    public BancoHorasServiceImp(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    @Override
    public BancoHoras create(BancoHoras entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Banco de horas"));
        return bancoHorasRepository.save(entity);
    }

    @Override
    public Iterable<BancoHoras> findAll() {
        List<BancoHoras> bancoHoras = bancoHorasRepository.findAll();
        if(bancoHoras.isEmpty()){
            throw new ElementsNotFound("Banco de horas");
        }
        return bancoHoras;
    }

    @Override
    public BancoHoras findById(Long id) {
        return bancoHorasRepository.findById(id).orElseThrow(()-> new NotFoundException("Banco de horas"));

    }

    @Override
    public BancoHoras update(Long id, BancoHoras entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Banco de horas"));
        BancoHoras bancoHoras = bancoHorasRepository.findById(id).orElseThrow(()-> new NotFoundException("Banco de horas"));
        bancoHoras.setQuantidadeHoras(entity.getQuantidadeHoras());
        bancoHoras.setSaldoHoras(entity.getSaldoHoras());
        bancoHoras.setDataTrabalhada(entity.getDataTrabalhada());
        return bancoHorasRepository.save(bancoHoras);
    }

    @Override
    public void delete(Long id) {
        bancoHorasRepository.findById(id).orElseThrow(()-> new NotFoundException("Banco de horas"));
        bancoHorasRepository.deleteById(id);
    }
}
