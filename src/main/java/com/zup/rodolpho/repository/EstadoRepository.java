package com.zup.rodolpho.repository;

import com.zup.rodolpho.model.Estado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
    @Query(value = "SELECT e.nome FROM estado e WHERE pais_id = :id AND e.nome = :nome", nativeQuery = true)
    List<String> findEstadoInPais(Long id, String nome);

    @Query(value = "SELECT e FROM Estado e WHERE e.pais.id = :idPais AND e.id = :idEstado")
    Optional<Estado> findEstadoInPais(@Param("idPais") Long idPais, @Param("idEstado") Long idEstado);
}
