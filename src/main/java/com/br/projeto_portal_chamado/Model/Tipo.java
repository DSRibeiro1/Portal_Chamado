package com.br.projeto_portal_chamado.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

//Nome tabela
@Entity
public class Tipo {

    // Id autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    // Relacionamento N,N
    @ManyToMany(mappedBy = "tipos", fetch = FetchType.EAGER)
    List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Long getId() {
        return id;
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

    ///////////////// Construtores//////////////////////////////////

    public Tipo(Long id, String descricao, List<Usuario> usuarios) {
        this.id = id;
        this.descricao = descricao;
        this.usuarios = usuarios;

    }

    public Tipo() {
    }

}
