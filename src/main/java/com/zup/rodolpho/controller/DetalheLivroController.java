package com.zup.rodolpho.controller;

import com.zup.rodolpho.model.Livro;
import com.zup.rodolpho.repository.LivroRepository;
import com.zup.rodolpho.response.DetalheLivroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("livros/detalhes")
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("{id}")
    public ResponseEntity<DetalheLivroResponse> detalhes(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);

        return livro.map(i -> ResponseEntity.ok(
                DetalheLivroResponse.toDetalheLivroResponse(i)
        )).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
