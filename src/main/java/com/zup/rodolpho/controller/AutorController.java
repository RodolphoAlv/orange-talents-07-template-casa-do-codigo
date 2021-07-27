package com.zup.rodolpho.controller;

import com.zup.rodolpho.model.Autor;
import com.zup.rodolpho.repository.AutorRepository;
import com.zup.rodolpho.request.AutorRequest;
import com.zup.rodolpho.response.AutorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorResponse> cadastrar(@Valid @RequestBody AutorRequest autorRequest) {
        Autor autor = autorRepository.save(autorRequest.toModel());
        return ResponseEntity.ok(AutorResponse.toResponse(autor));
    }
}
