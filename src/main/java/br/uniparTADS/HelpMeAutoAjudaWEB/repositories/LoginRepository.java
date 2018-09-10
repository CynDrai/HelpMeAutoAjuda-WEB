package br.uniparTADS.HelpMeAutoAjudaWEB.repositories;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import br.uniparTADS.HelpMeAutoAjudaWEB.util.GeneratorID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginRepository {
    
    @Autowired
    private JdbcTemplate template;
    
    //INSERT
    public void save(Usuario usuario) {
        String sql =
                "insert into usuario(" +
                    "id_usuario, " +
                    "email, " +
                    "nameusr, " +
                    "namefan, " +
                    "refsenha)" +
                "values(" +
                    "?, ?, ?, ?, ?)";
        
        //Método Gerador de ID
        //Será alterado no futuro
        usuario.setId_usuario(GeneratorID.returnID());
        
        Object[] parameters = {
                usuario.getId_usuario(),
                usuario.getEmail(),
                usuario.getNameUsr(),
                usuario.getNameFan(),
                usuario.getRefSenha()
        };
        
        template.update(sql, parameters);
        
    }
    
}
