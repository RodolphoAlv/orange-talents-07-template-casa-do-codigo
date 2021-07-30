package com.zup.rodolpho.response;

import com.zup.rodolpho.model.Pais;

public class PaisResponse {
    private Long id;
    private String nome;

    public PaisResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static PaisResponse toResponse(Pais pais) {
        return new PaisResponse(pais.getId(), pais.getNome());
    }
}
