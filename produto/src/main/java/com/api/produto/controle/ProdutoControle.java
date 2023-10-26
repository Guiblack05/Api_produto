package com.api.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.repository.ProdutoRepositorio;
@RestController
@RequestMapping("/api")
public class ProdutoControle {
    //AÇÕES
    @Autowired
    private ProdutoRepositorio acoes;
    //Inicio
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody String inicio(){
        return"Bem vindo a API de Produto!";
    };
    //Sobre
    @RequestMapping(value = "/sobre", method = RequestMethod.GET)
    public @ResponseBody String sobre(){
        return "Sobre a API...";
    };
    //Contato
    @RequestMapping(value = "/contato", method = RequestMethod.GET)
    public @ResponseBody String contato(){
        return "Fale Conosco: ...";
    };
    //MANIPULAÇÃO DOS PRODUTOS

    //LISTAR PRODUTOS 
    @RequestMapping(value="/produtos", method = RequestMethod.GET)
    public @ResponseBody List<ProdutoModelo> listar(){
        return acoes.findAll(); 
    };
    //LISTA FILTRADA
    @RequestMapping(value="/produtos/{codigo}", method = RequestMethod.GET)
    public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo){
        return acoes.findByModelo(codigo);
    }
    //CADASTRAR PRODUTOS
    @RequestMapping(value = "/produtos" , method = RequestMethod.POST)
    public @ResponseBody ProdutoModelo cadastrar( @RequestBody ProdutoModelo produto){
        return acoes.save(produto);
    } 
    //ALTERAR
    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto){
        return acoes.save(produto);
    }
    //DELETAR 
    @RequestMapping(value ="/produtos/{codigo}", method = RequestMethod.DELETE)
    public @ResponseBody void deletar(@PathVariable Integer codigo){
        ProdutoModelo produto = filtrar(codigo);
        this.acoes.delete(produto);
    }
}