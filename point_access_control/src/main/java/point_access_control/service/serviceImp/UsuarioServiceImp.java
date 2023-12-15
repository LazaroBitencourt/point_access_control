package point_access_control.service.serviceImp;

import org.springframework.stereotype.Service;
import point_access_control.exception.ElementsNotFound;
import point_access_control.exception.NotFoundException;
import point_access_control.exception.NullField;
import point_access_control.model.Usuario;
import point_access_control.repository.UsuarioRepository;
import point_access_control.service.UsuarioService;
import java.util.List;
import static java.util.Optional.ofNullable;


@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImp(UsuarioRepository usuariorepository) {
        usuarioRepository = usuariorepository;
    }

    @Override
    public Usuario create(Usuario usuario) {
        ofNullable(usuario).orElseThrow(()-> new NullField("Usuário"));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Iterable<Usuario> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.isEmpty()){
            throw new ElementsNotFound("Usuários");
        }
        return usuarios;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuário"));
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        ofNullable(usuario).orElseThrow(()-> new NullField("Usuário"));
        Usuario usuarioDb = usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuário"));
        usuarioDb.setCategoriaUsuario(usuario.getCategoriaUsuario());
        usuarioDb.setNome(usuario.getNome());
        usuarioDb.setEmpresa(usuario.getEmpresa());
        usuarioDb.setNivelAcesso(usuario.getNivelAcesso());
        usuarioDb.setJornadaTrabalho(usuario.getJornadaTrabalho());
        usuarioDb.setTolerancia(usuario.getTolerancia());
        usuarioDb.setInicioJornada(usuario.getInicioJornada());
        usuarioDb.setFinalJornada(usuario.getFinalJornada());
        usuarioRepository.save(usuarioDb);
        return usuarioDb;
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuario"));
        usuarioRepository.deleteById(id);


    }
}
