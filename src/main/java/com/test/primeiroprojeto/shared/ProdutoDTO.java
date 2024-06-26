package com.test.primeiroprojeto.shared;


// o DTO é usado nas conversões controller/service service/controller

public class ProdutoDTO {   //é responsável por definir os daodos que eu quero transitar pela rede - assumiu o lugar do Model na tipagem usada na classe, a ideia do DTO é que o model não seja usado, e aqui se pode tirar alguns atributos que não podem sem passados para a rede, por conta da regra de negócio
  
    private Integer id;

    private String nome;

    private Integer quantidade;

    private Double valor;

    private String observacao;

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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
