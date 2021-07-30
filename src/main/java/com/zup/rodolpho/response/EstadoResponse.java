package com.zup.rodolpho.response;

import com.zup.rodolpho.model.Estado;

public class EstadoResponse {

    private Long id;
    private String nome;
    private Long paisId;

    public EstadoResponse(Long id, String nome, Long paisId) {
        this.id = id;
        this.nome = nome;
        this.paisId = paisId;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public static EstadoResponse toResponse(Estado estado) {
        return new EstadoResponse(
                estado.getId(),
                estado.getNome(),
                estado.getPais().getId()
        );
    }
}
