package br.uniparTADS.HelpMeAutoAjudaWEB.repositories;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginRepository {
    
    @Autowired
    private JdbcTemplate template;
    
    //INSERT
    public void salva(Usuario usuario) {
        String sql =
                "insert into usuario(" +
                    "id_usuario, " +
                    "email, " +
                    "name_usr, " +
                    "name_fan, " +
                    "ref_senha)" +
                "values(" +
                    "?, ?, ?, ?, ?)";
        
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
