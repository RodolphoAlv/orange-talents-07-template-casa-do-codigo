package com.zup.rodolpho.request;

import com.zup.rodolpho.model.Autor;
import com.zup.rodolpho.shared.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {
    @NotBlank
    @Email
    @UniqueValue(
            domainClass = Autor.class,
            fieldName = "email",
            message = "{autor.email.cadastrado}"
    )
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
