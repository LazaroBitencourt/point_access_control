package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.Movimentacao;
import point_access_control.repository.MovimentacaoRepository;
import point_access_control.service.MovimentacaoService;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class MovimentacaoServiceImp implements MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoServiceImp(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    @Override
    public Movimentacao create(Movimentacao entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Movimentação"));
        movimentacaoRepository.save(entity);
        return null;
    }

    @Override
    public Iterable<Movimentacao> findAll() {
        List<Movimentacao> movimentacoes = movimentacaoRepository.findAll();
        if(movimentacoes.isEmpty()){
            throw new ElementsNotFound("Movimentações");
        }
        return movimentacoes;
    }

    @Override
    public Movimentacao findById(Long id) {
        return movimentacaoRepository.findById(id).orElseThrow(()-> new NotFoundException("Movimentação"));

    }

    @Override
    public Movimentacao update(Long id, Movimentacao entity) {
       ofNullable(entity).orElseThrow(()-> new NullField("Movimentação"));
       Movimentacao movimentacaodb = movimentacaoRepository.findById(id).orElseThrow(()-> new NotFoundException("Movimentação"));
        movimentacaodb.setCalendario(entity.getCalendario());
        movimentacaodb.setDataEntrada(entity.getDataEntrada());
        movimentacaodb.setDataSaida(entity.getDataSaida());
        movimentacaodb.setOcorrencia(entity.getOcorrencia());
        movimentacaodb.setPeriodo(entity.getPeriodo());
        return  movimentacaoRepository.save(movimentacaodb);
    }

    @Override
    public void delete(Long id) {
        movimentacaoRepository.findById(id).orElseThrow(()-> new NotFoundException("Movimentação"));
        movimentacaoRepository.deleteById(id);

    }
}
