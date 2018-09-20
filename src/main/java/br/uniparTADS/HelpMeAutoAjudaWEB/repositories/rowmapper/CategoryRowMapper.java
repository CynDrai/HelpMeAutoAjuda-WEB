package br.uniparTADS.HelpMeAutoAjudaWEB.repositories.rowmapper;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CategoryRowMapper implements RowMapper{

    @Override
    public Category mapRow(ResultSet rs, int i) throws SQLException {
        Integer id_category = rs.getInt("id_categoria");
        String nomeCategoria = rs.getString("nome_categoria");
        
        return new Category(id_category, nomeCategoria);
    }
        
}
