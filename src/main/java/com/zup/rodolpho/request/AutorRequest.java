package com.zup.rodolpho.request;

import com.zup.rodolpho.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toModel() {
        return new Autor(this);
    }
}
