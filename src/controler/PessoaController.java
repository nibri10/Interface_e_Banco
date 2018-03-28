/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import com.mysql.jdbc.PreparedStatement;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import model.PessoaModal;



/**
 *
 * @author Nicolas
 */
public class PessoaController {
    
   private Connection connection;
   
   String nome;
   String datanasc;
   
   public PessoaController(){
    this.connection = new ConnectionFactory().getConnection(); 
   }
    
   public void AddPessoa(PessoaModal pessoa){
       String sql = "INSERT INTO usuario(nome,datanasc) VALUES(?,?)";
       
       try{ 
           PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql); // insere no banco de dados
       
           stmt.setString(1, pessoa.getNome());
           stmt.setString(2, pessoa.getDatanasc());
           stmt.execute();
           stmt.close();
       
       
       }catch(SQLException u){//mostra o erro caso nao funcionou a insercao
           throw new RuntimeException(u);
       }
   }
    
}
