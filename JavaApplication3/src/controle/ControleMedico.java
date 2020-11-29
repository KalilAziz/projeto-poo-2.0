/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloMedico;

/**
 *
 * @author kalil
 */
public class ControleMedico {
    ConexaoBD conex = new ConexaoBD();
    ModeloMedico mod = new ModeloMedico();
    
    public void salvar(ModeloMedico mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos (nome_medico,crm_medico,valor_medico) values (?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCrm());
            pst.setInt(3, mod.getValor());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados Inseridos Com Sucesso!!");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados!\nErro:" +ex);
        }
        
        
        conex.desconecta();
    }
}
