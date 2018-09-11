package br.uniparTADS.HelpMeAutoAjudaWEB.repositories;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import br.uniparTADS.HelpMeAutoAjudaWEB.util.GeneratorID;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginRepository {

    @Autowired
    private JdbcTemplate template;

    //INSERT
    public String save(Usuario usuario) {
        String sql
                = "insert into usuario("
                    + "id_usuario, "
                    + "email, "
                    + "nameusr, "
                    + "namefan, "
                    + "refsenha)"
                + "values("
                    + "?, ?, ?, ?, ?)";

        //Método Gerador de ID
        usuario.setId_usuario(GeneratorID.returnID());

        byte bt = -1;

        //Verificador de E-mail e ID's já existentes
        while (bt != 0) {
            
            bt = vrfEmailId(usuario.getEmail(), usuario.getId_usuario());
            
            if(bt == 1) {
                return "Este E-mail já está em uso!";
            }
            
            if(bt == 2) {
                usuario.setId_usuario(GeneratorID.returnID());
            }           
        }
        
        //Paramêtros SQL
        Object[] parameters = {
            usuario.getId_usuario(),
            usuario.getEmail(),
            usuario.getNameUsr(),
            usuario.getNameFan(),
            usuario.getRefSenha()
        };

        //INSERT
        template.update(sql, parameters);

        return "Cadastro feito com sucesso!";

    }

    //Verificador de E-mail e ID's repetidos
    public byte vrfEmailId(String email, Long id) {

        List al = new ArrayList();

        String sql
                = "select * from usuario where "
                + "email = ? or id_usuario = ?";

        //Paramêtros WHERE SQL
        Object[] parameters = {
            email,
            id
        };

        //Lista de Usuários gerada pelos Paramêtros
        al = template.query(sql, parameters, new UsuariosRowMapper());

        //Se == 1 -> E-mail repetido, Se == 2 -> Id repetido
        for (int i = 0; i < al.size(); i++) {
            Usuario usuario = (Usuario) al.get(i);

            //E-mail
            if (usuario.getEmail().equals(email)) {
                return 1;
            }

            //ID
            if (usuario.getId_usuario() == id) {
                return 2;
            }
        }

        return 0;
    }

}
