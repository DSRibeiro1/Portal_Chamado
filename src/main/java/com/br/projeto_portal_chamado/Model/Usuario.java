package com.br.projeto_portal_chamado.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

//Nome tabela
@Entity
public class Usuario {

    // Id autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;
    private String cpf;
    private String login;

    // Relacionamento N,N. Criação de uma tabela associada
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tipo_usuario", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "tipo_id"))
    List<Tipo> tipos;

    // Relacionamento 1,N
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    List<Chamado> chamados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setUsuario(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    ///////////// Construtores/////////////////////////////////////////////////////////////

    public Usuario(Long id, String nome, String senha, String cpf, String login, List<Tipo> tipos,
            List<Chamado> chamados) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.login = login;
        this.tipos = tipos;
        this.chamados = chamados;
    }

    public Usuario() {
    }

}
