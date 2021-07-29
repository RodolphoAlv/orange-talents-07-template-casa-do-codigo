package com.zup.rodolpho.response;

import com.zup.rodolpho.model.Livro;
import org.springframework.data.domain.Page;

import javax.persistence.Column;
import java.util.List;

public class ItemListaLivro {

    private Long id;
    private String titulo;

    public ItemListaLivro(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static Page<ItemListaLivro> toItemLista(Page<Livro>livros) {
        return livros.map(i -> new ItemListaLivro(i.getId(), i.getTitulo()));
    }
}
