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
        
        //Método Gerador de ID
        usuario.setId_usuario(GeneratorID.returnID());
        
        //E-MAIL'S
        //Empty
        if(usuario.getEmail().isEmpty()) {
            return "*O campo E-mail não pode estar vazio!";
        }
        
        //E-mail com "@" e ".com"
        if(usuario.getEmail().contains("@")) {
            if(!usuario.getEmail().contains(".com")) {
                return "*E-mail's devem conter @ e .com";
            }
        } else return "*E-mail's devem conter @ e .com";
     
        //Verificador de E-mail e ID's já existentes
        byte bt = -1;
        while (bt != 0) {
            
            bt = vrfEmailId(usuario.getEmail(), usuario.getId_usuario());
            
            if(bt == 1) {
                return "*Este E-mail já está em uso!";
            }
            
            if(bt == 2) {
                usuario.setId_usuario(GeneratorID.returnID());
            }           
        }
        
        //NOME DE USUÁRIOS
        //Empty
        if(usuario.getNameUsr().isEmpty()) {
            return "*Insira um Nome de Usuário";
        }
        
        //Verificador de Números
        for (int a = 0; a < usuario.getNameUsr().length(); a++) {
            if (Character.isDigit(usuario.getNameUsr().charAt(a))) {
               return "*O campo Nome de Usuário não deve conter Números";
            }
        }
        
        //NOME FICTÍCIO
        //Mímino de 4 caracteres
        if(usuario.getNameFan().length() > 0 && usuario.getNameFan().length() < 4) {
            return "*O Nome Fictício deve conter no mínimo 4 caracteres";
        }
        
        //SENHA
        //Empty
        if(usuario.getRefSenha().isEmpty()) {
            return "*Insira uma Senha!";
        }
        
        //Mímino de 8 caracteres
        if(usuario.getRefSenha().length() < 8) {
            return "*A senha deve ter no mínimo 8 caracteres";
        }
          
        //SQL
        String sql= 
                "insert into usuario("
                    + "id_usuario, "
                    + "email, "
                    + "nameusr, "
                    + "namefan, "
                    + "refsenha)"
                + "values("
                    + "?, ?, ?, ?, ?)";
            
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

        return "*Cadastro feito com sucesso!";

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
