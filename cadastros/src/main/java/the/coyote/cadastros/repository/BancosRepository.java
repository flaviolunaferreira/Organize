package the.coyote.cadastros.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import the.coyote.cadastros.entity.BancosEntity;

public interface BancosRepository extends PagingAndSortingRepository<BancosEntity, Integer> {

    List<BancosEntity> findAll();
    List<BancosEntity> findByNomeContainingIgnoreCase(String nome);

}
