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
public class Fila {

    // Id autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    // Relacionamento 1,N
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fila")
    List<Chamado> chamados;

    ////////////////////////////////////////////////////////////////////////

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Long getId() {
        return id;
    }

    public Fila(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    ////////// Construtores////////////////////////////////////////////
    public Fila(Long id, String descricao, List<Chamado> chamados) {
        this.id = id;
        this.descricao = descricao;
        this.chamados = chamados;
    }

    public Fila() {
    }

}
