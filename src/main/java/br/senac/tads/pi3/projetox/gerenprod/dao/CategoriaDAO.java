/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.projetox.gerenprod.dao;

import br.senac.tads.pi3.projetox.gerenprod.connection.ConnectionFactory;
import br.senac.tads.pi3.projetox.gerenprod.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabio
 */
public class CategoriaDAO {
    
    
    public void salvar(Categoria c){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT into PRODUTOBD.CATEGORIA(NOME) VALUES(?);");
            
            stmt.setString(1, c.getNome());
            stmt.executeUpdate();
            System.out.println("Categoria salva com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar categoria");
        }finally{
           ConnectionFactory.fecharConexao(con, stmt); //fecha conexão e statement
        }
                       
    }
    
     public List<Categoria> consultar(){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <Categoria> categorias = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM CATEGORIA");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));

                categorias.add(categoria); // adiciona a lista os produtos retornados
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return categorias;   
     }
     public List<Categoria> consultarPorNome(String nome){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <Categoria> categorias = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM CATEGORIA WHERE nome LIKE ?;");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
    
                categorias.add(categoria); // adiciona a lista os produtos retornados
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return categorias;   
     }
    
    public void atualizar(Categoria c){
        java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE CATEGORIA SET NOME  = ? WHERE id = ?;");
            
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getId());
            
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao atualizar");
        }finally{
           ConnectionFactory.fecharConexao(con, stmt); //fecha conexão e statement
        }
                       
    }
    public void deletar(Categoria c){
        java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from categoria WHERE id = ?;");
            
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            System.out.println("Excluido com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao excluir");
        }finally{
           ConnectionFactory.fecharConexao(con, stmt); //fecha conexão e statement
        }
                       
    }
}

