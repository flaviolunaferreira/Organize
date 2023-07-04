package the.coyote.usuarios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import the.coyote.usuarios.entities.UsuarioEntity;
import the.coyote.usuarios.exceptions.NotFound;
import the.coyote.usuarios.repository.PermissoesRepository;
import the.coyote.usuarios.repository.UsuarioRepository;

@Service
public class DetailService implements UserDetailsService {
    
    private final UsuarioRepository usuarioRepository;
    private final PermissoesRepository permissoesRepository;


    @Autowired
    public DetailService(UsuarioRepository usuarioRepository, PermissoesRepository permissoesRepository) {
		this.usuarioRepository = usuarioRepository;
		this.permissoesRepository = permissoesRepository;
	}

	@Override
    public UserDetails loadUserByUsername(String nomeDoUsuario) throws NotFound {
        UsuarioEntity seExiste = usuarioRepository.findByNome(nomeDoUsuario)
                .orElseThrow(() -> new NotFound("Usuário não encontrado!"));
        return UserConfig.criar(seExiste);
    }

}
