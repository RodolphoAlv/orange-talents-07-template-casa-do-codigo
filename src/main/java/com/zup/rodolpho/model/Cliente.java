package com.zup.rodolpho.model;

import com.zup.rodolpho.request.ClienteRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @NotNull
    private String nome;
    @NotNull
    private String sobrenome;
    @NotNull
    @Column(unique = true)
    private String cpfOuCnpj;
    @NotNull
    private String endereco;
    @NotNull
    private String complemento;
    @NotNull
    private String cidade;
    @NotNull
    @OneToOne
    private Pais pais;
    @OneToOne
    private Estado estado;
    @NotNull
    private String telefone;
    @NotNull
    private String cep;

    @Deprecated
    public Cliente() {}

    public Cliente(Pais pais, Estado estado, ClienteRequest dto) {
        this.email = dto.getEmail();
        this.nome = dto.getNome();
        this.sobrenome = dto.getSobrenome();
        this.cpfOuCnpj = dto.getCpfOuCnpj();
        this.endereco = dto.getEndereco();
        this.complemento = dto.getComplemento();
        this.cidade = dto.getCidade();
        this.pais = pais;
        this.estado = estado;
        this.telefone = dto.getTelefone();
        this.cep = dto.getCep();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
