package com.zup.rodolpho.controller;

import com.zup.rodolpho.model.Estado;
import com.zup.rodolpho.model.Pais;
import com.zup.rodolpho.repository.EstadoRepository;
import com.zup.rodolpho.repository.PaisRepository;
import com.zup.rodolpho.request.EstadoRequest;
import com.zup.rodolpho.response.EstadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("estados")
public class EstadoController {

    private static final String ESTADO_EXISTE_NO_PAIS = "Este estado já está cadastrado neste país!";

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<EstadoResponse> cadastrar(@Valid @RequestBody EstadoRequest dto) {

        List<String> estados = estadoRepository
                .findEstadoInPais(dto.getPaisId(), dto.getNome());

        if(estados.isEmpty()){
            Pais pais = paisRepository.findById(dto.getPaisId()).get();
            Estado estado = estadoRepository.save(dto.toModel(pais));

            return ResponseEntity.ok(EstadoResponse.toResponse(estado));
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ESTADO_EXISTE_NO_PAIS);
    }
}
