/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.projetox.gerenprod.model;

import java.sql.Date;

/**
 *
 * @author Fabio
 */
public class Produto {
    private int     id;
    private String  nome;
    private String  descricao;
    private double  preco_compra;
    private double  preco_venda;
    private int     quantidade = 0;
    private boolean disponivel = true;
    private Date    dt_cadastro;
    
    
    public Produto(){
    
    }

    public Produto(String nome, String descricao, double preco_compra, double preco_venda,int quantidade, boolean disponivel) {
        
        this.nome = nome;
        this.descricao = descricao;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.quantidade = quantidade;
        this.disponivel= disponivel;
     
    }
    public Produto(int id,String nome, String descricao, double preco_compra, double preco_venda,int quantidade, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.quantidade = quantidade;
        this.disponivel= disponivel;
     
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco_compra=" + preco_compra + ", preco_venda=" + preco_venda + ", quantidade=" + quantidade + ", disponivel=" + disponivel + ", dt_cadastro=" + dt_cadastro + '}';
    }

    

}
