package com.test.primeiroprojeto.repository;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.test.primeiroprojeto.model.Produto;

@Repository
public class ProdutoRepository_old {

    private List<Produto> produtos = new ArrayList<Produto>();

    private Integer ultimoId = 0;

    public List<Produto> obterTodos() {
        return produtos;
    };

    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    };

    public Produto adicionar(Produto produto) {
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    };

    public void deletar(Integer id){
        produtos
        .removeIf(produto -> produto.getId() == id);
    };

    public Produto atualizar(Produto produto){
        deletar(produto.getId());
        produtos.add(produto);
        return produto;
    };
}
