package com.zup.rodolpho.request;

import com.zup.rodolpho.model.Cliente;
import com.zup.rodolpho.model.Estado;
import com.zup.rodolpho.model.Pais;
import com.zup.rodolpho.shared.CpfOuCnpj;
import com.zup.rodolpho.shared.IdExists;
import com.zup.rodolpho.shared.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {
    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CpfOuCnpj
    @UniqueValue(domainClass = Cliente.class, fieldName = "cpfOuCnpj")
    private String cpfOuCnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @IdExists(domainClass = Pais.class, fieldName = "id")
    private Long paisId;
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

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

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(@NotNull Pais pais, Estado estado) {
        return new Cliente(pais, estado, this);
    }
}
