package br.senac.tads.pi3.projetox.gerenprod.dao;

import br.senac.tads.pi3.projetox.gerenprod.connection.ConnectionFactory;
import br.senac.tads.pi3.projetox.gerenprod.model.Produto;
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
public class ProdutoDAO {
    
    public void salvar(Produto p){
        java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT into PRODUTOBD.PRODUTO(NOME, DESCRICAO, PRECO_COMPRA, PRECO_VENDA,"
                    + " QUANTIDADE, DISPONIVEL, DT_CADASTRO) VALUES(?,?,?,?,?,?,?);");
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco_compra());
            stmt.setDouble(4, p.getPreco_venda());
            stmt.setInt(5, p.getQuantidade());
            stmt.setBoolean(6, p.isDisponivel());
            stmt.setDate(7, data);
            
            stmt.executeUpdate();
            System.out.println("SAlvo com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        }finally{
           ConnectionFactory.fecharConexao(con, stmt); //fecha conexão e statement
        }
                       
    }
    
     public List<Produto> consultar(){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTO");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco_compra(rs.getDouble("preco_compra"));
                produto.setPreco_venda(rs.getDouble("preco_venda"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setDisponivel(rs.getBoolean("disponivel"));
                produto.setDt_cadastro(rs.getDate("dt_cadastro"));
                produtos.add(produto); // adiciona a lista os produtos retornados
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return produtos;   
     }
     public List<Produto> consultarPorNome(String nome){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTO WHERE nome LIKE ?;");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco_compra(rs.getDouble("preco_compra"));
                produto.setPreco_venda(rs.getDouble("preco_venda"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setDisponivel(rs.getBoolean("disponivel"));
                produto.setDt_cadastro(rs.getDate("dt_cadastro"));
                produtos.add(produto); // adiciona a lista os produtos retornados
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return produtos;   
     }
    
    public void atualizar(Produto p){
        java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE PRODUTO SET NOME  = ?, DESCRICAO   = ?, PRECO_COMPRA  = ?, PRECO_VENDA  = ?, QUANTIDADE = ?, DISPONIVEL = ?, DT_CADASTRO = ? WHERE id = ?;");
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco_compra());
            stmt.setDouble(4, p.getPreco_venda());
            stmt.setInt(5, p.getQuantidade());
            stmt.setBoolean(6, p.isDisponivel());
            stmt.setDate(7, data);
            stmt.setInt(8, p.getId());
            
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao atualizar");
        }finally{
           ConnectionFactory.fecharConexao(con, stmt); //fecha conexão e statement
        }
                       
    }
    public void deletar(Produto p){
        java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from produto WHERE id = ?;");
            
            stmt.setInt(1, p.getId());
            
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
