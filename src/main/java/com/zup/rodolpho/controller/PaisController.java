package com.zup.rodolpho.controller;

import com.zup.rodolpho.model.Pais;
import com.zup.rodolpho.repository.EstadoRepository;
import com.zup.rodolpho.repository.PaisRepository;
import com.zup.rodolpho.request.PaisRequest;
import com.zup.rodolpho.response.PaisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody PaisRequest dto) {

        Pais pais = paisRepository.save(dto.toModel());

        return ResponseEntity.ok(PaisResponse.toResponse(pais));
    }
}
