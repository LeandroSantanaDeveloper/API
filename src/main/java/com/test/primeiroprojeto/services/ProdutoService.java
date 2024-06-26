package com.test.primeiroprojeto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.primeiroprojeto.model.Produto;
import com.test.primeiroprojeto.model.exception.ResourceNotFoundException;
import com.test.primeiroprojeto.repository.ProdutoRepository;
import com.test.primeiroprojeto.shared.ProdutoDTO;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> obterTodos(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
        .collect(Collectors.toList());
    };

    public Optional<ProdutoDTO> obterPorId(Integer id){
        //Obtendo optional de produto por id
        Optional<Produto> produto =  produtoRepository.findById(id);
        //Se não encontrar lança exception
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto com id: "+ id + " não encontrado");
        }
        //Convertendo o Optional de Produto em um Produto DTO
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        //Retornando o que o método espera
        return Optional.of(dto);
    };

    public ProdutoDTO adicionar(ProdutoDTO produtoDTO){
        // Removendo id para fazer cadastro
        produtoDTO.setId(null);
        //Criar obj de mapeamento
        ModelMapper mapper = new ModelMapper();
        //Converter DTO em Produto
        Produto produto = mapper.map(produtoDTO, Produto.class);
        //Salvar Produto no banco
        produto = produtoRepository.save(produto);
        produtoDTO.setId(produto.getId());
        //Retornar o DTO atualizado
        return produtoDTO;
    }

    public void deletar(Integer id){
        //veriicar se o produto existe
        Optional<Produto> produto = produtoRepository.findById(id);
        // Se não existir lanca uma exception
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível deletar produto com id: " + id + " - Produto não existe");
        }
        produtoRepository.deleteById(id);
    };

    public ProdutoDTO atualizar(ProdutoDTO produtoDTO, Integer id){

        Optional<Produto> produtoEncontrado = produtoRepository.findById(id);
        if(!produtoEncontrado.isPresent()) {
            throw new ResourceNotFoundException("Não é possível atualizar o produto com o id " + id + " Produto não encontrado (tratamento service)");
        } 

        //Passar o id para ProdutoDTO
        produtoDTO.setId(id);
        //Criar obj de mapeamento
        ModelMapper maapper = new ModelMapper();
        //Converter o DTO em um Produto
        Produto produto = maapper.map(produtoDTO, Produto.class);
        //Atualizar o produto no banco
        produtoRepository.save(produto);
        //Retorna o DTO atualizado
        return produtoDTO;
    }
}
