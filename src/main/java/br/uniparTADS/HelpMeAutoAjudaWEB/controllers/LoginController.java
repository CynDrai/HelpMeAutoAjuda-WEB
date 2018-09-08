package br.uniparTADS.HelpMeAutoAjudaWEB.controllers;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import br.uniparTADS.HelpMeAutoAjudaWEB.repositories.LoginRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    @Autowired
    private LoginRepository loginRepository;
    
    @RequestMapping("/login")
    public String login() {
        return "loginCadastro/login";
    }
      
    @RequestMapping("/cadastro")
    public String cadastro() {
        return "loginCadastro/cadastro";
    }
    
    @PostMapping({"/cadastro", "/cadastro/{id_usuario}"})
    public String grava(@PathVariable("id_usuario") Optional<Long> codigo, Usuario usuario) {
        loginRepository.salva(usuario);
        
        return "redirect:/login";
    }
    
}
