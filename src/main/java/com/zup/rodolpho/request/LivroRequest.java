package com.zup.rodolpho.request;

import com.zup.rodolpho.model.Autor;
import com.zup.rodolpho.model.Categoria;
import com.zup.rodolpho.model.Livro;
import com.zup.rodolpho.shared.UniqueValue;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {
    @NotBlank
    @UniqueValue(
            domainClass = Livro.class,
            fieldName = "titulo",
            message = "{livro.titulo.cadastrado}"
    )
    private String titulo;
    @NotBlank
    private String resumo;
    private String sumario;
    @NotNull
    private BigDecimal preco;
    @NotNull
    private Integer numeroDePaginas;
    @NotBlank
    @UniqueValue(
            domainClass = Livro.class,
            fieldName = "isbn",
            message = "{livro.isbn.cadastrado}"
    )
    private String isbn;
    @Future
    private LocalDate dataDePublicacao;
    private Long categoriaId;
    private Long autorId;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Livro toModel(Categoria categoria, Autor autor) {
        return new Livro(this, categoria, autor);
    }
}
