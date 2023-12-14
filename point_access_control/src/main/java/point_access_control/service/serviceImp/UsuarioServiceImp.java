package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.model.Usuario;
import point_access_control.repository.UsuarioRepository;
import point_access_control.service.UsuarioService;

import static java.util.Optional.ofNullable;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository USUARIOREPOSITORY;

    public UsuarioServiceImp(UsuarioRepository usuariorepository) {
        USUARIOREPOSITORY = usuariorepository;
    }

    @Override
    public Usuario create(Usuario entity) {
       // ofNullable(entity).orElseThrow(()-> new );
        return null;
    }

    @Override
    public Iterable<Usuario> findAll() {
        return null;
    }

    @Override
    public Usuario findById(Long aLong) {
        return null;
    }

    @Override
    public Usuario update(Long aLong, Usuario entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
