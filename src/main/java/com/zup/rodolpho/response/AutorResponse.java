package com.zup.rodolpho.response;

import com.zup.rodolpho.model.Autor;

import java.time.LocalDateTime;

public class AutorResponse {
    private Long id;
    private LocalDateTime instante;
    private String email;
    private String nome;
    private String descricao;

    public AutorResponse(){}

    public AutorResponse(Autor autor) {
        this.id = autor.getId();
        this.instante = autor.getInstante();
        this.email = autor.getEmail();
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public static AutorResponse toResponse(Autor autor) {
        return new AutorResponse(autor);
    }
}
