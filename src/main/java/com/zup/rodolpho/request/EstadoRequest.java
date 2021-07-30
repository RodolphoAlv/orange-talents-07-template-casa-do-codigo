package com.zup.rodolpho.request;

import com.zup.rodolpho.model.Estado;
import com.zup.rodolpho.model.Pais;
import com.zup.rodolpho.shared.IdExists;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {
    @NotBlank
    private String nome;
    @NotNull
    @IdExists(
            domainClass = Pais.class,
            fieldName = "id",
            message = "{pais.nao.existe}"
    )
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toModel(Pais pais) {
        return new Estado(this.nome, pais);
    }
}
