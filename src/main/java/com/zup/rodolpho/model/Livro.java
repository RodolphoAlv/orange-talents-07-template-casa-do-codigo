package com.zup.rodolpho.model;

import com.zup.rodolpho.request.LivroRequest;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String resumo;
    @Column(length = 10485760)
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    @Column(unique = true)
    private String isbn;
    @Future
    private LocalDate dataDePublicacao;
    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;
    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    public Livro(){ }

    public Livro(LivroRequest livroRequest, Categoria categoria, Autor autor) {
        this.titulo = livroRequest.getTitulo();
        this.resumo = livroRequest.getResumo();
        this.sumario = livroRequest.getSumario();
        this.preco = livroRequest.getPreco();
        this.numeroDePaginas = livroRequest.getNumeroDePaginas();
        this.isbn = livroRequest.getIsbn();
        this.dataDePublicacao = livroRequest.getDataDePublicacao();
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
