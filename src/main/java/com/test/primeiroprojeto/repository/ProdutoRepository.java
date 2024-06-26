package com.test.primeiroprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.primeiroprojeto.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {    //recebe como tipo o modelo do objeto e o tipo do id desse objeto

}
