package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.NotFoundElementsException;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullException;
import point_access_control.model.Movimentacao;
import point_access_control.repository.MovimentacaoRepository;
import point_access_control.service.MovimentacaoService;
import java.util.List;

@Service
public class MovimentacaoServiceImp implements MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoServiceImp(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    @Override
    public Movimentacao create(Movimentacao entity) {
        if(entity == null){
            throw new NullException();
        }
        movimentacaoRepository.save(entity);
        return null;
    }

    @Override
    public Iterable<Movimentacao> findAll() {
        List<Movimentacao> movimentacoes = movimentacaoRepository.findAll();
        if(movimentacoes.isEmpty()){
            throw new NotFoundElementsException();
        }
        return movimentacoes;
    }

    @Override
    public Movimentacao findById(Long id) {
        return movimentacaoRepository.findById(id).orElseThrow(()-> new NotFoundException());

    }

    @Override
    public Movimentacao update(Long id, Movimentacao entity) {
        if(entity == null){
            throw new NullException();
        }
        Movimentacao movimentacaodb = movimentacaoRepository.findById(id).orElseThrow(()-> new NotFoundException());
        movimentacaodb.setCalendario(entity.getCalendario());
        movimentacaodb.setDataEntrada(entity.getDataEntrada());
        movimentacaodb.setDataSaida(entity.getDataSaida());
        movimentacaodb.setOcorrencia(entity.getOcorrencia());
        movimentacaodb.setPeriodo(entity.getPeriodo());
        return  movimentacaoRepository.save(movimentacaodb);
    }

    @Override
    public void delete(Long id) {
        movimentacaoRepository.findById(id).orElseThrow(()-> new NotFoundException());
        movimentacaoRepository.deleteById(id);

    }
}
