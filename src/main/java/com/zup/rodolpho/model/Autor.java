package com.zup.rodolpho.model;

import com.zup.rodolpho.request.AutorRequest;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime instante = LocalDateTime.now();
    private String email;
    private String nome;
    private String descricao;

    public Autor() {
    }

    public Autor(AutorRequest autorRequest) {
        this.email = autorRequest.getEmail();
        this.nome = autorRequest.getNome();
        this.descricao = autorRequest.getDescricao();
    }

    public Autor(Long id) {
        this.id = id;
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
}
