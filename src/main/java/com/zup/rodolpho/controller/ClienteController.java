package com.zup.rodolpho.controller;

import com.zup.rodolpho.model.Cliente;
import com.zup.rodolpho.model.Estado;
import com.zup.rodolpho.model.Pais;
import com.zup.rodolpho.repository.ClienteRepository;
import com.zup.rodolpho.repository.EstadoRepository;
import com.zup.rodolpho.repository.PaisRepository;
import com.zup.rodolpho.request.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<Long> cadastrar(@Valid @RequestBody ClienteRequest dto) {
        Estado estado = null;
        Pais pais = paisRepository.findById(dto.getPaisId()).get();

        if(!pais.getEstados().isEmpty())
            estado = estadoRepository.findEstadoInPais(
                    dto.getPaisId(),
                    dto.getEstadoId()
            ).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado não encontrado no país!"));

        Cliente cliente = dto.toModel(pais, estado);
        clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente.getId());
    }
}
