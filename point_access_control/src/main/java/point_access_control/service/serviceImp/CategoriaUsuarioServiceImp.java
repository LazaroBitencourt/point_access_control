package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.CategoriaUsuario;
import point_access_control.repository.CategoriaUsuarioRepository;
import point_access_control.service.CategoriaUsuarioService;

import java.util.List;

import static java.util.Optional.ofNullable;
@Service
public class CategoriaUsuarioServiceImp implements CategoriaUsuarioService {

    private final CategoriaUsuarioRepository categoriaUsuarioRepository;

    public CategoriaUsuarioServiceImp(CategoriaUsuarioRepository categoriaUsuarioRepository) {
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }

    @Override
    public CategoriaUsuario create(CategoriaUsuario entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Categoria de usuário"));
        return categoriaUsuarioRepository.save(entity);
    }

    @Override
    public Iterable<CategoriaUsuario> findAll() {
        List<CategoriaUsuario> categorias = categoriaUsuarioRepository.findAll();
        if(categorias.isEmpty()){
            throw new ElementsNotFound("categorias de usuário");
        }
        return categorias;
    }

    @Override
    public CategoriaUsuario findById(Long id) {
        return categoriaUsuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("categoria de usuário"));
    }

    @Override
    public CategoriaUsuario update(Long id, CategoriaUsuario entity) {
        ofNullable(entity).orElseThrow(()-> new NullField("Categoria de usuário"));
        CategoriaUsuario categoriaUsuarioDb = categoriaUsuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("categoria de usuário"));
       categoriaUsuarioDb.setDescricao(entity.getDescricao());
        return categoriaUsuarioDb;
    }

    @Override
    public void delete(Long id) {
        categoriaUsuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("categoria de usuário"));
        categoriaUsuarioRepository.deleteById(id);
    }
}
