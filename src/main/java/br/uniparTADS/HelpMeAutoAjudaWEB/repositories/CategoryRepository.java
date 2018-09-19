package br.uniparTADS.HelpMeAutoAjudaWEB.repositories;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepository {
    
    @Autowired
    private JdbcTemplate template;
    
    //SELECT: List of All Categories
    public List<Category> listCategories() {
        String sql =
                "select * from categoria";
        
        return template.query(sql, new CategoryRowMapper());
    }
    
}
