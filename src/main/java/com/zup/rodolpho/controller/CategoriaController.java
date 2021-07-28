package com.zup.rodolpho.controller;

import com.zup.rodolpho.model.Categoria;
import com.zup.rodolpho.repository.CategoriaRepository;
import com.zup.rodolpho.request.CategoriaRequest;
import com.zup.rodolpho.validators.CategoriaUnicaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaUnicaValidator categoriaUnicaValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(categoriaUnicaValidator);
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@Valid @RequestBody CategoriaRequest dto) {

        Categoria categoria = categoriaRepository.save(dto.toModel());
        return ResponseEntity.ok(categoria);
    }
}
