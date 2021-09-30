package modelDAO;

import controller.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import model.Endereco;
import model.Paciente;

public class EnderecoDAO {

    public int insertEndereco(Endereco endereco) {
        try{
            Connection con = DBConnection.connection();
            
            String sql = "INSERT INTO endereco(logradouro,cep,numero,bairro)" +
                            "VALUES(?, ?, ?, ?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, endereco.getLogradouro());
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getNumero());
            stmt.setString(4, endereco.getBairro());
            
            stmt.executeUpdate();
            
            String sqlPegarEndereco = "SELECT id_endereco FROM endereco WHERE ("
                    + "logradouro = ? AND "
                    + "cep = ? AND "
                    + "numero = ? AND "
                    + "bairro = ?"
                    + ")";
            PreparedStatement stmtPegarEndereco = con.prepareStatement(sqlPegarEndereco);
            
            stmtPegarEndereco.setString(1, endereco.getLogradouro());
            stmtPegarEndereco.setString(2, endereco.getCep());
            stmtPegarEndereco.setString(3, endereco.getNumero());
            stmtPegarEndereco.setString(4, endereco.getBairro());
            
            ResultSet result = stmtPegarEndereco.executeQuery();
            result.next();
            
            int id_endereco = result.getInt("id_endereco");
            con.close();
            return id_endereco;
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return -1;
    }
    
}
