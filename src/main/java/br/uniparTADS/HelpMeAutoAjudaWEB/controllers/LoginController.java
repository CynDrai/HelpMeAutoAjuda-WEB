package br.uniparTADS.HelpMeAutoAjudaWEB.controllers;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import br.uniparTADS.HelpMeAutoAjudaWEB.repositories.LoginRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    @Autowired
    private LoginRepository loginRepository;
    
    //Página Login
    @RequestMapping("/login")
    public String login() {
        return "loginCadastro/login";
    }
      
    //Página Cadastro
    @RequestMapping("/cadastro")
    public String cadastro(@PathVariable("codigo") Optional<Long> codigo, Model model) {
        model.addAttribute("cadastro", new Usuario());
        return "loginCadastro/cadastro";
    }
    
    //Insert Banco de dados
    @PostMapping({"/cadastro", "/cadastro/{id_usuario}"})
    public String grava(@PathVariable("id_usuario") Optional<Long> codigo, Usuario usuario) {
        loginRepository.save(usuario);
        
        return "redirect:/login";
    }
    
}
