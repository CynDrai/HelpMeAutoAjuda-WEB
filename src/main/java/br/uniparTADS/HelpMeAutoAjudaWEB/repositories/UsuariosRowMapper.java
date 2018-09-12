package br.uniparTADS.HelpMeAutoAjudaWEB.repositories;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UsuariosRowMapper implements RowMapper {

    @Override
    public Usuario mapRow(ResultSet rs, int i) throws SQLException {
        Long id_usuario = rs.getLong("id_usuario");
        String email = rs.getString("email");
        String nameUsr = rs.getString("nameusr");
        String nameFan = rs.getString("namefan");
        String refSenha = rs.getString("refsenha");
        
        return new Usuario(id_usuario, email, nameUsr, nameFan, refSenha);
    }         
}
