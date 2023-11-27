package com.br.projeto_portal_chamado.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//Nome tabela
@Entity
public class Chamado {

    // Id autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;
    private String titulo;
    private String descricao;
    private String historico;
    private boolean Status;

    // Relacionamento N,1. Tabela Forte
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fila fila;

    @ManyToOne(cascade = CascadeType.ALL)
    private Produto produto;

    //////////////////////////////////////////////////////////////////////////////////////////
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    /////// Construtores

    public Chamado(Long id, String data, String titulo, String historico, String descricao, boolean status) {
        this.id = id;
        this.data = data;
        this.titulo = titulo;
        this.historico = historico;
        this.descricao = historico;
        Status = status;
    }

    public Chamado() {
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Chamado [id=" + id + ", data=" + data + ", titulo=" + titulo + ", descricao=" + descricao
                + ", historico=" + historico + ", Status=" + Status + ", usuario=" + usuario + ", fila=" + fila
                + ", produto=" + produto + "]";
    }

    public void resolver() {
    }

}
