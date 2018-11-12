
package DAO;

import Modelo.Categoria;
import Modelo.Classificao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClassificaoDAO extends ExecuteSQL{
   public ClassificaoDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Classificao(Classificao a){

        String sql = "insert into classificacao values(0,?,?)";

        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            
             ps.setString(1, a.getNome());
             ps.setDouble(2, a.getPreco());
             
             if (ps.executeUpdate() > 0){
                 return "Inserido com sucesso.";
        } else {
                return "Erro ao inserir";
    }     
} catch (SQLException e) {
    return e.getMessage();
}
}
}

