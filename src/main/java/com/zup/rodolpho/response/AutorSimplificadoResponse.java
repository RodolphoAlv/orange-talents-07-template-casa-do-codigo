package com.zup.rodolpho.response;

import com.zup.rodolpho.model.Autor;

public class AutorSimplificadoResponse {
    private String nome;
    private String descricao;

    public AutorSimplificadoResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public static AutorSimplificadoResponse toResponse(Autor autor) {
        return new AutorSimplificadoResponse(autor.getNome(), autor.getDescricao());
    }
}
