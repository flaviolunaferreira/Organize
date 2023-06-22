package the.coyote.usuarios.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

import the.coyote.usuarios.entities.PermissoesEntity;
import the.coyote.usuarios.uteis.PermissoesEnum;

public interface PermissoesRepository extends PagingAndSortingRepository<PermissoesEntity, Long> {

    PermissoesEntity findByPermissoesEnum(PermissoesEnum permissoesEnum);
    List<PermissoesEntity> findByUsuarioEntidade(Long usuario);

}
