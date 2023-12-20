package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.NotFoundElementsException;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullException;
import point_access_control.model.Empresa;
import point_access_control.repository.EmpresaRepository;
import point_access_control.service.EmpresaService;
import java.util.List;

@Service
public class EmpresaServiceImp implements EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImp(EmpresaRepository empresaRepositoryl) {
        this.empresaRepository = empresaRepositoryl;
    }

    @Override
    public Empresa create(Empresa entity) {
        if(entity == null || entity.getNome() == null){
            throw new NullException();
        }
        return empresaRepository.save(entity);
    }

    @Override
    public Iterable<Empresa> findAll() {
        List<Empresa> empresas = empresaRepository.findAll();
        if(empresas.isEmpty()){
            throw new NotFoundElementsException();
        }
        return empresas;
    }

    @Override
    public Empresa findById(Long id) {
        return empresaRepository.findById(id).orElseThrow(()-> new NotFoundException());

    }

    @Override
    public Empresa update(Long id, Empresa entity) {
        if(entity == null || entity.getNome() == null){
            throw new NullException();
        }
        Empresa empresadb = empresaRepository.findById(id).orElseThrow(()-> new NotFoundException());
        empresadb.setDescricao(entity.getDescricao());
        empresadb.setBairro(entity.getBairro());
        empresadb.setCidade(entity.getCidade());
        empresadb.setCnpj(entity.getCnpj());
        empresadb.setEndereco(entity.getEndereco());
        empresadb.setEstado(entity.getEstado());
        empresadb.setTelefone(entity.getTelefone());
        return empresaRepository.save(empresadb);
    }

    @Override
    public void delete(Long id) {
        empresaRepository.findById(id).orElseThrow(()-> new NotFoundException());
        empresaRepository.deleteById(id);
    }
}
