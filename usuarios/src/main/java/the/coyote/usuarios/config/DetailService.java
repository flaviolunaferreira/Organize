package the.coyote.usuarios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements UserDetailsService {
    
    private final UsuarioRepositorio usuarioRepositorio;
    private final PermissaoRepositorio permissaoRepositorio;

    @Autowired
    public DetalhesDoServicoUsuario(UsuarioRepositorio usuarioRepositorio, PermissaoRepositorio permissaoRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.permissaoRepositorio = permissaoRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String nomeDoUsuario) throws UsernameNotFoundException {
        UsuarioEntidade seExiste = usuarioRepositorio.findByNome(nomeDoUsuario)
                .orElseThrow(() -> new NaoEncontrado("Usuário não encontrado!"));
        return PrincipalUsuarioConfig.criar(seExiste);
    }

}
