package com.test.primeiroprojeto.view.model;


//Representa o tipo de dado que ele espera receber quando alguém faz uma request ao back-end
public class ProdutoRequest {
    
    //private Integer id; // na request o id não é importante

    private String nome;

    private Integer quantidade;

    private Double valor;

    private String observacao;

    // getters e setters

    //#endregion

    //#region getrs and sets

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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
