package com.zup.rodolpho.repository;

import com.zup.rodolpho.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
