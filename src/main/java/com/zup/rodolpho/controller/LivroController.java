package com.zup.rodolpho.controller;

import com.zup.rodolpho.model.Autor;
import com.zup.rodolpho.model.Categoria;
import com.zup.rodolpho.model.Livro;
import com.zup.rodolpho.repository.AutorRepository;
import com.zup.rodolpho.repository.CategoriaRepository;
import com.zup.rodolpho.repository.LivroRepository;
import com.zup.rodolpho.request.LivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Livro> cadastrar(@Valid @RequestBody LivroRequest dto) {

        Optional<Categoria> categoria = categoriaRepository.findById(dto.getCategoriaId());
        Optional<Autor> autor = autorRepository.findById(dto.getAutorId());

        if(categoria.isPresent() && autor.isPresent()){
            Livro livro = livroRepository.save(dto.toModel(categoria.get(), autor.get()));
            return ResponseEntity.ok(livro);
        }

        return ResponseEntity.badRequest().build();
    }
}
