package com.br.projeto_portal_chamado.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//Nome tabela
@Entity
public class Produto {

    // Id autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Relacionamento 1,N
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    List<Chamado> chamados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    ///////////////// Contrutores/////////////////////////////////////
    public Produto(Long id, String nome, List<Chamado> chamados) {
        this.id = id;
        this.nome = nome;
        this.chamados = chamados;
    }

    public Produto() {
    }

}
