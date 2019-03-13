package br.senac.tads.pi3.projetox.gerenprod.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabio
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/PRODUTOBD?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";  //passwor sem senha, "" -> indica string vazia
    
    public static Connection obterConexao(){
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
                    
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro de conexão: " ,e);  //lança a excessão
        }
    }
    public static void fecharConexao(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void fecharConexao(Connection con, PreparedStatement stmt){
        fecharConexao(con);
            try {
               if(stmt != null){
                   stmt.close();
               }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs){
        fecharConexao(con, stmt);
            try {
               if(rs != null){
                   rs.close();
               }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}
