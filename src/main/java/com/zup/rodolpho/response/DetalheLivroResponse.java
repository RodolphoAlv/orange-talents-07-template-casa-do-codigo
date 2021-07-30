package com.zup.rodolpho.response;

import com.zup.rodolpho.model.Livro;

import java.time.LocalDate;

public class DetalheLivroResponse {
    private String conteudo;
    private String sumario;
    private AutorSimplificadoResponse autor;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataDePublicacao;

    public DetalheLivroResponse(
            String conteudo,
            String sumario,
            AutorSimplificadoResponse autor,
            Integer numeroDePaginas,
            String isbn,
            LocalDate dataDePublicacao
    ) {
        this.conteudo = conteudo;
        this.sumario = sumario;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getSumario() {
        return sumario;
    }

    public AutorSimplificadoResponse getAutor() {
        return autor;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public static DetalheLivroResponse toDetalheLivroResponse(Livro livro) {
        return new DetalheLivroResponse(
                livro.getResumo(),
                livro.getSumario(),
                AutorSimplificadoResponse.toResponse(livro.getAutor()),
                livro.getNumeroDePaginas(),
                livro.getIsbn(),
                livro.getDataDePublicacao()
        );
    }
}
