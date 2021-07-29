package com.zup.rodolpho.request;

import com.zup.rodolpho.model.Categoria;
import com.zup.rodolpho.shared.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(
            domainClass = Categoria.class,
            fieldName = "nome",
            message = "{categoria.cadastrada}"
    )
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
