package br.uniparTADS.HelpMeAutoAjudaWEB.repositories;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Usuario, String> {
    
    
    
}
