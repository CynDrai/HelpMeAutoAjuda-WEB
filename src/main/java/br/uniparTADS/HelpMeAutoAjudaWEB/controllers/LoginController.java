package br.uniparTADS.HelpMeAutoAjudaWEB.controllers;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import br.uniparTADS.HelpMeAutoAjudaWEB.repositories.LoginRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    @Autowired
    private LoginRepository loginRepository;
    
    //Página Login
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("page", "loginCadastro/login");
        return "main";
    }
      
    //Página Cadastro
    @GetMapping({"/cadastro", "/cadastro/{id_usuario}"})
    public String cadastro(@PathVariable("id_usuario") Optional<Long> codigo, Model model) {
        model.addAttribute("cadastro", new Usuario());
        model.addAttribute("page", "loginCadastro/cadastro");
        return "main";
    }
    
    //Insert Banco de dados
    @PostMapping({"/cadastro", "/cadastro/{id_usuario}"})
    public String grava(@PathVariable("id_usuario") Optional<Long> codigo, Usuario usuario) {
        loginRepository.save(usuario);
              
        return "redirect:/login";
    }
    
}
