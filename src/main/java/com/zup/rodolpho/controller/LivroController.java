package com.zup.rodolpho.controller;

import com.zup.rodolpho.model.Autor;
import com.zup.rodolpho.model.Categoria;
import com.zup.rodolpho.model.Livro;
import com.zup.rodolpho.repository.AutorRepository;
import com.zup.rodolpho.repository.CategoriaRepository;
import com.zup.rodolpho.repository.LivroRepository;
import com.zup.rodolpho.request.LivroRequest;
import com.zup.rodolpho.response.ItemListaLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId()).get();
        Autor autor = autorRepository.findById(dto.getAutorId()).get();

        Livro livro = livroRepository.save(dto.toModel(categoria, autor));
        return ResponseEntity.ok(livro);

    }

    @GetMapping
    public ResponseEntity<Page<ItemListaLivro>> listar(
            @PageableDefault(sort= "id", direction = Sort.Direction.ASC)
            Pageable pageable
    ) {
        Page<Livro> livros = livroRepository.findAll(pageable);
        return ResponseEntity.ok(ItemListaLivro.toItemLista(livros));
    }
}
