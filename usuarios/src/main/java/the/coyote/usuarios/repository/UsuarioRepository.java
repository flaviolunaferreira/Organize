package the.coyote.usuarios.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import the.coyote.usuarios.entities.UsuarioEntity;

public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long>{
    
    UsuarioEntity findUsuarioByCpf(String cpf);
    Optional<UsuarioEntity> findByNome(String usuario);
    Optional<UsuarioEntity> findById(Long usuario);
    
}
