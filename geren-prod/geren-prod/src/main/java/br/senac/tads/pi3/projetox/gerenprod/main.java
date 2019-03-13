/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.projetox.gerenprod;

import br.senac.tads.pi3.projetox.gerenprod.dao.CategoriaDAO;
import br.senac.tads.pi3.projetox.gerenprod.dao.ProdutoDAO;
import br.senac.tads.pi3.projetox.gerenprod.model.Categoria;
import br.senac.tads.pi3.projetox.gerenprod.model.Produto;
import java.text.SimpleDateFormat;


/**
 *
 * @author Fabio
 */
public class main {
    public static void main (String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Produto p1 = new Produto("Java como programar","Java POO", 157.00, 300.00, 10, true );
        Produto p2 = new Produto("Livro das sombras","Sonetos", 30.00, 57.00, 5 ,true);
        
        ProdutoDAO produto = new ProdutoDAO();
        
        produto.salvar(p1);
        produto.salvar(p2);
        
        Produto p4 = new Produto(2, "Atualizando", "Atualizado com sucesso", 50, 100, 100, true);
      
       //(int id,String nome, String descricao, double preco_compra, double preco_venda,int quantidade, boolean disponivel) 
       produto.atualizar(p4);
       produto.deletar(p4);
       ProdutoDAO testeRetorno = new ProdutoDAO();
       for(Produto prods: testeRetorno.consultar()){
           System.out.println(prods);
       }
       System.out.println("\n\n\n\n=======teste busca por nome======\n\n");
       ProdutoDAO testeRetornoBuscaPorNome = new ProdutoDAO();
       for(Produto prods: testeRetornoBuscaPorNome.consultarPorNome("java")){
           System.out.println(prods);
       }
       
       Categoria cat1 = new Categoria();
       cat1.setNome("Livros");
       
       CategoriaDAO catDao = new CategoriaDAO();
       
       catDao.salvar(cat1);
    }
}
