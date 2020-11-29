/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kalil
 */
public class ConexaoBD {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/projetoclinica";
    private String usuario = "postgres";
    private String senha = "POSTGRES";
    public Connection con;
    
    public void conexao(){
        
        
        try {
            System.setProperty("jdbc.Drivers", driver);
            con=DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexão Efetuada com Sucesso!!!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados:\n" + ex.getMessage());
        }
        
    }
    
    public void desconecta(){
        try {
            con.close();
           // JOptionPane.showMessageDialog(null, "BD desconectado com sucesso!!!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com BD:\n" + ex.getMessage());
        }
    }
    
}
