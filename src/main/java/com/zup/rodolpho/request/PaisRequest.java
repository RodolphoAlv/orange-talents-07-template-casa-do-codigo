package com.zup.rodolpho.request;

import com.zup.rodolpho.model.Pais;
import com.zup.rodolpho.shared.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {
    @NotBlank
    @UniqueValue(
            domainClass = Pais.class,
            fieldName = "nome",
            message = "{pais.cadastrado}"
    )
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
