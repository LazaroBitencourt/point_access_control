package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.NotFoundElementsException;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullException;
import point_access_control.model.CategoriaUsuario;
import point_access_control.repository.CategoriaUsuarioRepository;
import point_access_control.service.CategoriaUsuarioService;
import java.util.List;

@Service
public class CategoriaUsuarioServiceImp implements CategoriaUsuarioService {

    private final CategoriaUsuarioRepository categoriaUsuarioRepository;

    public CategoriaUsuarioServiceImp(CategoriaUsuarioRepository categoriaUsuarioRepository) {
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }

    @Override
    public CategoriaUsuario create(CategoriaUsuario entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        return categoriaUsuarioRepository.save(entity);
    }

    @Override
    public Iterable<CategoriaUsuario> findAll() {
        List<CategoriaUsuario> categorias = categoriaUsuarioRepository.findAll();
        if(categorias.isEmpty()){
            throw new NotFoundElementsException();
        }
        return categorias;
    }

    @Override
    public CategoriaUsuario findById(Long id) {
        return categoriaUsuarioRepository.findById(id).orElseThrow(()-> new NotFoundException());
    }

    @Override
    public CategoriaUsuario update(Long id, CategoriaUsuario entity) {
        if(entity == null || entity.getDescricao() == null){
            throw new NullException();
        }
        CategoriaUsuario categoriaUsuarioDb = categoriaUsuarioRepository.findById(id).orElseThrow(()-> new NotFoundException());
       categoriaUsuarioDb.setDescricao(entity.getDescricao());
        return categoriaUsuarioRepository.save(categoriaUsuarioDb);
    }

    @Override
    public void delete(Long id) {
        categoriaUsuarioRepository.findById(id).orElseThrow(()-> new NotFoundException());
        categoriaUsuarioRepository.deleteById(id);
    }
}
