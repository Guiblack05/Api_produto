/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.produto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.produto.modelo.ProdutoModelo;

/**
 *
 * @author Home
 */
public interface ProdutoRepositorio extends CrudRepository <ProdutoModelo, Integer> {
    //LISTAR TODOS OS PRODUTOS
    List<ProdutoModelo> findAll();
    //PESQUSIAR POR CODIGO
    ProdutoModelo findByModelo(int codigo);
    //REMOVER PRODUTO
    void delete(ProdutoModelo produto);
    //CADASTRAR / ALTERAR PRODUTO
    <Temporario extends ProdutoModelo> Temporario save(Temporario produto);

}
