package com.zup.rodolpho.repository;

import com.zup.rodolpho.model.Estado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
    @Query(value = "SELECT e.nome FROM estado e WHERE pais_id = :id AND e.nome = :nome", nativeQuery = true)
    List<String> findEstadoInPais(Long id, String nome);
}
