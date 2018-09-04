package br.uniparTADS.HelpMeAutoAjudaWEB.controllers;

import br.uniparTADS.HelpMeAutoAjudaWEB.model.Usuario;
import br.uniparTADS.HelpMeAutoAjudaWEB.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    
    @Autowired
    private LoginRepository loginRepository;
    
    @RequestMapping("/login")
    public String login() {
        return "loginCadastro/login";
    }
    
    //Possivel método a ser movido a outra classe
    //GET
    @RequestMapping(value="/cadastro", method=RequestMethod.GET)
    public String cadastro() {
        return "loginCadastro/cadastro";
    }
    
    //POST
    @RequestMapping(value="/cadastro", method=RequestMethod.POST)
    public String cadastro(Usuario usuario) {
        
        loginRepository.save(usuario);
        
        return "redirect:/cadastro";
    }
   
}
