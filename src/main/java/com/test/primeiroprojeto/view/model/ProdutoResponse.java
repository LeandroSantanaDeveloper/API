package com.test.primeiroprojeto.view.model;

public class ProdutoResponse {
    
    private Integer id;

    private String nome;

    private Integer quantidade;

    private Double valor;

    // getters e setters

    //#endregion

    //#region getrs and sets

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
